package BasicProgram;

import java.util.Scanner;

public class Calculator 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome To Calculator");

            System.out.print("Please Enter The 1st Digit: ");
            double num1 = scanner.nextDouble();

            System.out.print("Please Enter The 2nd Digit: ");
            double num2 = scanner.nextDouble();

            System.out.println("Please Select an Operator:");
            System.out.println("1. Add");
            System.out.println("2. Minus");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");

            int choice = scanner.nextInt();

            double result = 0;

            switch (choice) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Unable to Divide with 0");
                        return;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid Choice");
                    return;
            }

            System.out.println("Answer: " + result);
        } finally {
            // 确保在程序结束时关闭 Scanner
            scanner.close();
        }
    }
    
}
