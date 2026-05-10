import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Establish Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "password");
                
            // 3. Insert Data
            String insertQuery = "INSERT INTO student VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setInt(1, 1);
            ps.setString(2, "Soham");
            ps.setInt(3, 85);
            ps.executeUpdate();
            System.out.println("Data Inserted Successfully!");
            
            // 4. Retrieve Data
            String selectQuery = "SELECT * FROM student";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);
            
            System.out.println("\nStudent Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                System.out.println(id + " " + name + " " + marks);
            }
            
            // 5. Close Connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
Notes:
//LOAD DRIVER
Class.forName("com.mysql.cj.jdbc.Driver");

//ESTABLISH CONNECTION
DriverManager.getConnection(...)
*/
