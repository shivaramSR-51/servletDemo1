package presentation;

import business.bPhno;
import business.userPhno;
import business.userPhnoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//import java.net.http.HttpRequest;

@WebServlet("/phno")
public class phnoServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

           phUser phno= new phUser();

           phno.setPhno(request.getParameter("phoneNo"));
           phno.setPhnoCode(request.getParameter("countryCode"));

           bPhno bphno = new bPhno();
           bphno.setUserId(userId);
           bphno.setPhno(phno.getPhno());
           bphno.setCode(phno.getPhnoCode());

           userPhno userPhno = new userPhnoImp();
           userPhno.addPhno(bphno);

    }


}
