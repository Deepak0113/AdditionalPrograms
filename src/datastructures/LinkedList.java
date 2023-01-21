package datastructures;

import datastructures.exceptions.LinkedListNullException;
import datastructures.exceptions.LinkedListOutOfBoundException;


public class LinkedList {
    // Node class for creating node object of singly linked list
    // Data members: int data, Node next
    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Head node represents the starting of the linked list
    private Node head;

    // Tail node represents the ending of the linked list
    private Node tail;

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
            head = new Node(value);
            tail = head;
        } else {
            // creates newNode to be added
            // links created new newNode to head
            // makes newNode as head of the linked list
            // size is increased by 1 as new node is added to the linked list

            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    /**
     * Adds value to the last position of the Linked List.
     * @param value the value to be added in the linked list.
     * */
    public void addLast(int value) {
        // checks if the head is null (empty linked list) or not
        // if so creates the linked list

        if (this.head == null) {
            head = new Node(value);
            tail = head;
        } else {
            // creates newNode to be added
            // links tail to newNode
            // makes newNode as tail of the linked list
            // size is increased by 1 as new node is added to the linked list

            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    /**
     * Insert value to the given position of the Linked List.
     * @param index the position in which the value to be added.
     * @param value the value to be added in the linked list.
     * */
    public void insert(int index, int value) {
        // checks if the head is null (empty linked list) or not
        // if so creates the linked list
        if (this.head == null) {
            head = new Node(value);
            tail = head;
            size++;
        } else {
            if (index == 0) { // calls addFirst method for adding in index 0
                addFirst(value);
            } else if (index >= size) { // calls addLast method for adding in index 0
                addLast(value);
            } else { // for adding in between first and last of the linked list
                Node newNode = new Node(value); // creates newNode to be added
                Node currentNode = head; // currentNode is to traverse linked list

                // traverse through the linked list till index-1
                while (index-- > 2) {
                    currentNode = currentNode.next;
                }

                // links newNode to the element in the position index
                // links the element in index-1 position to the newNode
                // size is increased by 1 as new node is added to the linked list
                newNode.next = currentNode.next;
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
        Node removeNode = head;
        head = head.next;
        removeNode.next = null;

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
        Node currentNode = head;

        // traverse linked list till node before last node
        while (currentNode.next.next != null){
            currentNode = currentNode.next;
        }

        // making the last previous node's next as null to remove connection from the last
        // then make the current node as tail as it's the last node
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

        // if index is 0 call deleteFirst() method
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
        Node currentNode = head;

        // traverse linked list till index-1
        // as we need to link the previous node and the next node of the removing list
        while (count < index-1){
            count++;
            currentNode = currentNode.next;
        }

        // link the previous node and the next node of the removing list
        Node removeNode = currentNode.next;
        currentNode.next = currentNode.next.next;
        removeNode.next = null;

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
        Node currentNode = head;
        StringBuilder string = new StringBuilder();

        // traverse through linked list
        while(currentNode != null){
            string.append(currentNode.data).append("->");
            currentNode = currentNode.next;
        }
        string.append("NULL");

        return string.toString();
    }
}
