/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Entities.Administrato;
import model.Entities.Offer;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.model.AdministratoJpaController;
import model.model.OfferJpaController;
import model.model.exceptions.PreexistingEntityException;
import model.model.exceptions.RollbackFailureException;

/**
 *
 * @author jorge
 */
public class CreateOfferController extends HttpServlet {

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
            String offer_name = request.getParameter("name");
            String offer_type = request.getParameter("offerType");
            String offer_end = request.getParameter("enddate");
            String offer_fee = request.getParameter("fee");
            String offer_months = request.getParameter("months");
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            
            System.out.println("ENDS: "+offer_end);
            
            String publicationString = format.format(new Date());
            Date expires = null;
            Date publication = null;
            try {
                 expires = format.parse(offer_end);
                 publication = format.parse(publicationString);
            } catch (ParseException ex) {
                Logger.getLogger(CreateOfferController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            OfferJpaController offerJPA = new OfferJpaController();
            Offer existsOffer = offerJPA.findOffer(offer_name);
            if(existsOffer != null){
                request.getRequestDispatcher("/offerRegistrationError.jsp").forward(request, response);
            }else{
                Offer offer = new Offer(offer_name, offer_type,Integer.valueOf(offer_fee), publication, Integer.valueOf(offer_months), expires, 0);
                try {
                    offerJPA.create(offer);
                    request.getRequestDispatcher("/AdminPage").forward(request, response);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(CreateOfferController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(CreateOfferController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(CreateOfferController.class.getName()).log(Level.SEVERE, null, ex);
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
