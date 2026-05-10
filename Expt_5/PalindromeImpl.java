import java.rmi.*;
import java.rmi.server.*;

public class PalindromeImpl extends UnicastRemoteObject implements Palindrome {
    public PalindromeImpl() throws RemoteException {
        super();
    }

    public String checkPalindrome(String input) throws RemoteException {
        String original = input;
        String reversed = new StringBuilder(input).reverse().toString();
        
        if (original.equalsIgnoreCase(reversed)) {
            return input + " is a PALINDROME";
        } else {
            return input + " is NOT a PALINDROME";
        }
    }
}
