/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author herbs
 */

import java.util.ArrayList;
import java.util.Collections;

public class DecimalToBinaryConverter {
    public int decimal;
    public double remainder;
    ArrayList<String> list = new ArrayList<String>();

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public ArrayList<String> ConvertToBinary() {
        //Decimal has to be a natural number
        if (decimal < 0) {
            System.out.println("Not an appropriate value");
        }
        //If decimal is greater than 0, then the loop can begin
        if(decimal>0) {
            remainder = this.decimal % 2;
            this.decimal = decimal / 2;
            //If an even number is divided by two then it will still run through the loop again
            if (remainder == 0 && decimal != 0) {
                //Append a 0 to the array list if the number divides evenly
                list.add("0");
                //Loop through until a value of zero is reached
                return ConvertToBinary();
            }
            //For when there is a remainder of 1
            else if (remainder <= 1) {
                //Append a 1 to the array list
                list.add("1");
                //Loop through again until value zero is reached
                return ConvertToBinary();
            }
            //Base case if 0 is entered
            else {
                //append a 0 to the array list for any other case
                list.add("0");
            }

        }
        return list;
    }

    public void printBinary() {
        StringBuffer string = new StringBuffer();
        Collections.reverse(list);
        for (String s : list) {
            string.append(s);
            string.append(" ");
        }
        System.out.println("The binary conversion is: " + "\n" + string);
        list.removeAll(list);
    }

}
