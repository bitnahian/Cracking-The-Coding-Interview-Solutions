package LinkedList;


public class Node {
    Node next = null;
    Node prev = null;
    Integer data;

    public Node(Integer d){
        this.data = d;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}

