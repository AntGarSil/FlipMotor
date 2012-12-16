/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Entities.Fav;
import model.Entities.Registeredclient;
import model.Entities.Vehicleadvert;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import model.model.FavJpaController;
import model.model.RegisteredclientJpaController;
import model.model.VehicleadvertJpaController;

/**
 *
 * @author root
 */
public class ViewAdController extends HttpServlet {

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
          
            List<Vehicleadvert> vehicles = new ArrayList<Vehicleadvert>();
           
                
          request.getRequestDispatcher("/header.jsp").include(request, response); 
          
          HttpSession session = request.getSession(true);
          Integer adcode = Integer.valueOf(request.getParameter("code"));
          Integer imagenum = Integer.valueOf(request.getParameter("num"));
          
          VehicleadvertJpaController vehicleJPA = new VehicleadvertJpaController();
          Vehicleadvert showVehicle = vehicleJPA.findVehicleadvert(adcode);
          
          Integer uid = -1;
          boolean hasSession = false;
            if(null != session.getAttribute("userid")){
                uid = (Integer) session.getAttribute("userid");    
                hasSession = true;
            }
       
            out.println(" <script> ");
            out.println("         $('#adContainer').ready(function(){");
            out.println("            $('#adContainer').tabs();");
            out.println("         });");
            out.println(" </script>");
            out.println(" <div id='bodyContent'>");
            out.println("     <div id='adContainer' style='width: 90%; height: 870px;  margin: auto; border: 2px solid grey; padding: 3px; margin-top: 5px;");
            out.println("     -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px; font-size: 12px;'>");
            out.println("             <ul>");
            out.println("                 <li><a href='#tabs-1'>Nombre de mi Ad</a></li>");
            out.println("             </ul>");
            out.println("             <div id='tabs-1' style='-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:420px; margin-bottom: 20px;'>");

            out.println("             <div style='float:left; width: 240px; height:100%'>");
            out.println("                 <div id='adPhoto' style='width: 250px; height: 250px; background-color: red;'>");
            out.println("                     ");
            out.println("                     <iframe src='ImagePrinterHelper?width=230&height=230&num=" + imagenum +"' scrollbar='no'  width='250' height='250' frameBorder='0' >Photo</iframe>");
            out.println("                 </div>");
            out.println("                 <div id='favBox' style='width: 100%; height: 30%;'>");
            
            
            if(hasSession == true)
            {
                FavJpaController favJPA = new FavJpaController();
                RegisteredclientJpaController clieJPA = new RegisteredclientJpaController();
                Registeredclient clie = clieJPA.findRegisteredclient(uid);
                
                Fav favourite = favJPA.FindFavourite(clie, showVehicle); 
                
                if(null != favourite)
                {
                    out.println("                 <form action='MakeFavourite' method='POST'>");           
                    out.println("                     <input type='image' src='images/Star-Favorite.png' style='width: 50px;  margin-top: 30px;  margin-left: auto; margin-right: auto; display: block;'>");
                    out.println("                     <input type='hidden' name='code' value='" + showVehicle.getCode() + "'/> ");
                    out.println("                     <input type='hidden' name='num' value='" + imagenum + "'/> ");
                    out.println("                 </form>");
                }else{                                    
                    out.println("                 <form action='MakeFavourite' method='POST'>");           
                    out.println("                     <input type='image' src='images/Star-Favorite-Black.png' style='width: 50px;  margin-top: 30px;  margin-left: auto; margin-right: auto; display: block;'>");
                    out.println("                     <input type='hidden' name='code' value='" + showVehicle.getCode() + "'/> ");
                    out.println("                     <input type='hidden' name='num' value='" + imagenum + "'/> ");
                    out.println("                 </form>");
                }
            }
            out.println("                 </div>");
            out.println("             </div>");

            out.println("             <div id='adDescription' style='float:left; width: 380px; height:100%; margin-left: 40px;'>");
            out.println("                 <h2>Details</h2>");
            out.println("                 <div style='height: 60px;'>");
            out.println("                     <div style='float:left; width: 50%;'>");
            out.println("                     Type: " + showVehicle.getVehicle() +" <br>");
            out.println("                     Brand: " + showVehicle.getBrand() + "<br>");
            out.println("                     Model: " + showVehicle.getModelV() +  "<br>");
            out.println("                     Color:" + showVehicle.getColor() + "<br>");
            out.println("                 </div>");
            out.println("                 <div style='float:left; width: 50%;'>");
            out.println("                     Year: " + showVehicle.getYearV() + "<br>");
            out.println("                     Km: "+ showVehicle.getKm()+" Km<br>");
            out.println("                     Price: " + showVehicle.getPrice()+ " $<br>");
            out.println("                     Ad date: " + showVehicle.getPublicationDate() +"<br>");
            out.println("                 </div>");

            out.println("                 </div>");

            out.println("                 <div style='width:100%; height: 150px; margin-top:25px;'>");
            out.println("                     <h4>Description</h4>");
            out.println("                     " + showVehicle.getText() + "");
            out.println("                 </div>");
            out.println("                 <div id='footBar' style='width:100%; height:auto;'>");
            out.println("                 </div>");
            out.println("             </div> ");

            
            if(hasSession)
            {
                out.println("             <div id='contactBox' style='float:left; width: 275px; height:100%; margin-left: 20px; border-left: 2px solid gray;'>");
                out.println("                 <div id='contactInfo' style='width: 100%; height: auto; margin-top: 10px;'>");
                out.println("                     <form action='SendMessage' method='POST'>");
                out.println("                         <div style='margin-left: 10px; margin-top: 20px;'>");
                out.println("                             <h2>Contact the Advertiser</h2>");
                out.println("                             Name: <br>");
                out.println("                             <input id='contactName' name='contactName' type='text'>");
                out.println("                         </div>");
                out.println("                         <div style='margin-left: 10px; margin-top: 20px;'>");
                out.println("                             Message:<br>");
                out.println("                             <textarea rows='6' cols='30' maxlength='250' name='message' style='height=100px; width=240px'></textarea>"); // <input id='message' type='text' maxlength='250' style='height: 100px; width: 240px;'>");
                out.println("                         </div>");
                out.println("                         <div style='margin-left: 10px; margin-top: 20px;'>");
                out.println("                             E-mail:<br>");
                out.println("                             <input id='contactEmail' name='contactEmail' type='text'>");
                out.println("                         </div>");
                out.println("                     <input type='hidden' name='senderID' value='" + uid + "'/> ");
                out.println("                     <input type='hidden' name='vehicleID' value='" + adcode + "'/> ");
                out.println("                     <input type='hidden' name='num' value='" + imagenum + "'/> ");
                out.println("                         <div id='submitMessage' style='width: 100%; margin-top: 25px;'>");
                out.println("                             <input id='submitMessageButton' type='Submit' value='Send Message' style='margin-left: auto; margin-right: auto; display:block;'>");
                out.println("                         </div>");
                out.println("                     </form>");
                out.println("                 </div>");
                out.println("             </div>");
                out.println("        </div>");
                out.println("     </div>");
            }
            out.println(" </div>");
            

           request.getRequestDispatcher("/footer.jsp").include(request, response); 
             
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
