package business;

import data.dlUser;
import data.userDAO;
import data.userDAOImp;

public class userLoginImp implements userLogin{

    @Override
    public blUser login(blUser login){


        dlUser dluser = new dlUser();

        dluser.setEmail(login.getEmail());
        dluser.setPassword(login.getPassword());

        userDAO userLogin = new userDAOImp();
        dlUser result =  userLogin.validateUser(dluser);

        if(result == null){
            return null;
        }

        blUser bluser  =  new blUser();

        bluser.setFirstName(result.getFirstName());
        bluser.setLastName(result.getLastName());
        bluser.setEmail(result.getEmail());
        bluser.setUserId(result.getUserId());

        return bluser;


    }
}
