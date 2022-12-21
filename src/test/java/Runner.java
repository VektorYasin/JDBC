public class Runner {

    public static void main(String[] args) {

        //1. Step:Registration to the Driver
        //2. Step: Create connection with database

        JDBCUtils.connectToDatabase();

        //3.Create Statement

        JDBCUtils.createStatement();


    }

}