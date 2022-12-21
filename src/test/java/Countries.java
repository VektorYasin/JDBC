import org.junit.jupiter.api.Test;

public class Countries {

     /*
        Given
          User connects to the database

        When
          User sends the query to get the region ids from "countries" table

        Then
          Verify that the number of region ids greater than 1 is 17.

        And
          User closes the connection
       */

    //set the connection, send the query, receivde the result sets
    @Test
    public void countryTest(){
        JDBCUtils.connectToDatabase("localhost", "postgres", "postgres", "root");

        JDBCUtils.createStatement();

    }

}
