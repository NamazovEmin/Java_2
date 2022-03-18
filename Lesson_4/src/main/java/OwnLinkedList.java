

public class OwnLinkedList<T> {


    private long size;
    private Node head;
    private Node tail;

    public OwnLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }



    public void addNode(T newData) {
        Node newNode = new Node(newData);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
                size++;
    }

    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("Односвязный список пуст");
            return;
        }

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public void display(int index) {
        if (index > size) {
            System.out.println("Индекс больше размера списка");
            return;
        }
        Node current = head;

        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        System.out.println(current.data);
    }

    public void delete(int index) {
        if (index > size) {
            System.out.println("Индекс больше размера списка");
            return;
        }
        Node current = head;

        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        current.data = null;

    }

    public void addNote(int index, T newData) {
        addNode(newData);
        if (index > size) {
            System.out.println("Индекс больше размера списка");
            return;
        }

        for (int j = 2; j < size-index+1; j++) {
            Node current = head;
            for (int i = 1; i <= size - j; i++) {
                current = current.next;
            }
            current.next.data = current.data;
        }
        Node current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        current.data = newData;
    }


private class Node {
    T data;
    Node next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

}
}
