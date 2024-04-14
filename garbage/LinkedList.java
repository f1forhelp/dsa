package garbage;

public class LinkedList {
    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<String>();
        // customLinkedList.append("Apple");
        // customLinkedList.append("Mango");
        // customLinkedList.append("Banana");


        customLinkedList.append("Opp1");
        customLinkedList.append("Opp2");
        // customLinkedList.append("Opp3");
        // customLinkedList.append("Opp4");
        // customLinkedList.removeFirst();
        customLinkedList.reverse();

        System.out.println("");
        System.out.println(customLinkedList);
        System.out.println(customLinkedList);
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

    void prepend(T v){
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

    void removeFirst(){
        if (tail == head) {
            tail = head = null;
        }else{
            head = head.next;
        }
    }

    void reverse(){
        Node prevNode = null;
        Node nextNode = null;
        //If array is empty or contains one value.
        if (head == tail) {
            return;
        }

        while (true) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            if (head == tail) {
                head = tail;
                tail = prevNode;
                break;
            }else{
                head = nextNode;
            }
  
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