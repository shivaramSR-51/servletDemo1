package business;
import data.userDAO;
import data.userDAOImp;
import presentation.rUser;
public class userRegisterImpl implements userRegister
{
    @Override
    public void register(rUser ruser){
        if(!ruser.getPassword().equals(ruser.getConfirmPassword())){
            System.out.println("Password doesn't match");
            return;
        }

        bUser buser = new bUser(ruser.getFirstName(),
                                ruser.getLastName(),
                                ruser.getEmail(),
                                ruser.getPassword(),
                                ruser.getConfirmPassword());

        userDAO userDao = new userDAOImp();
        userDao.saveUser(buser);
    }

}