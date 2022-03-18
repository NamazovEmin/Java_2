public class OwnLinkedListMain {
    public static void main(String[] args) {
        OwnLinkedList<Integer> integerOwnLinkedList = new OwnLinkedList<>();
        integerOwnLinkedList.addNode(100);
        integerOwnLinkedList.addNode(150);
        integerOwnLinkedList.addNode(200);
        integerOwnLinkedList.addNode(null);
        integerOwnLinkedList.addNode(250);
        integerOwnLinkedList.addNode(300);
        integerOwnLinkedList.delete(5);
        integerOwnLinkedList.addNote(3, 1000);
        integerOwnLinkedList.display();
    }
}
