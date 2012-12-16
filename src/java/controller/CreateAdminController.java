/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Entities.Administrato;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.model.AdministratoJpaController;
import model.model.exceptions.PreexistingEntityException;
import model.model.exceptions.RollbackFailureException;
import java.util.List;

/**
 *
 * @author jorge
 */
public class CreateAdminController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String admin_user = request.getParameter("id");
            String admin_pass = request.getParameter("password");
            String admin_email = request.getParameter("email");
            
            AdministratoJpaController adminJPA = new AdministratoJpaController();
            Administrato existAdmin = adminJPA.findAdministratoByName(admin_user);

            if(null != existAdmin)
            {
                System.out.println("CREATING ADMIN");
                request.getRequestDispatcher("/adminRegistrationError.jsp").forward(request, response);
                return;
            }else{
                Administrato admin = new Administrato(0, admin_user, admin_pass, 0, admin_email);
                try {
                    adminJPA.create(admin);
                    request.getRequestDispatcher("/AdminPage").forward(request, response);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(CreateAdminController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(CreateAdminController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(CreateAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
