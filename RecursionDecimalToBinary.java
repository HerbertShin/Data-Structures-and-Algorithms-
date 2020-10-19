/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Herbert Shin
 */

import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecursionDecimalToBinary extends RecursionDecimalToBinaryDemo {

    double remainder;
    int decimal;
    ArrayList<String> list = new ArrayList<String>();
    Scanner input = new Scanner(System.in);

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public ArrayList<String> conversion() throws IllegalArgumentException, InputMismatchException {
        try {
            converter();
        } catch (IllegalArgumentException negative) {
            System.out.println(negative.getMessage());
            System.out.println("Please try again...");
            run();
        }
        return list;
    }

    private void exceptions(){
        //Can't be a negative number
        if (decimal < 0) {
            //If the user enters 0 the output should be 0
            throw new IllegalArgumentException("The number cannot be negative!");
        }
    }

    private ArrayList<String> converter(){
        if (decimal == 0 && remainder == 0) {
            list.add("0");
            return list;
        }
        //If decimal is a negative run exception method
        else if(decimal < 0){
            exceptions();
        }
        else if(decimal >= 0) {
            //Stores and checks the remainder to see if the integer divides evenly
            remainder = this.decimal % 2;
            //Updates the decimal by dividing after every iteration
            this.decimal = decimal / 2;
            //Adds 1 to list if remainder is greater than 0 and checks to see if decimal is not 0 to continue recursion
            if (remainder > 0 && decimal > 0) {
                list.add("1");
                conversion();
                //Adds 0 to list if remainder is 0 and checks to make sure decimal is not 0 to continue recursion
            } else if (remainder == 0 && decimal > 0) {
                list.add("0");
                conversion();
                //Base case for when the integer divides to 0 but there is a remainder
            } else if (remainder > 0 && decimal == 0) {
                list.add("1");
            }
            else{
                list.add("0");
            }
        }
        return list;
    }
    //print list reverse order due to data entry being stored like a stack
    public void printBinary() {
        StringBuffer string = new StringBuffer();
        Collections.reverse(list);
        list.forEach((n) -> string.append(n + " "));
        System.out.println(string);
        list.clear();
    }

    public void run(){
        int decimal = 0;
        while(decimal >= 0){
            System.out.println("Enter a decimal...");
            decimal = input.nextInt();
            setDecimal(decimal);
            conversion();
            printBinary();
        }
    }

}
