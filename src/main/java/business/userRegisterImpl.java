package business;
import data.userDAO;
import data.userDAOImp;
import entity.User;

public class userRegisterImpl implements userRegister
{
    @Override
    public void register(User user){
        if(!user.getPassword().equals(user.getConfirmPassword())){
            System.out.println("Password doesn't match");
            return;
        }

        userDAO userDao = new userDAOImp();
        userDao.saveUser(user);
    }

}