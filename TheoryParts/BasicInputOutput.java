package TheoryParts;

import java.util.Scanner;

public class BasicInputOutput 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Basic Input Output");
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        System.out.println("You entered " + number);
        input.close();
    
    }
    
}
