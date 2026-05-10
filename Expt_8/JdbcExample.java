import java.sql.*;
import java.util.Scanner;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "root"; // change as per your setup
        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!");
            
            Scanner sc = new Scanner(System.in);
            
            // 3. Insert Data
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            
            String insertQuery = "INSERT INTO students VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);
            ps.executeUpdate();
            System.out.println("Data inserted successfully!");
            
            // 4. Retrieve Data
            String selectQuery = "SELECT * FROM students";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("marks")
                );
            }
            
            // 5. Close Connection
            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
