/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Flipmotor.Entities.Vehicleadvert;
import controller.Utils.Common;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Flipmotor.model.VehicleadvertJpaController;

/**
 *
 * @author PC
 */
public class QueryController extends HttpServlet {

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


            
            request.getRequestDispatcher("/header.jsp").include(request, response); 

            

            
    out.println("   <script> ");


    out.println("        $('#tabs').ready(function(){ ");
    out.println("            $('#results').tablesorter(); ");
    out.println("        }); ");
        
    out.println("        $('#tabs').ready(function() { ");
    out.println("                $( '#tabs' ).tabs(); ");
    out.println("        }); ");
           
        
    out.println("    </script> ");
    out.println("    <div id='bodycontent'> ");
    out.println("        <div id='tabs' style='width: 90%; height: 500px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px; ");
    out.println("    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;' > ");
    out.println("            <ul> ");
    out.println("                <li><a href='#tabs-1'>Results</a></li> ");
    out.println("            </ul> ");
    out.println("            <div id='tabs-1' style='-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:100%; margin-bottom: 20px;'> ");
    out.println("                <div id='tableContainer' class='tableWrapper'> ");
    out.println("                <table id='results' style='margin: auto; margin: auto;' class='tablesorter'> ");
                    
    out.println("                    <thead style='display: block;'> ");
    out.println("                        <tr><th style='width:200px;'>Date</th><th style='width:60px;'>Photo</th><th style='width:200px;'>Brand and Model</th><th style='width:200px;'>State</th><th style='width:50px;'>Year</th><th style='width:100px;'>Price</th><th style='width:80px;'>Visit AD</th></tr> ");
    out.println("                    </thead> ");
    out.println("                    <tbody style='overflow: auto; display: block; height: 390px;'> ");
    
    String opt = request.getParameter("opt");
    List<Vehicleadvert> res = new ArrayList<Vehicleadvert>();
    VehicleadvertJpaController vehiclejpa = new VehicleadvertJpaController();    
    
    if(opt.equals("General"))
    {
        res = vehiclejpa.findVehicleadvertEntities();
    }
    if(opt.equals("Cars")){
        res = vehiclejpa.findByVehicle("Car");
    }
    if(opt.equals("Motorbikes")){
        res = vehiclejpa.findByVehicle("Motorbike");
    }
    

    HttpSession session = request.getSession(true);
                //Log in will expire every 20 minutes
    session.setMaxInactiveInterval(20 * 60);
    //Store user credential
    session.setAttribute("vehicles", res);
    
    
    
    for(int i = 0; i < res.size(); i++)
    {
        
        Vehicleadvert entity = res.get(i);

        out.println("                        <tr><td style='width:199px;'>" + entity.getPublicationDate() + "</td><td style='width:62px;'><iframe width='100' height='100' frameBorder='0' src='ImagePrinterHelper?height=80&width=80&num=" + i +"'></iframe></td><td style='width:200px;'>" + entity.getBrand() +"</td><td style='width:201px;'>" + entity.getState() +"</td><td style='width:52px;'>" + entity.getYearV() +"</td><td style='width:102px;'>" + entity.getPrice() +" $</td><td style='width:66px;'><form id='ad_id' action='Advert' method='GET' ><input type='hidden' name='code' value='" + entity.getCode() + "'/><input type='hidden' name='num' value='" + i + "'/><input type='submit' id='visitAd1' value='Visit AD'></form></td></tr> ");    
    }
    
    
                        
    out.println("                    </tbody> ");
    out.println("                </table> ");
    out.println("                </div> ");
    out.println("            </div> ");
    out.println("        </div> ");
    out.println("    </div> ");
            
            
            request.getRequestDispatcher("/footer.jsp").include(request, response); 
            
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
