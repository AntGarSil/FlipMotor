/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Entities.Vehicleadvert;
import model.model.VehicleadvertJpaController;
import model.model.exceptions.IllegalOrphanException;
import model.model.exceptions.NonexistentEntityException;
import model.model.exceptions.RollbackFailureException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "ValidateVehicleController", urlPatterns = {"/ValidateVehicleController"})
public class ValidateVehicleController extends HttpServlet {

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
            VehicleadvertJpaController vehJPA = new VehicleadvertJpaController();
            List <Vehicleadvert> notValidated = new ArrayList <Vehicleadvert>();
            notValidated = vehJPA.findNotValidatedVehicles();
                       
            for(int i = 0; i<notValidated.size(); i++) {
                if(request.getParameter("vRow"+i) != null ){
                    String code = request.getParameter("id"+i);
                    Vehicleadvert ad = vehJPA.findVehicleadvert(Integer.parseInt(code));
                    boolean payed = ad.getState().equalsIgnoreCase("payed");
                    if(payed){
                        ad.setState("Validated");
                        try {
                            vehJPA.edit(ad);
                        } catch (IllegalOrphanException ex) {
                            Logger.getLogger(ValidateVehicleController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(ValidateVehicleController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (RollbackFailureException ex) {
                            Logger.getLogger(ValidateVehicleController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(ValidateVehicleController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            request.getRequestDispatcher("/AdminPage").forward(request, response);
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
