import java.sql.*;

public class JDBCUtils {
    private static Connection connection;
    private static  Statement statement;

    public static Connection connectToDatabase(){
        //1. Step:Registration to the Driver

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //2. Step: Create connection with database

        try {
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connection is successful!");
        return connection;

    }

    public static Statement createStatement(){

        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Statement created!");

        return statement;
    }


    public static void connectToDatabase(String localhost, String postgres, String postgres1, String root) {
    }

    public static void getColoumnList(String coloumnName, String tableName ) throws SQLException {
        ResultSet resultset=null;
        String query = "select" + coloumnName + "from" + tableName;

        try {
            resultset = statement.executeQuery(query);//wnat to print data, make it executeQuerry
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            if(!resultset.next())
                break;
        }
        try{
            resultset.getObject((1));
        }catch (SQLException e){

        }

        return;
    }

}