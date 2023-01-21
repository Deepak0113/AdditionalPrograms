package datastructures;

import datastructures.exceptions.LinkedListNullException;
import datastructures.exceptions.LinkedListOutOfBoundException;


public class DoublyLinkedList {
    // DllNode class for creating node object of doubly linked list
    // Data members: int data, Node next, Node, prev
    private class DllNode{
        int data;
        DllNode next;
        DllNode prev;

        public DllNode(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head node represents the starting of the linked list
    private DllNode head;

    // Tail node represents the ending of the linked list
    private DllNode tail;

    // size represents the size of the linked list (number of elements in the linked list)
    private int size = 0;

    /**
     * Adds value to the first position of the Linked List.
     * @param value the value to be added in the linked list.
     * */
    public void addFirst(int value) {
        // checks if the head is null (empty linked list) or not
        // if so creates the linked list

        if (head == null) {
            head = new DllNode(value);
            tail = head;
        } else {
            // creates newNode to be added
            // links created new newNode to head
            // makes newNode as head of the linked list
            // size is increased by 1 as new node is added to the linked list

            DllNode newNode = new DllNode(value);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;

    }

    /**
     * Insert value to the given position of the Linked List.
     * @param value the position in which the value to be added.
     * */
    public void addLast(int value) {
        // checks if the head is null (empty linked list) or not
        // if so creates the linked list

        if (this.head == null) {
            head = new DllNode(value);
            tail = head;
        } else {
            // creates newNode to be added
            // links tail to newNode
            // makes newNode as tail of the linked list
            // size is increased by 1 as new node is added to the linked list

            DllNode newNode = new DllNode(value);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;


    }

    public void insert(int index, int value) {
        // checks if the head is null (empty linked list) or not
        // if so creates the linked list

        if (this.head == null) {
            head = new DllNode(value);
            tail = head;
            size++;
        } else {
            if (index == 0) { // calls addFirst method for adding in index 0
                addFirst(value);
            } else if (index == size) { // calls addLast method for adding in index 0
                addLast(value);
            } else { // for adding in between first and last of the linked list
                DllNode newNode = new DllNode(value); // creates newNode to be added
                DllNode currentNode = head; // currentNode is to traverse linked list

                // traverse through the linked list till index-1
                while (index-- > 2) {
                    currentNode = currentNode.next;
                }

                // links newNode to the element in the position index
                // links the element in index-1 position to the newNode
                // size is increased by 1 as new node is added to the linked list
                newNode.next = currentNode.next;
                newNode.prev = currentNode;
                currentNode.next.prev = newNode;
                currentNode.next = newNode;

                size++;
            }
        }

    }

    /**
     * Delete a value from the first position of the Linked List.
     * @exception LinkedListNullException throws when the linked list is null or empty
     * */
    public void deleteFirst() throws LinkedListNullException {
        // checks if the head is null (empty linked list) or not
        // if so throw LinkedListNullException as we cant delete from a empty or non-existing exception
        if(head == null){
            throw new LinkedListNullException();
        }

        // removeNode should be head node which is the node to be removed
        // make head node as next node
        // make removeNode next as null as it should have any other connections
        DllNode currentNode = head;
        head = head.next;
        head.prev = null;
        currentNode.next = null;

        size--;
    }

    /**
     * Delete a value from the last position of the Linked List.
     * @exception LinkedListNullException throws when the linked list is null or empty
     * */
    public void deleteLast() throws LinkedListNullException {
        // checks if the head is null (empty linked list) or not
        // if so throw LinkedListNullException as we cant delete from a empty or non-existing exception
        if(head == null){
            throw new LinkedListNullException();
        }

        // currentNode node is for traversal purpose
        DllNode currentNode = head;

        // traverse linked list till node before last node
        while (currentNode.next.next != null){
            currentNode = currentNode.next;
        }

        // making the last previous node's next as null to remove connection from the last
        // then make the current node as tail as it's the last node
        currentNode.next.prev = null;
        currentNode.next = null;
        tail = currentNode;

        size--;
    }

    /**
     * Delete a value from the given position of the linked list.
     * @param index the position in with the value to be deleted.
     * @exception LinkedListNullException throws when the linked list is null or empty
     * @exception LinkedListOutOfBoundException throws when index is above the size of the linked list or less than 0
     * */
    public void delete(int index) throws LinkedListNullException, LinkedListOutOfBoundException {
        // checks if the head is null (empty linked list) or not
        // if so throw LinkedListNullException as we cant delete from a empty or non-existing exception
        if(head == null){
            throw new LinkedListNullException();
        }

        // checks if the index exceed the range of 0 - size-1
        // if so throw LinkedListOutOfBoundException
        if(index >= size || index<0){
            throw new LinkedListOutOfBoundException();
        }

        // count is used for checking if index reached (for traversal)
        if(index == 0){
            deleteFirst();
            return;
        }

        // if index is 1 less than the size of the
        if(index == size-1){
            deleteLast();
            return;
        }

        // count is used for checking if index reached (for traversal)
        int count = 0;
        DllNode currentNode = head;

        // traverse linked list till index-1
        // as we need to link the previous node and the next node of the removing list
        while (count < index-1){
            count++;
            currentNode = currentNode.next;
        }

        // link the previous node and the next node of the removing list
        DllNode removeNode = currentNode.next;
        currentNode.next = removeNode.next;
        removeNode.next.prev = currentNode;
        removeNode.next = null;
        removeNode.prev = null;

        size--;
    }

    /**
     * Returns the size or number of items in the linked list.
     * @return int
     * */
    public int getSize(){
        return size;
    }

    /**
     * Displays the linked list
     *
     * @return String
     */
    public String toString(){
        DllNode currentNode = head;
        String string = "";

        // traverse through linked list
        while(currentNode != null){
            string += currentNode.data + "->";
            currentNode = currentNode.next;
        }
        string += "NULL";

        return string;
    }
}