import java.net.*;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 1. Get local host information
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Information:");
            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("IP Address: " + localHost.getHostAddress());
            
            // 2. Get IP of a specific website
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("\nGoogle Server Information:");
            System.out.println("Host Name: " + google.getHostName());
            System.out.println("IP Address: " + google.getHostAddress());
            
            // 3. Get all IP addresses of a host
            InetAddress[] allIps = InetAddress.getAllByName("www.google.com");
            System.out.println("\nAll IP Addresses of Google:");
            for (InetAddress ip : allIps) {
                System.out.println(ip);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
