public class SinglyLinkedList2 {
    //Represent a node of the singly linked list
    class Node{
        int data;
        Node next;
        public Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    //Represent the head and tail of the singly linked list
    Node head = null;
    Node tail = null;

    //addNode() will add a new node to the singly linked list
    public void addNode(int data){
        // First lets create a new node
        Node P = new Node(data);

        // Second lets check if the list is empty
        if(head == null){
            // if the list is empty, the new node P will both head and tail
            head = P;
            tail = P;
        }else{
            // the new node P will be added after the tail such that tail's next will now point to P
            tail.next = P;
             // the new node P will become the tail of the list
            tail = P;
        }
    }
    // display() will display all the nodes in the singly linked list
    public void display(){
        // First lets create a node current that will point to the node head
        Node current = head;

        if(current == null){
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The nodes of the singly linked list are: ");
        while(current != null){
            System.out.print(current.data +" -> ");
            current = current.next;
        }
        if(current == null)
            System.out.print("null\n");
    }

    //countNumNodes() will count the number of nodes in the list
    public int countNumNodes(){
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        SinglyLinkedList2 sList = new SinglyLinkedList2();
        sList.addNode(1);
        sList.addNode(2);
        sList.addNode(3);
        sList.addNode(4);
        sList.display();
        System.out.println("The number of nodes is: "+ sList.countNumNodes());
    }
}
