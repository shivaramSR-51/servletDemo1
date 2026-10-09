package business;

import data.dPhno;
import data.userDAO;
import data.userDAOImp;

public class userPhnoImp implements userPhno{
    public void addPhno(bPhno bphno){

        dPhno dphno = new dPhno();

        dphno.setUserId(bphno.getUserId());
        dphno.setPhno(bphno.getPhno());
        dphno.setPhnoCode(bphno.getPhnoCode());


        userDAO phno_data = new userDAOImp();
        phno_data.addPhno(dphno);


    }
}
