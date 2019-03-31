package LinkedList;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void appendToHead() {
        LinkedList list = new LinkedList();
        list.appendToHead(-1);
        System.out.println(list);
        assertEquals(-1, list.getHead().data.intValue());
        list.appendToHead(-2);
        System.out.println(list);
        assertEquals(-2, list.getHead().data.intValue());

    }

    @Test
    public void appendToTail() {
        LinkedList list = new LinkedList();
        list.appendToTail(-1);
        System.out.println(list);
        assertEquals(-1, list.getTail().data.intValue());
        list.appendToTail(-2);
        System.out.println(list);
        assertEquals(-2, list.getTail().data.intValue());
    }

    @Test
    public void removeNode() {
        LinkedList list = new LinkedList();
        list.appendToTail(1);
        list.appendToTail(2);
        System.out.println(list);
        list.removeNode(2);
        System.out.println(list);
        assertEquals(1, list.getTail().data.intValue());
        assertEquals(1, list.getHead().data.intValue());
        list.appendToTail(3);
        list.appendToTail(4);
        System.out.println(list);
        list.removeNode(3);
        System.out.println(list);
        assertEquals(4, list.getTail().data.intValue());

    }

    @Test
    public void removeDups() {
        LinkedList list = new LinkedList();

        for(int i = 0; i < 10; i++) {
            list.appendToTail((i+1)%10);
            list.appendToTail((i+2)%10);
            list.appendToTail((i+3)%10);
        }



        System.out.println(list);
        list.removeDupsWithRunner();
        System.out.println(list);

        int i = 0;
        Node n = list.getHead();

        HashMap<Integer, Integer> map = new HashMap<>();

        while(i < 10) {
            map.put(n.data, (map.containsKey(n.data)) ? map.get(n.data)+1 : 1);
            i++;
            n = n.next;
        }

        for(Integer data : map.values()) {
            assertEquals(1, data.intValue());
        }
    }
}