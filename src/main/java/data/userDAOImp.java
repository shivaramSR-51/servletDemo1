package data;

import entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class userDAOImp implements userDAO {

    @Override
    public void saveUser(User user){

        String sql =  "INSERT INTO user "+
                      "(first_name, last_name, email, password) "+
                      " VALUES(?, ?, ?, ?) ";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);){

            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPassword());
            int rows = statement.executeUpdate();

            if(rows > 0){
                System.out.println("User registered successfully");
            }
        }catch(SQLException | IOException e){
            e.printStackTrace();
        }

    }


}
