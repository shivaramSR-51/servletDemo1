package presentation;
import business.userRegister;
import business.userRegisterImpl;
import entity.User;

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
        String firstName = request.getParameter("firstName");

        String lastName = request.getParameter("lastName");

        String email =request.getParameter("email");

        String password = request.getParameter("password");

        String confirmPassword = request.getParameter("confirmPassword");



//        userRegister.register(firstName,lastName,email,password,confirmPassword);

        User user = new User(firstName, lastName,email,password,confirmPassword);
        userRegister userRegister = new userRegisterImpl();

        userRegister.register(user);

    }
}
