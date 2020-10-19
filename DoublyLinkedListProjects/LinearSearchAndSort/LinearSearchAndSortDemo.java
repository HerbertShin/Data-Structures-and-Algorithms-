/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author herbs
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Demo {
    public static void main(String Arg[]){
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner input = new Scanner(System.in);
        Scanner check = new Scanner(System.in);
        //Check how many integer will be stored
        try{
        System.out.println("How many elements are you adding to the list?");
        int n = check.nextInt();
        for(int i = 0; i<n; i++){
        //Add inputs to list 
        System.out.println("Enter integers to store into the list...");
        int item = input.nextInt();
        list.setArray(item);
        }
        list.sort();
        list.AddtoList();
        System.out.println("Enter a number to search for...");
        int num = input.nextInt();
        if(list.search(list.head,num)){
            System.out.println("Number Found");
        }
        else{
            System.out.println("Number Not Found");
        }
    }catch(InputMismatchException ex){
            System.out.println("Only integers accepted");
        }
    }
    
}
