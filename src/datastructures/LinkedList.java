package datastructures;

class LinkedListNullException extends Exception{
    LinkedListNullException(){
        super("LinkedListNullException");
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(int value){
        if(head == null){
            head = new Node(value);
            tail = head;
            size++;
            return;
        }

        Node newnode = new Node(value);
        newnode.next = head;
        head = newnode;
        size++;
    }

    public void addLast(int value){
        if(this.head == null){
            head = new Node(value);
            tail = head;
            size++;
            return;
        }

        Node newnode = new Node(value);
        tail.next = newnode;
        tail = newnode;
        size++;
    }

    public void add(int index, int value){
        if(this.head == null){
            head = new Node(value);
            tail = head;
            size++;
            return;
        }

        if(index == 0){
            addFirst(value);
        } else if(index == size){
            addLast(value);
        } else{
            Node newnode = new Node(value);
            Node temp = head;
            while(index-- > 2){
                temp = temp.next;
            }

            newnode.next = temp.next;
            temp.next = newnode;
            size++;
        }
    }

    public void deleteFirst() throws LinkedListNullException{
        if(head == null){
            throw new LinkedListNullException();
        }

        Node temp = head;
        head = head.next;
        temp.next = null;

        size--;
    }

    public void deleteLast() throws LinkedListNullException {
        if(head == null){
            throw new LinkedListNullException();
        }

        Node temp = head;

        while (temp.next.next != null){
            temp = temp.next;
        }

        Node removeNode = temp.next;
        temp.next = null;
        removeNode.next = null;

        size--;
    }

    public void delete(int index) throws LinkedListNullException {
        if(head == null){
            throw new LinkedListNullException();
        }

        int count = 0;
        Node temp = head;

        while (count < index-1){
            count++;
            temp = temp.next;
        }

        Node removeNode = temp.next;
        temp.next = temp.next.next;
        removeNode.next = null;

        size--;
    }

    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
