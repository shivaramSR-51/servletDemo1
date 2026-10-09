package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.list;


public class userDAOImp implements userDAO {

    @Override
    public void saveUser(dUser duser) {


        String sql = "INSERT INTO user " +
                "(first_name, last_name, email, password) " +
                " VALUES(?, ?, ?, ?) ";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, duser.getFirstName());
            statement.setString(2, duser.getLastName());
            statement.setString(3, duser.getEmail());
            statement.setString(4, duser.getPassword());
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("User registered successfully");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public dlUser validateUser(dlUser dluser) {

        dlUser result = null;

        String validate = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(validate)
        ) {
            statement.setString(1,dluser.getEmail());
            statement.setString(2,dluser.getPassword());

            ResultSet rs = statement.executeQuery();

            if(rs.next()){

                result = new dlUser();
                result.setUserId(rs.getInt("userId"));
                result.setFirstName(rs.getString("first_name"));
                result.setLastName(rs.getString("last_name"));
                result.setEmail(rs.getString("email"));

                return result;
            }

           return null;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return null;
        }


    }
    @Override
    public void addUserAddress(dAddress address){

       String sql = "INSERT INTO address " +
                "(user_id,street,city,country,zipcode) " +
                " VALUES(?, ?, ?, ?, ?) ";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

             statement.setInt(1, address.getUserId());
             statement.setString(2, address.getStreet());
             statement.setString(3, address.getCity());
             statement.setString(4, address.getCountry());
             statement.setString(5,address.getZipcode());
            int rows = statement.executeUpdate();

           if (rows > 0) {
                System.out.println("address Added successfully");
            }
       } catch (SQLException | IOException e) {
            e.printStackTrace();
       }


    }

    @Override
    public void addPhno(dPhno dphno) {

        String sql = "INSERT INTO phno " +
                "(user_id,country_code,phone_no, type) " +
               " VALUES(?, ?, ?, ?) ";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, dphno.getUserId());
            statement.setString(2, dphno.getPhnoCode());
            statement.setString(3, dphno.getPhno());
            statement.setString(4, "Personal");

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("contact Added successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override

    public List<dAddress> getAddresses(int userId) {
        List<dAddress> list = new ArrayList<>();

        String sql = "SELECT street, city, country, zipcode FROM address WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    dAddress addres = new dAddress();
                    addres.setUserId(userId);
                    addres.setStreet(rs.getString("street"));
                    addres.setCity(rs.getString("city"));
                    addres.setCountry(rs.getString("country"));
                    addres.setZipcode(rs.getString("zipcode"));
                    list.add(addres);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<dPhno> getPhno(int userId){

        List<dPhno> list  =  new ArrayList<>();
        String sql = "SELECT country_code, phone_no, type From phno WHERE user_id = ?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, userId);
            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    dPhno phno = new dPhno();
                    phno.setUserId(userId);
                    phno.setPhnoCode(rs.getString("country_code"));
                    phno.setPhno(rs.getString("phone_no"));

                    list.add(phno);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}


