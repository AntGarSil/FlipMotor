/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Flipmotor.model.VehicleadvertJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jms.MessageSender;

/**
 *
 * @author root
 */
public class MessageSenderController extends HttpServlet {

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
            /* TODO output your page here
             * 
             */
            
            /**
             * Obtain parameters for message
             */
            Integer senderID = Integer.valueOf(request.getParameter("senderID"));
            Integer vehicleID = Integer.valueOf(request.getParameter("vehicleID"));
            Integer imagenum = Integer.valueOf(request.getParameter("num"));            
            VehicleadvertJpaController vehicleJPA = new VehicleadvertJpaController();
            Integer receiverID = vehicleJPA.findVehicleadvert(vehicleID).getClientID().getClientID();
            
            /**
             * Include parameters and text to message
             */
            MessageSender sender = new MessageSender();
            TextMessage msg = sender.createTextMessage();
            msg.setIntProperty("SenderId", senderID);
            msg.setStringProperty("SenderName", request.getParameter("contactName"));
            msg.setStringProperty("SenderEmail", request.getParameter("contactEmail"));            
            msg.setIntProperty("ReceiverId", receiverID);
            msg.setIntProperty("VehicleAd", vehicleID);            
            msg.setIntProperty("num", imagenum);  
            msg.setText(request.getParameter("message"));
            ///
            
            sender.connect();
            sender.send(msg);
            sender.disconnect();
            request.getRequestDispatcher("/Home").forward(request, response);
            
        } catch (JMSException ex) {
            Logger.getLogger(MessageSenderController.class.getName()).log(Level.SEVERE, null, ex);
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
