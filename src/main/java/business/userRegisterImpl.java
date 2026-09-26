package business;

import data.userDAO;
import data.userDAOImp;
import data.dUser;

public class userRegisterImpl implements userRegister
{
    @Override
    public void register(bUser buser){



        if(!buser.getPassword().equals(buser.getConfirmPassword())){
            System.out.println("Password doesn't match");
            return;
        }

        dUser duser = new dUser();

        duser.setFirstName(buser.getFirstName());
        duser.setLastName(buser.getLastName());
        duser.setEmail(buser.getEmail());
        duser.setPassword(buser.getPassword());



        userDAO userDao = new userDAOImp();
        userDao.saveUser(duser);
    }

}