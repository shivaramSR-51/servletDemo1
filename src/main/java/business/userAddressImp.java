package business;

import data.dAddress;
import data.userDAO;
import data.userDAOImp;

import java.util.ArrayList;
import java.util.List;

public class userAddressImp implements userAddress{

   public final  userDAO address_data = new userDAOImp();
    public void addAddress(bAddress address){

        dAddress daddress = new dAddress();
        daddress.setUserId(address.getUserId());
        daddress.setCountry(address.getCountry());
        daddress.setCity(address.getCity());
        daddress.setStreet(address.getStreet());
        daddress.setZipcode(address.getZipcode());

        address_data.addUserAddress(daddress);


    }
    @Override
    public List<bAddress> getAddress(int userId){

        List<bAddress> list  = new ArrayList<>();


        for(dAddress d : address_data.getAddresses(userId)){

            bAddress b = new bAddress();
            b.setUserId(d.getUserId());
            b.setStreet(d.getStreet());
            b.setCity(d.getCity());
            b.setCountry(d.getCountry());
            b.setZipcode(d.getZipcode());

            list.add(b);
        }
        return list;
    }

}

