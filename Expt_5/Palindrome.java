import java.rmi.*;

public interface Palindrome extends Remote {
    String checkPalindrome(String input) throws RemoteException;
}
