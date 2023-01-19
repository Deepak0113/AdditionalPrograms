package datastructures;

import datastructures.exceptions.LinkedListNullException;
import datastructures.exceptions.LinkedListOutOfBoundException;

class DllNode{
    int data;
    DllNode next;
    DllNode prev;

    public DllNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    private DllNode head;
    private DllNode tail;
    private int size = 0;

    public void addFirst(int value){
        if(head == null){
            head = new DllNode(value);
            tail = head;
            size++;
            return;
        }

        DllNode newnode = new DllNode(value);
        newnode.next = head;
        head.prev = newnode;

        head = newnode;
        size++;
    }

    public void addLast(int value){
        if(this.head == null){
            head = new DllNode(value);
            tail = head;
            size++;
            return;
        }

        DllNode newnode = new DllNode(value);
        tail.next = newnode;
        newnode.prev = tail;
        tail = newnode;


        size++;
    }

    public void add(int index, int value){
        if(this.head == null){
            head = new DllNode(value);
            tail = head;
            size++;
            return;
        }

        if(index == 0){
            addFirst(value);
        } else if(index == size){
            addLast(value);
        } else{
            DllNode newnode = new DllNode(value);
            DllNode temp = head;
            while(index-- > 2){
                temp = temp.next;
            }

            newnode.next = temp.next;
            newnode.prev = temp;
            temp.next.prev = newnode;
            temp.next = newnode;

            size++;
        }
    }

    public void deleteFirst() throws LinkedListNullException {
        if(head == null){
            throw new LinkedListNullException();
        }

        DllNode temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;

        size--;
    }

    public void deleteLast() throws LinkedListNullException {
        if(head == null){
            throw new LinkedListNullException();
        }

        DllNode temp = head;

        while (temp.next.next != null){
            temp = temp.next;
        }

        temp.next.prev = null;
        temp.next = null;
        tail = temp;

        size--;
    }

    public void delete(int index) throws LinkedListNullException, LinkedListOutOfBoundException {
        if(head == null){
            throw new LinkedListNullException();
        }

        if(index >= size){
            throw new LinkedListOutOfBoundException();
        }

        if(index == 0){
            deleteFirst();
            return;
        }

        if(index == size-1){
            deleteLast();
            return;
        }

        int count = 0;
        DllNode temp = head;

        while (count < index-1){
            count++;
            temp = temp.next;
        }

        DllNode removeNode = temp.next;
        temp.next = removeNode.next;
        removeNode.next.prev = temp;
        removeNode.next = null;
        removeNode.prev = null;

        size--;
    }

    public int getSize(){
        return size;
    }

    public void display(){
        DllNode temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");


        temp = tail;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
}
