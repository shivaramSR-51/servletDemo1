package presentation;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import java.io.IOException;


import business.userLogin;
import business.userLoginImp;
import business.blUser;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        lUser login = new lUser();
        login.setEmail(email);
        login.setPassword(password);

        blUser bluser = new blUser();
        bluser.setEmail(login.getEmail());
        bluser.setPassword(login.getPassword());

        userLogin loginUser = new userLoginImp();
        blUser loggedin =  loginUser.login(bluser);

        if(loggedin != null){
            HttpSession session = request.getSession();
            session.setAttribute("firstName",loggedin.getFirstName());
            session.setAttribute("lastName",loggedin.getLastName());
            session.setAttribute("email",loggedin.getEmail());
            session.setAttribute("userId",loggedin.getUserId());


            response.sendRedirect("home.jsp");
            System.out.println("Login Successful");


        }else{
            response.sendRedirect("login.jsp");
            System.out.println("Error occured login failed...");
        }

    }

}
