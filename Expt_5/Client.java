import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Lookup remote object
            Palindrome obj = (Palindrome) Naming.lookup("rmi://localhost/PalindromeService");
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter String or Number: ");
            String input = sc.nextLine();
            
            // Call remote method
            String result = obj.checkPalindrome(input);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
