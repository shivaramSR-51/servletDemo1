package presentation;

import business.bAddress;
import business.userAddress;
import business.userAddressImp;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import java.io.IOException;
@WebServlet
public class addressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
           addUser address = new addUser();
           address.setCountry(request.getParameter("country"));
           address.setCity(request.getParameter("city"));
           address.setStreet(request.getParameter("street"));
           address.setZipcode((request.getParameter("zipcode")));

           bAddress baddress = new bAddress();
           baddress.setCity(address.getCity());
           baddress.setCountry(address.getCountry());
           baddress.setStreet(address.getStreet());
           baddress.setZipcode(address.getZipcode());

           userAddress buaddress =  new userAddressImp();

           buaddress.addAddress(baddress);


    }
}
