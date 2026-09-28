package presentation;
import business.userRegister;
import business.userRegisterImpl;
import business.bUser;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
@WebServlet("/register")

public class registerServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException , IOException{

        //
          rUser ruser = new rUser();

         ruser.setFirstName( request.getParameter("firstName"));
         ruser.setLastName(request.getParameter("lastName"));
         ruser.setEmail(request.getParameter("email"));
         ruser.setPassword(request.getParameter("password"));
         ruser.setConfirmPassword(request.getParameter("confirmPassword"));
//        userRegister.register(firstName,lastName,email,password,confirmPassword);





        bUser buser = new bUser();

        buser.setFirstName(ruser.getFirstName());
        buser.setLastName(ruser.getLastName());
        buser.setEmail(ruser.getEmail());
        buser.setPassword(ruser.getPassword());
        buser.setConfirmPassword(ruser.getConfirmPassword());


        userRegister userRegister = new userRegisterImpl();

        userRegister.register(buser);

    }
}
