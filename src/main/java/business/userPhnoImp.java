package business;

import data.dPhno;
import data.userDAO;
import data.userDAOImp;

import java.util.ArrayList;
import java.util.List;

public class userPhnoImp implements userPhno{

    public final userDAO phno_data = new userDAOImp();
    public void addPhno(bPhno bphno){

        dPhno dphno = new dPhno();

        dphno.setUserId(bphno.getUserId());
        dphno.setPhno(bphno.getPhno());
        dphno.setPhnoCode(bphno.getPhnoCode());



        phno_data.addPhno(dphno);


    }

    public List<bPhno> getPhoneNo(int userId){
        List<bPhno> list = new ArrayList<>();

        for(dPhno d : phno_data.getPhno(userId)){

            bPhno phno = new bPhno();
            phno.setUserId(d.getUserId());
            phno.setCode(d.getPhnoCode());
            phno.setPhno(d.getPhno());

            list.add(phno);

        }
       return list;
    }
}
