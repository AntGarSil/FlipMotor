/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import flipserviceimplementation.BankService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entities.Conciliation;
import model.model.ConciliationJpaController;
import model.model.exceptions.RollbackFailureException;

/**
 *
 * @author root
 */
@WebServlet(name = "TransactionController", urlPatterns = {"/TransactionController"})
public class TransactionController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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

            
            String credit = request.getParameter("ccard");
            int expireMonth = Integer.valueOf(request.getParameter("expMonth"));
            int expireYear = Integer.valueOf(request.getParameter("expYear"));
            int price = Integer.valueOf(request.getParameter("price"));
            int clientId = Integer.valueOf(request.getParameter("clientId"));
            int vehicleId = Integer.valueOf(request.getParameter("vehicleId"));
            
            
            flipserviceimplementation.BankService_Service bs = new BankService_Service();
            int code = bs.getBankServicePort().validateCreditCard(credit, expireMonth, expireYear);
            
            if(code != -1)
            {
                ConciliationJpaController conJPA = new ConciliationJpaController();
                Conciliation con = new Conciliation(code, new java.sql.Date(new java.util.Date().getTime()), price, Long.valueOf(credit));
                conJPA.create(con);

                bs.getBankServicePort().sendTransactionalInformation(code, clientId, price, vehicleId, code, Long.valueOf(credit));
            }
            
            
            
        } catch (RollbackFailureException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
