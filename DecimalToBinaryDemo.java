/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author herbs
 */
import java.util.Scanner;

public class DecimalToBinaryDemo {
    public static void main(String[] Arg){
        DecimalToBinaryConverter binary = new DecimalToBinaryConverter();
        Scanner user = new Scanner(System.in);
        int input=0;
        while(true){
            if(input>=0) {
                System.out.println("Enter a decimal number to convert to Binary: ");
                input = user.nextInt();
                binary.setDecimal(input);
                binary.ConvertToBinary();
                binary.printBinary();
            }

        }
    }
}
