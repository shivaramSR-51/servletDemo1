package business;

import data.dPhno;

public class userPhnoImp implements userPhno{
    public void addPhno(bPhno bphno){

        dPhno dphno = new dPhno();

        dphno.setPhno(bphno.getPhno());
        dphno.setPhnoCode(bphno.getPhnoCode());




    }
}
