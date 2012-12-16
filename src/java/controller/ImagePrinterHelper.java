/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Entities.Vehicleadvert;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.model.VehicleadvertJpaController;


/**
 *
 * @author root
 */
public class ImagePrinterHelper extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        try {
                                
                List<Vehicleadvert> vehicles = new ArrayList<Vehicleadvert>();
                
                
                /*
                 * Receives vehicle number
                 * Receives output image width and height
                 */
                Integer num = Integer.valueOf(request.getParameter("num"));
                Integer width = Integer.valueOf(request.getParameter("width"));
                Integer height = Integer.valueOf(request.getParameter("height"));
                
                
                HttpSession session = request.getSession(true);
                
                if(null != session.getAttribute("vehicles")){
                    vehicles = (List<Vehicleadvert>) session.getAttribute("vehicles");
                    
                } else{                    
                    throw new Exception ("Something funky going on with your session");
                }

                
                VehicleadvertJpaController vehicleJPA = new VehicleadvertJpaController();
                if(vehicles.isEmpty())
                {
                    vehicles.add(vehicleJPA.findVehicleadvert(num));
                }

            
                BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(vehicles.get(num).getImag()));
                
                BufferedImage scaledImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = scaledImage.createGraphics();
                g.setComposite(AlphaComposite.Src);
                g.drawImage(bufferedImage,0,0,width,height, null);
                g.dispose();
                                                
                response.setContentType("image/jpeg");
                //response.setContentLength(vehicles.get(num).getImag().length);                
                
                ImageIO.write(scaledImage, "jpeg", response.getOutputStream());
                //response.getOutputStream().write(vehicles.get(num).getImag());
                //response.getOutputStream().flush();
                //response.getOutputStream().close();
                
                //ServletOutputStream oStream = response.getOutputStream();
                //oStream.write(vehicles.get(num).getImag());
                //oStream.flush();
                //oStream.close();
            
            
        } finally {            
            //out.close();
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
            Logger.getLogger(ImagePrinterHelper.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ImagePrinterHelper.class.getName()).log(Level.SEVERE, null, ex);
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
