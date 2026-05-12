import java.sql.*;

public class JdbcDemo
{
    public static void main(String args[])
    {
        try
        {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                ""
            );

            // Insert Data
            Statement st = con.createStatement();

            st.executeUpdate(
                "insert into student values(1,'Anjali',90)"
            );

            // Retrieve Data
            ResultSet rs = st.executeQuery(
                "select * from student"
            );

            while(rs.next())
            {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3)
                );
            }

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
