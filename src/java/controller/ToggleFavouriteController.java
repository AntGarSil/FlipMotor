/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Datastore.Entities.Fav;
import Datastore.Entities.Registeredclient;
import Datastore.Entities.Vehicleadvert;
import controller.Utils.Common;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FavJpaController;
import model.RegisteredclientJpaController;
import model.VehicleadvertJpaController;
import model.exceptions.PreexistingEntityException;
import model.exceptions.RollbackFailureException;

/**
 *
 * @author root
 */
public class ToggleFavouriteController extends HttpServlet {

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

            FavJpaController favJPA = new FavJpaController();
            RegisteredclientJpaController clientJPA = new RegisteredclientJpaController();
            VehicleadvertJpaController vehicleJPA = new VehicleadvertJpaController();
            
            Integer code = Integer.valueOf(request.getParameter("code"));
            String num = request.getParameter("num");
            
            HttpSession session = request.getSession(true);
            Integer uid = -1;
            if(null != session.getAttribute("userid")){
                uid = (Integer) session.getAttribute("userid");    
            } else{
                out.println("Session Expired");
            }

            Registeredclient client = clientJPA.findRegisteredclient(uid);
            Vehicleadvert vehicle = vehicleJPA.findVehicleadvert(code);
            int favID = Common.generateFavID(vehicle, client);
            
            Fav newFavRelationship = new Fav();
            newFavRelationship.setClientID(client);
            newFavRelationship.setCode(vehicle);
            newFavRelationship.setId(favID);
            
            Fav relationship = favJPA.findFav(favID);
            
            try{
                
                if(null != relationship)
                {
                        favJPA.destroy(relationship.getId());
                }else{

                        favJPA.create(newFavRelationship);
                }
            
            } catch (PreexistingEntityException ex) {
                    Logger.getLogger(ToggleFavouriteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(ToggleFavouriteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ToggleFavouriteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
          request.getRequestDispatcher("/Advert?code=" + vehicle.getCode() + "&num=" + num).forward(request, response);  
            

            
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
