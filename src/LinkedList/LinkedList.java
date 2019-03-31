package LinkedList;

import java.util.HashMap;

public class LinkedList {
    public Node head;
    public Node tail;
    public int length;

    public LinkedList() {
        this.head = new Node(null);
        this.tail = new Node(null);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public LinkedList(int d) {
        Node n = new Node(d);

        this.head = new Node(null);
        this.tail = new Node(null);

        this.head.next = n;
        this.tail.prev = n;

        this.length = 0;

    }

    public Node getHead() {
        return this.head.next;
    }

    public Node getTail() {
        return this.tail.prev;
    }

    public void appendToHead(int d) {
        Node start = new Node(d);
        Node firstNode = this.head.next;
        firstNode.prev = start;
        start.prev = this.head;
        start.next = firstNode;
        this.head.next = start;
        this.length++;
    }


    public void appendToTail(int d) {
        Node end = new Node(d);
        Node lastNode = this.tail.prev;
        lastNode.next = end;
        end.next = this.tail;
        end.prev = lastNode;
        this.tail.prev = end;
        this.length++;
    }

    public void removeNode(int d) {
        if(this.head.next.data == d) {
            this.head.next = this.head.next.next;
            this.head.next.prev = this.head;
            this.length--;
            return;
        }

        if(this.tail.prev.data == d) {
            this.tail.prev = this.tail.prev.prev;
            this.tail.prev.next = this.tail;
            this.length--;
            return;
        }

        Node n = this.head.next;

        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
                n.next.prev = n;
                this.length--;
                return;
            }
            n = n.next;
        }
    }

    public Node removeHead() {
        Node head = this.head.next;
        this.head.next = head.next;
        this.head.next.prev = this.head;
        this.length--;
        return head;
    }

    public Node removeTail() {
        Node tail = this.tail.prev;
        this.tail.prev = tail.prev;
        this.tail.prev.next = this.tail;
        this.length--;
        return tail;
    }


    // O(1) space but O(n^2) run time
    public void removeDupsWithRunner() {
        Node current = this.head.next;

        while(!current.equals(this.tail)) {
            Node runner = current;
            while(!runner.equals(this.tail)) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                    this.length--;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    // O(n) but O(n) space
    public void removeDups() {
        HashMap<Integer, Integer> map = new HashMap<>();

        Node n = this.head.next;

        // Find count of all characters
        while(n.next != null) {
            if(n.data == null)
                break;
            if(map.containsKey(n.data))
                map.put(n.data, map.get(n.data)+1);
            else
                map.put(n.data, 1);
            n = n.next;
        }

        n = this.head.next;

        while(n.next != null) {
            if(n.data==null)
                break;
            if(map.get(n.data) > 1){
                // Remove this node and make count go down
                n.prev.next = n.next;
                n.next.prev = n.prev;
                // Reduce the count
                map.put(n.data, map.get(n.data)-1);
                this.length--;
            }
            n = n.next;
        }
    }

    @Override
    public String toString() {

        if(this.head.equals(this.tail))
        {
            return "[ " + this.head.data + " ]";
        }

        StringBuilder builder = new StringBuilder();
        Node n = this.head.next;
        builder.append("[ ");
        while(n.next != null) {
            builder.append(n.data);
            builder.append(", ");
            n = n.next;
        }
        builder.setLength(builder.length()-2);
        builder.append(" ]");

        return builder.toString();
    }
}
