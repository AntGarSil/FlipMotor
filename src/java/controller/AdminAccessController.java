/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Entities.Administrato;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.model.AdministratoJpaController;
import java.util.List;

/**
 *
 * @author jorge
 */
public class AdminAccessController extends HttpServlet {

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
            HttpSession session = request.getSession(true);;
            if(null == session.getAttribute("adminid")){
                    /*
                 * Class that checks a list to see if the user is logged in.
                 * Creates session attributes with userid
                 */            

                String req_name = request.getParameter("username");
                String req_pass = request.getParameter("userpass");

                AdministratoJpaController adminJPA = new AdministratoJpaController();
                
                //Check if the ID is in the database
                Administrato admin = adminJPA.findAdministratoByName(req_name);
                
                //Administrato admin = adminList.get(0);

                if(null != admin && admin.getPasswor().equals(req_pass)){
                    //Log in will expire every 20 minutes
                    session.setMaxInactiveInterval(20 * 60);
                    //Store user credential
                    session.setAttribute("adminid", admin.getAdminID());
                    request.getRequestDispatcher("/AdminPage").forward(request, response);
                }else{
                    // SHOW WRONG LOGIN INPUT MESSAGE
                    request.getRequestDispatcher("/Home").forward(request, response);

                }
            }else{
                session.invalidate();
                request.getRequestDispatcher("/Home").forward(request, response);
            }  
        }catch(Exception e){
            e.printStackTrace();
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
