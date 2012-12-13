/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Flipmotor.Entities.Registeredclient;
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
import Flipmotor.model.RegisteredclientJpaController;

/**
 *
 * @author root
 */
public class EditProfileController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
 
            RegisteredclientJpaController userJPA = new RegisteredclientJpaController();
            
            
            //phone, nif, street, flat, surname, number, password, city
            //email, name, pc, province, letter, card
            
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String phone = "0" + request.getParameter("phone");
            String nif = request.getParameter("nif");
            String street = request.getParameter("street");
            String flat = "0" + request.getParameter("flat");
            String number = "0" + request.getParameter("number");
            String password = request.getParameter("password");
            String city = request.getParameter("city");
            String email = request.getParameter("email");
            String pc = "0" + request.getParameter("pc");
            String leter = request.getParameter("leter");
            String province = request.getParameter("province");
            int PK = -1;
            
            /*Registeredclient(Integer clientID, String nif, int phone,
                    String email, String nam, String surname, String passwor,
                            long creditCard, String nationality, int pc,
                                    String city, String province, String street, int numbe,
                                            int flat, int fav, int anuncio)*/
            Registeredclient newClient = new Registeredclient(PK,nif,Integer.valueOf(phone),
                    email, name, surname, password, "NA", Integer.valueOf(pc),
                    city, province, street, Integer.valueOf(number),Integer.valueOf(flat),
                    -1);
            if(leter.length() != 0){
                newClient.setLeter(leter.charAt(0));
            }else{
                newClient.setLeter('0');
            }
            
            HttpSession session = request.getSession(true);
            Integer uid = -1;
            if(null != session.getAttribute("userid")){
                uid = (Integer) session.getAttribute("userid");    
            } else{
                out.println("Session Expired");
                throw new Exception ("Something funky going on with your session");
            }
            
            Registeredclient oldClient = userJPA.findRegisteredclient(uid);
            
            if(newClient.getCity().length() != 0)
            {
                oldClient.setCity(newClient.getCity());
            }
            
          //  if(newClient.getCreditCard() != 0)
           // {
            //    oldClient.setCreditCard(newClient.getCreditCard());
            //}
            
            
            if(newClient.getFlat() != 0)
            {
                oldClient.setFlat(newClient.getFlat());
            }
            
            if(newClient.getLeter() != '0')
            {
                oldClient.setLeter(newClient.getLeter());
            }            
            
            if(newClient.getNam().length() != 0)
            {
                oldClient.setNam(newClient.getNam());
            }
            
            if(newClient.getNif().length() != 0)
            {
                oldClient.setNif(newClient.getNif());
            }
            
            if(newClient.getNumbe() != 0)
            {
                oldClient.setNumbe(newClient.getNumbe());
            }
            
            if(newClient.getPasswor().length() != 0)
            {
                oldClient.setPasswor(newClient.getPasswor());                
            }            
            
            if(newClient.getPc() != 0)
            {
                oldClient.setPc(newClient.getPc());
            }            
            
            if(newClient.getPhone() != 0)
            {
                oldClient.setPhone(newClient.getPhone());
            }            
            
            if(newClient.getProvince().length() != 0)
            {
                oldClient.setProvince(newClient.getProvince());
            }
            
            if(newClient.getStreet().length() != 0)
            {
                oldClient.setStreet(newClient.getStreet());
            }            
            
            if(newClient.getSurname().length() != 0)
            {
                oldClient.setSurname(newClient.getSurname());
            }            
            

            
            userJPA.edit(oldClient);
            request.getRequestDispatcher("/UserProfileController").include(request, response); 
            
            
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
