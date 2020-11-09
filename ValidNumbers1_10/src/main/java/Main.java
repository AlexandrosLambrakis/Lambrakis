import java.util.Scanner;

public class Main {
    
    public static boolean isValidInputNumber(Scanner sc){
        int input = sc.nextInt();
        return input < 1 || input > 10;
    }
    
    public static void invalidInput(Scanner sc){
        System.out.println("Invalid Input. Try again");
        sc.next();
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number : ");

        while(true){
            if (sc.hasNextInt()) {
                if (Main.isValidInputNumber(sc)){
                    System.out.println("Please enter a number between 1 and 10");
                }else {
                    System.out.println("Congrats!!");
                    break;
                }
            }else if (!sc.hasNextInt()) Main.invalidInput(sc);
        }
    }
}



    


        

