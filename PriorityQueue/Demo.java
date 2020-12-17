import java.util.Date;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        PriorityQueue<Integer, String> List = new PriorityQueue<>();
        Date d1 = new Date();
        for(int x =0; x<15; x++) {
            Scanner input = new Scanner(System.in);
            System.out.println("What is your name?");
            String name = input.nextLine();
            System.out.println("Is this an emergency? (Y/N)");
            char urgency = input.next().charAt(0);
            if (urgency == 'Y') {
                System.out.println("What level of urgency? One being most urgent. (1-10)");
                int num = input.nextInt();
                List.insert(num, name);
            } else if(urgency == 'N'){
                System.out.println("You have registered on " + d1.toString());
                List.insert(10+x, name);
            }

            System.out.println("Is that all for today? (Y/N)");
            char cont = input.next().charAt(0);
            if (cont == 'Y') {
                break;
            } else {
                continue;
            }
        }
        for(int i = 0; i < List.size(); i++) {
            System.out.println("Patient " + (i + 1) + ": " + List.removeMin().getValue());
        }

    }
}
