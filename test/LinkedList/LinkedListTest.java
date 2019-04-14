package LinkedList;

import org.junit.Test;
import sun.awt.image.ImageWatched;

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

    @Test
    public void testKthToLast() {
        LinkedList list = new LinkedList();

        for(int i = 0; i < 10; i++) {
            list.appendToTail(i);
        }

        assertEquals(9, list.kthToLast(1).data.intValue());
        assertEquals(8, list.kthToLast(2).data.intValue());

    }

    @Test
    public void testPartition() {
        LinkedList list = new LinkedList();

        list.appendToTail(3);
        list.appendToTail(5);
        list.appendToTail(8);
        list.appendToTail(5);
        list.appendToTail(2);
        list.appendToTail(10);
        list.appendToTail(2);
        list.appendToTail(1);
        list.appendToTail(4);
        list.appendToTail(3);

        System.out.println(list);

        Node head = LinkedList.parition(list.getHead(), 5);

        LinkedList newList = new LinkedList();

        newList.head = head;

        Node ptr = head;

        while(ptr.next != null) {
            ptr = ptr.next;
        }

        newList.tail = ptr;

        System.out.println(newList);
    }

    @Test
    public void testChangeToNumber() {
        LinkedList list = new LinkedList();
        list.appendToTail(7);
        list.appendToTail(1);
        list.appendToTail(6);

        System.out.println(LinkedList.changeToNumber(list.getHead(), 0));

    }

    @Test
    public void testSumList() {
        LinkedList l1 = new LinkedList();
        l1.appendToTail(7);
        l1.appendToTail(1);
        l1.appendToTail(6);

        LinkedList l2 = new LinkedList();
        l2.appendToTail(5);
        l2.appendToTail(9);
        l2.appendToTail(2);

        Node n = LinkedList.sumLists(l1.getHead(), l2.getHead(), 0);

        LinkedList result = new LinkedList(n);
        assertEquals("[ 2, 1, 9 ]", result.toString());

        LinkedList l3 = new LinkedList();
        l3.appendToTail(0);
        l3.appendToTail(0);
        l3.appendToTail(5);

        LinkedList l4 = new LinkedList();
        l4.appendToTail(0);
        l4.appendToTail(0);
        l4.appendToTail(5);

        n = LinkedList.sumLists(l3.getHead(), l4.getHead(), 0);

        result = new LinkedList(n);
        assertEquals("[ 0, 0, 0, 1 ]", result.toString());

    }

    @Test
    public void testIsPalindrome(){
        LinkedList l1 = new LinkedList();
        l1.appendToTail(0);
        l1.appendToTail(1);
        l1.appendToTail(2);
        l1.appendToTail(2);
        l1.appendToTail(1);
        l1.appendToTail(0);


        assertTrue(LinkedList.isPalindrome(l1));

        LinkedList l2 = new LinkedList();
        l2.appendToTail(0);
        l2.appendToTail(1);
        l2.appendToTail(2);
        l2.appendToTail(3);
        l2.appendToTail(2);
        l2.appendToTail(1);
        l2.appendToTail(0);

        assertTrue(LinkedList.isPalindrome(l2));


    }
}