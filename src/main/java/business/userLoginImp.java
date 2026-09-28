package business;

import data.dlUser;
import data.userDAO;
import data.userDAOImp;

public class userLoginImp implements userLogin{

    @Override
    public boolean login(blUser login){


        dlUser dluser = new dlUser();

        dluser.setEmail(login.getEmail());
        dluser.setPassword(login.getPassword());

        userDAO userLogin = new userDAOImp();
        return userLogin.validateUser(dluser);



    }
}
