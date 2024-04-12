import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false";
        String userName = "root";
        String password = "Password@123";
        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

        while(resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
        }

        try{
            int rowCount = statement.executeUpdate("INSERT INTO employee VALUES (107, 'Jake', 20)");
            System.out.println("Data succesfully inserted");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Data could not be inserted, Integrity constraint violated");
        }


        statement.close();
        connection.close();
    }
}
