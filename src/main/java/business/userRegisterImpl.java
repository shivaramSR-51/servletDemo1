package business;
import common.data;
import data.userDAO;
import data.userDAOImp;
import common.registerRequest;
public class userRegisterImpl implements userRegister
{
    @Override
    public void register(registerRequest req){



        if(!req.getPassword().equals(req.getConfirmPassword())){
            System.out.println("Password doesn't match");
            return;
        }

        bUser buser = new bUser();
        buser.setFirstName(req.getFirstName());
        buser.setLastName(req.getLastName());
        buser.setEmail(req.getEmail());
        buser.setPassword(req.getPassword());

        data data = new data();
        data.setFirstName(buser.getFirstName());
        data.setLastName(buser.getLastName());
        data.setEmail(buser.getEmail());
        data.setPassword(buser.getPassword());

        userDAO userDao = new userDAOImp();
        userDao.saveUser(data);
    }

}