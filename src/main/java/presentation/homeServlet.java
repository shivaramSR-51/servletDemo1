package presentation;

import business.bAddress;
import business.bPhno;
import business.userAddress;
import business.userAddressImp;
import business.userPhno;
import business.userPhnoImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class homeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }


        userPhno phoneService = new userPhnoImp();
        List<phUser> phones = new ArrayList<>();

        for (bPhno b : phoneService.getPhoneNo(userId)) {
            phUser p = new phUser();
            p.setPhnoCode(b.getPhnoCode());
            p.setPhno(b.getPhno());
            phones.add(p);
        }


        userAddress addressService = new userAddressImp();
        List<addUser> addresses = new ArrayList<>();

        for (bAddress b : addressService.getAddress(userId)) {
            addUser a = new addUser();
            a.setStreet(b.getStreet());
            a.setCity(b.getCity());
            a.setCountry(b.getCountry());
            a.setZipcode(b.getZipcode());
            addresses.add(a);
        }

        request.setAttribute("phones", phones);
        request.setAttribute("addresses", addresses);

        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}