import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Step:Registration to the Driver

        Class.forName("org.postgresql.Driver");

        //2. Step: Create connection with database

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        //3 Step:Create statement
        Statement st= con.createStatement();

        //1.Example:Select the country names whose region ids are 1
        String sql1="SELECT country_name FROM countries WHERE region_id = 1";

        //IF YOU EXECUTE () method, you will get true or false as return, I want to see the records
        boolean result1= st.execute(sql1);
        System.out.println("result1 = " + result1);

        //To see the records outcome we have another method which is "executeQuery()"
        //"executeQuery()" return us a result set,
        ResultSet resultSet1=st.executeQuery(sql1);

        while (resultSet1.next()){

            System.out.println(resultSet1.getString("country_name"));//burda index de kullanabiliriz ama 1'den başlatıyoruz

        }

        //2.select the country_id and country_name whose region_id is greater than 2
        String sql2 ="SELECT  country_id, country_name FROM countries WHERE region_id>2";
        ResultSet resulSet2 = st.executeQuery(sql2);

        while(resulSet2.next()){

            System.out.println(resulSet2.getString("country_id") + "->" +resulSet2.getString("country_name"));
        }

        //3.select the company whose number_of_employees  is the lowest from the companies table
        String sql3= "SELECT company FROM companies WHERE number_of_employees=(SELECT MIN(number_of_employees) FROM companies)";
        ResultSet resultSet3= st.executeQuery(sql3);

        //if we dont use next(), the cursor pointing null.
        resultSet3.next();
        System.out.println(resultSet3.getString("company"));

        while (resultSet3.next()){

            System.out.println(resultSet3.getString("company"));
        }

        while (resultSet3.next()){
            System.out.println(resultSet3.getInt(1)+" "+resultSet3.getString(2)+" "+resultSet3.getInt(3));
        }

        con.close();
        st.close();


    }
}