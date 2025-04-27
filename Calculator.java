import java.util.InputMismatchException; //import InputMismatchException class
import java.util.Scanner; //import scanner class

public class Calculator {

    //function calculate the HCF using the Euclidean Method
    public static Double HCF(double num1, double num2) {
        if (num2 != 0) {
            while (num2 != 0) {
                double temp = num2;
                num2 = num1 % num2;
                num1 = temp;
            }
        }
        return num1;
    }

    //function to calculate the LCM by the relation between HCF and LCM
    public static Double LCM(double num1, double num2) {
        return (num1 * num2) / HCF(num1, num2);
    }

    //function to print numbers
    public static void printNumbers(double num1){
        for (int i = 1; i <= num1; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //set-up scanner to be used
        while (true) {
            try {
                //printing the operations
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Remainder");
                System.out.println("6. HCF");
                System.out.println("7. LCM");
                System.out.println("8. Print numbers");
                System.out.print("What do you want to do? (Enter Serial Number) ");
                int userChoice = sc.nextInt();

                if (userChoice <= 9) {
                    //taking user input
                    System.out.print("Enter first number: ");
                    double num1 = sc.nextInt();

                    //if user is printing numbers then, the second number and rest of the operations is not required
                    if (userChoice < 8) {
                        //if user chooses to not print numbers (some other operation)
                        System.out.print("Enter second number: ");
                        double num2 = sc.nextInt();

                        //declaring local variable
                        double result = 0;

                        //processing the operation
                        switch (userChoice) {
                            case 1:
                                result = num1 + num2; //addition
                                break;
                            case 2:
                                result = num1 - num2; //subtraction
                                break;
                            case 3:
                                result = num1 * num2; //multiplication
                                break;
                            case 4:
                                if (num2 != 0) { //division
                                    System.out.println("The result is: " + (num1 / num2));
                                } else { //error handling for division by 0
                                    System.out.println("Division by 0 is not defined.");
                                }
                                break;
                            case 5:
                                if (num2 != 0) { //modulus (remainder)
                                    System.out.println("The result is: " + (num1 % num2));
                                } else { //error handling for division by 0
                                    System.out.println("Division by 0 is not defined.");
                                }
                                break;
                            case 6:
                                System.out.println("The HCF is: " + HCF(num1, num2)); //HCF or GCD
                                break;
                            case 7:
                                System.out.println("The LCM is: " + LCM(num1, num2)); //LCM
                                break;
                            default:
                                System.out.println("Operation not available.");  //if user inputs an invalid number in the operation's panel
                                break;
                        }

                        //printing the result
                        if (userChoice == 1 || userChoice == 2 || userChoice == 3) {
                            System.out.println("The answer is " + result);
                        }
                    } else {
                        //if user chooses to print numbers then
                        printNumbers(num1);
                    }
                } else {
                    System.out.println("No such operation available.");
                }

                //asking whether to continue or stop
                System.out.print("Do you want to continue? ");
                String cont = sc.next();

                //if user discontinues
                if (cont.equalsIgnoreCase("No") || cont.equalsIgnoreCase("n")) {
                    System.out.println("Have a good day ahead. Calculator closed.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                sc.next();
            }
        }
        sc.close();
    }
}
