/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antón García Dosil
 */
@WebServlet(name = "Controller",
            loadOnStartup = 1,
            urlPatterns = {"/IndexHelper",
                           "/Cars",
                           "/General",
                           "/Motorbikes",
                           "/UserProfile",
                           "/Register"
                           })
public class ControllerServlet extends HttpServlet {

    
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();
        
        /**
         * SAMPLE CODE
         */
        // if category page is requested
        if (userPath.equals("/category")) {
            // TODO: Implement category request

        // if cart page is requested
        } else if (userPath.equals("/toMotorQuery")) {
            // TODO: Implement motorbike page request
            

        // if checkout page is requested
        } else {
            userPath = "/footer.jsp";
        } 

        // use RequestDispatcher to forward request internally
        String url = userPath;

        try {
            request.getRequestDispatcher(url).forward(request, response);            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if toVehicleQuery action is called
        if (userPath.equals("/Cars")) {
            // TODO: Implement toVehicleQuery action
            userPath = "/query.jsp";
        }else if (userPath.equals("/Motorbikes")) {
            // TODO: Implement motorbike page request
            
             userPath = "/query.jsp";
        // if checkout page is requested
        } else if (userPath.equals("/General")) {
            // TODO: Implement motorbike page request
            
             userPath = "/query.jsp";
        // if checkout page is requested
        } else if (userPath.equals("/UserProfile")) {
            // TODO: Implement motorbike page request
            userPath = "/UserProfileController";

             //userPath = "/query";
        // if checkout page is requested
        } else if (userPath.equals("/Register")) {
            // TODO: Implement motorbike page request
            userPath = "/registration.jsp";

             //userPath = "/query";
        // if checkout page is requested
        } 

        // use RequestDispatcher to forward request internally
        String url = userPath;

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}