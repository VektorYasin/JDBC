import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. Step: Registration to the Driver
        Class.forName("org.postgresql.Driver");

        //2.Step: Create connection with the database
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        //3 Step:Create statement
        Statement st = con.createStatement();

        //4 Step:Execute query
        /*
        execute() method can be used in DDL(Data Definition Language (Table creation, drop table, alter table) and DQL(Select)
        1. If you use execute() method in DDL, you will get "false" evertime.
        2. If you use execute() method in DQL, you will get true or false.
        3. when you use execute() method in DQL, if you get "ResultSet Object" as return you will get true
        otherwise you will get false.
         */
        //Ex-1:CREATE TABLE workers (worker_id VARCHAR(50), worker_name VARCHAR(20),worker_salary IN
        String sql1="CREATE TABLE workers (worker_id VARCHAR(50), worker_name VARCHAR(20),worker_salary INT)";
        st.execute(sql1);

        //Ex.2:Alter table with adding worker_address column
        String sql2="ALTER TABLE workers ADD worker_address VARCHAR(50)";
        st.execute((sql2));

        //Ex 3 DROP TABLE workers;
        String sql3="DROP TABLE workers";
        st.execute(sql3);

        //5. Step: Close the connection and statemen

        con.close();
        st.close();
    }
}
