/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Datastore.Entities.UserEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antón García Dosil
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            /*
             * Class that checks a list to see if the user is logged in.
             * Creates session attributes with userid
             */
            
            /////////////////// This section shall be replaced with a database query ///////////
            UserEntity user1 = new UserEntity("12345678","juanito","juanitoh");
            UserEntity user2 = new UserEntity("111111111","asdf","asdf");            
            List<UserEntity> userList  = new ArrayList<UserEntity>();
            
            userList.add(user1);
            userList.add(user2);
            ////////////////////////////////////////////////////////////////////////////////////
            
            String req_name = request.getParameter("username");
            String req_pass = request.getParameter("userpass");
            
            boolean accept = false;
            UserEntity result = new UserEntity();
            
            for(int i = 0; i < userList.size(); i++)
            {
                if(userList.get(i).getUserName().equalsIgnoreCase(req_name) 
                        && userList.get(i).getUserPassword().equalsIgnoreCase(req_pass)){
                    
                    result.setUserID(userList.get(i).getUserID());
                    result.setUserName(req_name);
                    result.setUserPassword(req_pass);
                    
                    accept = true;
                    break;
                }
            }
            
            if(accept){
                HttpSession session = request.getSession(true);
                //Log in will expire every 20 minutes
                session.setMaxInactiveInterval(20 * 60);
                //Store user credential
                session.setAttribute("userid", 1234);
            }else{
                // SHOW WRONG LOGIN INPUT MESSAGE

            }
            request.getRequestDispatcher("/Home").forward(request, response);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
