/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Herbert Shin
 */
import java.util.ArrayList;
import java.util.Collections;

public class DoublyLinkedList{
    ArrayList <Integer> array = new ArrayList <Integer> ();
    //create a node class for the doubly linked list 
    class Node{
        Node next;
        Node previous;
        int item;
        public Node(int item){
            this.item = item;
        }
    }
    Node head, tail = null;
    
    public void addNode(int item){
        Node newNode = new Node(item);

    //if list is empty, head and tail points to NewNode
    if(head == null){
    head = tail = newNode;
    head.previous = null;
    tail.next = null;
    }
    else{
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        tail.next = null;
    }
    
    }
    
    public void setArray(int item){
        array.add(item);
    }
    
    public ArrayList<Integer> sort(){
        Collections.sort(array);
        return array;
    }

    public void AddtoList(){
        for(int i = 0; i<array.size(); i++){
            int n = array.get(i);
            addNode(n);
        }
    }

    public boolean search(Node head, int x){
        Node current = head;
        while(current != null){
            if(current.item == x){
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
