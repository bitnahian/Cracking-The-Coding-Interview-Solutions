package LinkedList;

import sun.awt.image.ImageWatched;

import java.util.HashMap;

public class LinkedList {
    public Node head;
    public Node tail;
    public int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public LinkedList(Node head) {
        this.head = head;
        Node n = head;

        while(n.next != null) {
            n = n.next;
        }

        this.tail = n;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void appendToHead(int d) {
        Node start = new Node(d);

        if(this.head == null && this.tail == null) {
            this.head = start;
            this.tail = start;
            return;
        }

        Node firstNode = this.head;
        firstNode.prev = start;
        start.next = firstNode;
        this.head = start;
        this.length++;
    }


    public void appendToTail(int d) {
        Node end = new Node(d);
        if(this.head == null && this.tail == null) {
            this.head = end;
            this.tail = end;
            return;
        }

        Node lastNode = this.tail;
        lastNode.next = end;
        end.prev = lastNode;
        this.tail = end;
        this.length++;
    }

    public void removeNode(int d) {
        if(this.head.data == d) {
            this.head = this.head.next;
            this.head.prev = null;
            this.length--;
            return;
        }

        if(this.tail.data == d) {
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.length--;
            return;
        }

        Node n = this.head;

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



    // O(1) space but O(n^2) run time
    public void removeDupsWithRunner() {
        Node current = this.head;

        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
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

        Node n = this.head;

        // Find count of all characters
        while(n.next != null) {
            if(map.containsKey(n.data))
                map.put(n.data, map.get(n.data)+1);
            else
                map.put(n.data, 1);
            n = n.next;
        }

        n = this.head;

        while(n.next != null) {
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

        if(this.head == null)
            return "[]";

        if(this.head.equals(this.tail))
        {
            return "[ " + this.head.data + " ]";
        }

        StringBuilder builder = new StringBuilder();
        Node n = this.head;
        builder.append("[ ");
        while(n != null) {
            builder.append(n.data);
            builder.append(", ");
            n = n.next;
        }
        builder.setLength(builder.length()-2);
        builder.append(" ]");

        return builder.toString();
    }

    public Node kthToLast(int k) {
        Index index = new Index();

        return kthToLast(this.getHead(), k, index);
    }

    public Node kthToLast(Node node, int k, Index idx) {
        if(node == null)
            return null;

        Node newNode = this.kthToLast(node.next, k, idx);
        idx.value++;

        if(idx.value == k)
            return node;

        return newNode;
    }

    public class Index {
        public int value = 0;
    }

    public static Node parition(Node node, int x) {

        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while(node != null) {
            Node next = node.next;
            node.next = null;
            node.prev = null;
//            System.out.println("here");
            if(node.data < x) {
                if(beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }
                else {
                    beforeEnd.next = node;
                    node.prev = beforeEnd;
                    beforeEnd = node;
                }
            }
            else {
                if(afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                }
                else{
                    afterEnd.next = node;
                    node.prev = afterEnd;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if(beforeStart == null)
            return afterStart;

        // Merge before list and after list
        beforeEnd.next = afterStart;
        afterStart.prev = beforeEnd;

        return beforeStart;
    }

    public static int changeToNumber(Node node, int level) {
        if(node == null)
            return 0;

        return (int) Math.pow(10, level)*node.data + changeToNumber(node.next, level+1);

    }


    public static Node sumLists(Node n1, Node n2, int carry) {

        if(n1 == null || n2 == null) {
            return (carry > 0) ? new Node(1) : null;
        }

        int nData = n1.data+n2.data + carry;
        carry = (nData >= 10) ? 1 : 0;
        nData = nData%10;

        Node node = new Node(nData);

        node.next = sumLists(n1.next, n2.next, carry);

        return node;

    }
}


