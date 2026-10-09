package business;

import data.dAddress;
import data.userDAO;
import data.userDAOImp;

public class userAddressImp implements userAddress{

    public void addAddress(bAddress address){

        dAddress daddress = new dAddress();
        daddress.setUserId(address.getUserId());
        daddress.setCountry(address.getCountry());
        daddress.setCity(address.getCity());
        daddress.setStreet(address.getStreet());
        daddress.setZipcode(address.getZipcode());


        userDAO address_data = new userDAOImp();

        address_data.addUserAddress(daddress);


    }
}
