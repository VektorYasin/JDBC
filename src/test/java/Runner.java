import java.sql.Connection;

public class Runner {

    public static void main(String[] args) {

        //1. Step:Registration to the Driver
        //2. Step: Create connection with database

        JDBCUtils.connectToDatabase();

        //3.Create Statement
        JDBCUtils.createStatement();

        //4. step: execute query
        JDBCUtils.execute("CREATE TABLE workers (worker_id VARCHAR(50), worker_name VARCHAR(20),worker_salary INT)");

        //5. step: close connection and statement
        JDBCUtils.closeConnectionAndStatement();

    }

}