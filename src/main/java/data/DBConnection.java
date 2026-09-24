package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;



public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/servlet";

    private static final String USER = "root";

    private static final String PASSWORD = "zarathos";

    public  static Connection getConnection() throws IOException, SQLException {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(url,USER,PASSWORD);


    }
//    public static void main(String[] args){
//
//        try{
//
//            Connection con = getConnection();
//
//            System.out.println("Database connection successfully");
//
//            con.close();
//
//        }catch(Exception e){
//            System.out.println("DataBase Connection failed");
//            e.printStackTrace();
//        }

//    }

}
