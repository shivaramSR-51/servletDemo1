package business;

import data.dAddress;

public class userAddressImp implements userAddress{

    public void addAddress(bAddress address){

        dAddress daddress = new dAddress();
        daddress.setCountry(address.getCountry());
        daddress.setCity(address.getCity());
        daddress.setStreet(address.getStreet());
        daddress.setZipcode(address.getZipcode());




    }
}
