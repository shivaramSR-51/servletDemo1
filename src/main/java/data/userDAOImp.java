package data;

import business.bUser;
import common.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class userDAOImp implements userDAO {

    @Override
    public void saveUser(data data){


        dUser duser = new dUser();
        duser.setFirstName(data.getFirstName());
        duser.setLastName(data.getLastName());
        duser.setEmail(data.getEmail());
        duser.setPassword(data.getPassword());




        String sql =  "INSERT INTO user "+
                      "(first_name, last_name, email, password) "+
                      " VALUES(?, ?, ?, ?) ";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,duser.getFirstName());
            statement.setString(2,duser.getLastName());
            statement.setString(3,duser.getEmail());
            statement.setString(4,duser.getPassword());
            int rows = statement.executeUpdate();

            if(rows > 0){
                System.out.println("User registered successfully");
            }
        }catch(SQLException | IOException e){
            e.printStackTrace();
        }

    }


}
