package garbage;

public class LinkedList {
    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<String>();
        // customLinkedList.append("Apple");
        // customLinkedList.append("Mango");
        // customLinkedList.append("Banana");

        customLinkedList.append("Opp1");
        customLinkedList.append("Opp2");
        customLinkedList.append("Opp3");
        customLinkedList.append("Opp4");
        // customLinkedList.append("Opp5");
        // customLinkedList.removeFirst();
        // customLinkedList.reverse();
        customLinkedList.findSecondMiddleNode();
        // customLinkedList.findFirstMiddleNode();
        // System.out.println("");
        // System.out.println(customLinkedList);
        // System.out.println(customLinkedList);
    }
}

class CustomLinkedList<T> {

    private Node head;
    private Node tail;

    CustomLinkedList() {
        head = null;
        tail = null;
    }

    void append(T v) {
        Node node = new Node(v, null);
        if (head == null || tail == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    void prepend(T v) {
        Node node = new Node(v, head);
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    void removeLast() {
        if (tail == head) {
            tail = head = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
    }

    void removeFirst() {
        if (tail == head) {
            tail = head = null;
        } else {
            head = head.next;
        }
    }

    void reverse() {
        Node cN = head;
        Node pN = null;
        Node nN = null;

        while (cN != null) {
            nN = cN.next;
            cN.next = pN;
            pN = cN;
            cN = nN;
        }
        tail = head;
        head = pN;
    }

    void findSecondMiddleNode() {
        // ALGO: slow and fast pointer technique (aka Floyd's Tortoise and Hare
        // algorithm aka (Floyd’s Cycle Finding Algorithm))
        Node fN = head;
        Node sN = head;

        while (fN != null && fN.next != null) {
            sN = sN.next;
            fN = fN.next.next;
        }
        System.out.println(sN.data);
    }

    void findFirstMiddleNode() {
        Node fN = head;
        Node sN = head;
        Node pN = null;

        while (fN != null && fN.next != null) {
            pN = sN;
            sN = sN.next;
            fN = fN.next.next;
        }
        // As fN will be null if no of elements is even. Reason is fN starts from 1
        // and it keeps adding 2 to its current value.
        // So in second iteration fN will be 3 then 5 , 7 so on.
        if (fN == null) {
            System.out.println(pN.data);
        } else {
            System.out.println(sN.data);
        }
    }

    @Override
    public String toString() {
        Node initialHeader = head;
        while (initialHeader != null) {
            System.out.println(initialHeader.data);
            initialHeader = initialHeader.next;
        }
        System.out.println("");
        System.out.println(tail.data);
        return "";
    }

    /**
     * LinkedListData
     */
    class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}