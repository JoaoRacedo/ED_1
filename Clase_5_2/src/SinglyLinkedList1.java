public class SinglyLinkedList1 {
    /*
    Inner class is a nested class which is a static member for the 
    outer class. It can be accessed without instantiating the outer class,
    using other static members.
    */
    static class Node{
        //Attributes
        int data;
        Node next;
        //Constructor
        public Node(int d){
            data = d;
            next = null;
        }
    }
    Node head = null; //PTR esta "vacio" o nulo
    public void display(){
        Node P = head;
        while(P != null){
            System.out.print(P.data +" -> ");
            P = P.next;
            //P.next != null ? "->" : "END"
        }
        if(P == null)
            System.out.print("null\n");
        
    }

    public static void main(String[] args) throws Exception {
        SinglyLinkedList1 list = new SinglyLinkedList1();
        list.head = new Node(5);
        Node second = new Node(1);
        Node third = new Node(10);
        System.out.println("head points to: "+list.head.next);
        System.out.println("second points to: "+second.next);
        System.out.println("third points to: "+third.next+"\n");
        list.display();
        list.head.next = second; // Link first node with the second node second <- link(head/PTR)
        second.next = third; // Link second node with third node

        System.out.println("head points to: "+list.head.next);
        System.out.println("second points to: "+second.next);
        System.out.println("third points to: "+third.next);
        list.display();
    }
}
