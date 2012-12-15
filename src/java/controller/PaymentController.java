/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Flipmotor.Entities.Conciliation;
import Flipmotor.Entities.Registeredclient;
import Flipmotor.model.ConciliationJpaController;
import Flipmotor.model.RegisteredclientJpaController;
import Flipmotor.model.exceptions.PreexistingEntityException;
import Flipmotor.model.exceptions.RollbackFailureException;
import controller.Utils.Common;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
public class PaymentController extends HttpServlet {

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

            ConciliationJpaController conciJPA = new ConciliationJpaController();
            HttpSession session = request.getSession(true);
           int price=0;
            if(null != session.getAttribute("fee")){
                price = (Integer) session.getAttribute("fee"); 
                //out.println("Price fee"+price);
            } else{
                out.println("Session Expired");
                throw new Exception ("Something funky going on with your session");
            }
            /*int uid=0;
            if(null != session.getAttribute("userid")){
                uid = (Integer) session.getAttribute("userid"); 
                out.println("User ID"+uid);
            } else{
                out.println("Session Expired");
                throw new Exception ("Something funky going on with your session");
            }*/
                        int uid=1;//cambiar por el de la sesion
            RegisteredclientJpaController userJPA = new RegisteredclientJpaController();
            Registeredclient user = userJPA.findRegisteredclient(Integer.valueOf(uid));
            
            
           String card = request.getParameter("card");
            String month= request.getParameter("cboExpMonth");
            String year=request.getParameter("cboExpYear");
            
            //int PK = Common.generateUserID(email);
            int code=1;//value we should get frmo the web service
            Date date=new Date();
            //int price=10;
            //(Integer code, Date tdate, int price, long creditcard)
            Conciliation newConci = new Conciliation(code,date,price,Long.valueOf(card));
            newConci.setClientID(user);
            response.setContentType("text/html");
            request.getRequestDispatcher("/header.jsp").include(request, response); 
            
            out.println("<div id='bodyContent'> ");
            out.println("<script> ");
            out.println("    $('#tabs').ready(function(){ ");
            out.println("        $('#tabs').tabs(); ");
            out.println("        $('#posted').tablesorter(); ");
            out.println("        $('#editProfileButton').click(function() { ");
            out.println("            $('#rightProfilePanel').toggle(); ");
            out.println("        }); ");
            out.println("    }); ");
            out.println("</script> ");  
            out.println("            <div id='bodycontent' style='margin-top: 10px;'> ");
            out.println("                 <div id='tabs' class='tabs'  style='width: 90%; height: 400px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px; ");
            out.println("                     -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;' > ");
            out.println("                      <ul> ");
            
            out.println("                          <li><a href='#feedback'>Feedback</a></li> ");
            out.println("                      </ul> ");
            out.println("            <div id='feedback'style='-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:420px; margin-bottom: 20px;'>");
            out.println("                <div id='vehicleContainer' style='overflow: auto; height: 100%;' class='tableWrapper'>");
            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      CONFIRMATION HERE                              //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
           // int code=-1;
                //out.println("                               <div>Fee: "+price+" </div> ");
                if(code>0)
                {
                    out.println("                               <div>SUCCESSFUL TRANSACTION!! Code "+code+" </div> ");
                    out.println("                               <div>"+price+"€ were charged in your account</div> ");
                }
                else{
                    out.println("                               <div>THERE WAS AN ERROR IN THE TRANSACTION, TRY AGAIN LATER </div> ");
                }
            out.println("             </div> ");
            out.println("         </div> ");
            out.println("     </div> ");
            out.println("   </div> ");
            out.println("</div> ");	
            
                
    request.getRequestDispatcher("/footer.jsp").include(request, response); 
            
           try {
                int count = conciJPA.getConciliationCount();
                conciJPA.create(newConci);
                count = conciJPA.getConciliationCount();
                
                
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RollbackFailureException ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }       
            
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
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
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
