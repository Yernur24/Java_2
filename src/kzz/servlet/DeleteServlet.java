package kzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kzz.db.DBConnection;
import kzz.db.Users;

import java.io.IOException;

@WebServlet("/delete-item")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users = (Users) request.getSession().getAttribute("currentUser");
        if(users!=null){
            int id = Integer.parseInt(request.getParameter("id"));
            DBConnection.DeleteItem(id);
            response.sendRedirect("/");
        }else{
            response.sendRedirect("/login");
        }
    }
}
