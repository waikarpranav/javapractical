import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create object
            PalindromeImpl obj = new PalindromeImpl();
            
            // Start registry
            LocateRegistry.createRegistry(1099);
            
            // Bind object
            Naming.rebind("rmi://localhost/PalindromeService", obj);
            
            System.out.println("Server is ready...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
