/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Entities.Administrato;
import model.Entities.Businessadvert;
import model.Entities.Offer;
import model.Entities.Vehicleadvert;
import model.model.AdministratoJpaController;
import model.model.BusinessadvertJpaController;
import model.model.OfferJpaController;
import model.model.VehicleadvertJpaController;
import advertisement.AdvertisementEJBLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import statistics.StatisticsEJB;
import statistics.StatisticsEJBLocal;

/**
 *
 * @author jorge
 */
public class AdminController extends HttpServlet {

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
    
    @EJB
    StatisticsEJBLocal statsEJB;
    @EJB
    AdvertisementEJBLocal adEJB;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            
            // Vehicles List
            List <Vehicleadvert> notValidated = new ArrayList <Vehicleadvert>();
            VehicleadvertJpaController vehJPA = new VehicleadvertJpaController();
            notValidated = vehJPA.findNotValidatedVehicles();
            
            // Business List
            List <Businessadvert> notValidatedBus = new ArrayList <Businessadvert>();
            BusinessadvertJpaController busJPA = new BusinessadvertJpaController();
            notValidatedBus = busJPA.findNotValidatedBusiness();
            
            // Admin List
            List <Administrato> admins = new ArrayList <Administrato>();
            AdministratoJpaController adminJPA = new AdministratoJpaController();
            admins = adminJPA.findAdministratoEntities();
            // Offer List
            List <Offer> offers = new ArrayList <Offer>();
            OfferJpaController offerJPA = new OfferJpaController();
            offers = offerJPA.findOfferEntities();
            
            
            long [] stats = null;
            // Statistics
            if(statsEJB == null){
                System.out.println("Could not locate Stats EJB");
            }else{
                stats = statsEJB.getStatistics();
            }
            
            long nextAd = -1;
            // Statistics
            if(adEJB == null){
                System.out.println("Could not locate Advertisement EJB");
            }else{
                nextAd = adEJB.getNextBanner();
            }
            
            /**************************************
             * Generate Output
             * ************************************/
            request.getRequestDispatcher("/header.jsp").include(request, response);
          
    out.println("<style>");
    out.println(".ui-tabs-vertical { width: 55em; }");
    out.println(".ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }");
    out.println(".ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }");
    out.println(".ui-tabs-vertical .ui-tabs-nav li a { display:block; }");
    out.println(".ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }");
    out.println(".ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}");
    out.println("</style>");
    out.println("<script src='js/jquery.validate.js' type='text/javascript'></script>");
    out.println("<script src='js/register.js' type='text/javascript'></script>");
    out.println("<script src='js/jquery.validate.password.js' type='text/javascript'></script>");
    out.println("<script>");
        out.println("$('#tabs').ready(function(){");
           out.println("$('#tabs').tabs();");
        out.println("});");

        out.println("$('#extraManagement').ready(function(){");
           out.println("$('#extraManagement').tabs().addClass( 'ui-tabs-vertical ui-helper-clearfix' );");
           out.println("$('#extraManagement li' ).removeClass( 'ui-corner-top' ).addClass( 'ui-corner-left' );");
           out.println("$('#datepicker').datepicker();");
        out.println("});");

        
        out.println("$('#tabs').ready(function(){");
            out.println("$('#vehicle').tablesorter();");
            out.println("$('#business').tablesorter();");
        out.println("});");


        out.println("$(function(){");
            out.println("$('#dialog').dialog({");
                out.println("autoOpen: false,");
                out.println("resizable: false,");
                out.println("draggable: false,");
                out.println("height: 400,");
                out.println("width: 800,");
                out.println("title: 'Anuncio'");
            out.println("});");

            out.println("$('#bRow1').click(function(){");
                 out.println("$('#dialog').dialog('open');");
                 out.println("return false;");
            out.println("});");

            out.println("$('#closeButton').click(function(){");
                 out.println("$('#dialog').dialog('close');");
                 out.println("return false;");
            out.println("});");
        out.println("});");



    out.println("</script>");

    out.println("<div id='bodycontent' style='margin-top: 10px;'>");
        out.println("<div id='tabs' style='width: 90%; height: 300px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;' >");
            out.println("<ul>");
                out.println("<li><a href='#tabs-1'>Vehicle ADs Validator</a></li>");
                out.println("<li><a href='#tabs-2'>Business ADs Validator</a></li>");
                out.println("<li><a href='#tabs-3'>System Statistics</a></li>");
            out.println("</ul>");
            out.println("<div id='tabs-1' style='-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:240px; margin-bottom: 20px;'>");
                out.println("<form id='vehiclesForm' action='ValidateVehicle' method='post'>");
                out.println("<div id='tableContainer' style='float: left;' class='tableWrapper'>");
                out.println("<table id='vehicle' style='float:left;' class='tablesorter'>");
                    out.println("<thead style='display: block;'>");
                        out.println("<tr><th style='width:199px;'>Date</th><th style='width:350px'>Advertiser</th><th style='width:130px;'>Offer</th><th style='width:50px;'>Payed</th><th style='width:70px;'>See AD</th><th style='width:100px;'>Validate AD</th></tr>");
                    out.println("</thead>");
                    out.println("<tbody style='overflow: auto; display: block; height: 150px;'>");
                    int index = 0;
                    for(Vehicleadvert ad : notValidated){
                        if(index == 0){
                            out.println("<tr><td style='width:199px;'>"+ad.getPublicationDate()+"</td><td style='width:358px'>"+ad.getClientID().getNam()+"</td><td style='width:130px;'>"+ad.getOffer()+"</td><td style='width:55px;'><input type='checkbox' ");
                            if(ad.getState().equalsIgnoreCase("payed")){
                                out.println("checked = 'checked' ");
                            }
                            out.println("disabled ></td><td style='width:60px;'><input type='submit' id='seeAd"+index+" name='seeAd"+index+"' value='See AD'></input></td><td style='width:80px;'><input type='hidden' name='id"+index+"' value='"+ad.getCode()+"'><input type='checkbox' name='vRow"+index+"'></td></tr>");
                        }else{
                            out.println("<tr><td>"+ad.getPublicationDate()+"</td><td>"+ad.getClientID().getNam()+"</td><td>"+ad.getOffer()+"</td><td><input type='checkbox' ");
                            if(ad.getState().equalsIgnoreCase("payed")){
                                out.println("checked = 'checked' ");
                            }
                            out.println("disabled ></td><td><input type='submit' id='seeAd"+index+" name='seeAd"+index+"' value='See AD'></input></td><td><input type='hidden' name='id"+index+"' value='"+ad.getCode()+"'><input type='checkbox' name='vRow"+index+"'></td></tr>");                                
                        }
                        index++;
                    }

                    out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
                out.println("<div id='validateSubmit2' style='float: left; width: 100%; margin-top: 5px;'>");
                    out.println("<input type='submit' value='Validate' style='margin-left: auto; margin-right: auto; display:block;'>");
                 out.println("</div>");
                out.println("</form>");
            out.println("</div>");
            out.println("<div id='tabs-2' style='-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:230px; margin-bottom: 20px;'>");

                out.println("<form id='businessForm' action='ValidateBusiness' method='post'>");
                out.println("<div id='tableContainer' style='float: left;' class='tableWrapper'>");
                out.println("<table id='business' style='float: left;' class='tablesorter'>");
                    out.println("<thead style='display: block;'>");
                        out.println("<tr><th style='width:199px;'>Date</th><th style='width:350px'>Advertiser</th><th style='width:160px;'>Sector</th><th style='width:50px;'>Payed</th><th style='width:100px;'>Validate AD</th></tr>");
                    out.println("</thead>");
                    out.println("<tbody style='overflow: auto; display: block; height: 150px;'>");
                        index = 0;
                        for(Businessadvert ad : notValidatedBus){
                            if(index == 0){
                                out.println("<tr><td style='width:199px;'>Date</td><td style='width:358px'>"+ad.getBusiness()+"</td><td style='width:160px;'>"+ad.getSector()+"</td><td style='width:55px;'><input type='checkbox' ");
                                if(ad.getState().equalsIgnoreCase("payed")){
                                    out.println("checked = 'checked' ");
                                }
                                out.println("disabled ></td><td style='width:80px;'><input type='hidden' name='id"+index+"' value='"+ad.getCode()+"'><input type='checkbox' name='vRow"+index+"'></td></tr>");
                            }else{
                                out.println("<tr><td>Date</td><td>"+ad.getBusiness()+"</td><td>"+ad.getSector()+"</td><td><input type='checkbox' ");
                                if(ad.getState().equalsIgnoreCase("payed")){
                                    out.println("checked = 'checked' ");
                                }
                                out.println("disabled ></td><td><input type='hidden' name='id"+index+"' value='"+ad.getCode()+"'><input type='checkbox' name='vRow"+index+"'></td></tr>");
                            }
                            index++;
                        }
                    out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
                 out.println("<div id='validateSubmit2' style='float: left; width: 100%; margin-top: 5px;'>");
                    out.println("<input type='submit' value='Validate' style='margin-left: auto; margin-right: auto; display:block;'>");
                 out.println("</div>");
                out.println("</form>");
            out.println("</div>");
            
            out.println("<div id='tabs-3' style='-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:240px; margin-bottom: 20px;'>");
                
                out.println("<div id='container' style='float: left;'>");
                out.println("<h2>Statistics</h2>");
                out.println("Total vehicle ads posted: "+ stats[0]);
                out.println("<br>Total business ads posted: " + stats[1]);
                out.println("<br>Total income from vehicle ads: " + stats[2]);
                out.println("<br>Total income from business ads: " + stats[3]);
                out.println("<br>Total income: " + (stats[2] + stats[3]));
                out.println("</div>");
            out.println("</div>");

        out.println("</div>");
        out.println("<div id='extraManagement' style='font-size:12px; width:90%; height: 200px; background-color: white; margin:auto; border: 2px solid grey; padding: 3px; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;'>");
            out.println("<ul>");
                out.println("<li><a href='#viewOffers'>Existing Offers</a></li>");
                out.println("<li><a href='#newOffer'>Create Offer</a></li>");
                out.println("<li><a href='#viewAdmins'>Existing Admins</a></li>");
                out.println("<li><a href='#newAdmin'>Create Admin</a></li>");
            out.println("</ul>");
            out.println("<div id='viewOffers' style='float: left; width: 75%; height: 70%; margin: 15px; margin-left: 40px; border: 2px solid grey; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;'>");
                out.println("<div id='tableContainer' style='float: left;' >");
                    out.println("<table id='offers' style='float: left;' class='tablesorter'>");
                        out.println("<thead style='display: block;'>");
                            out.println("<tr><th style='width:199px;'>Name</th><th style='width:280px'>Type</th><th style='width:115px;'>Fee</th><th style='width:50px;'>Months</th><th style='width:80px;'>Expires</th><th style='width:80px;'>Delete</th></tr>");
                        out.println("</thead>");
                        out.println("<tbody style=' height: 100px; overflow: auto; display: block;'>");
                            // Insert Offers from database query
                            index = 0;
                            for(Offer of: offers){
                                if(index==0){
                                    out.println("<tr><td style='width:180px;'>"+of.getNam()+"</td><td style='width:260px'>"+of.getTyp()+"</td><td style='width:115px;'>"+of.getFee()+"</td><td style='width:60px;'>"+of.getMonths()+"<td style='width:80px;'>"+of.getEndDate()+"</td><td style='width:70px'><form id='del_"+index+" name='del_"+index+" action='DeleteOffer' method='post'><input type='hidden' id='offerID' name='offerID' value="+of.getNam() +"><input type='submit' value='Delete'></form></td></td> </tr>");
                                }else{
                                    out.println("<tr><td>"+of.getNam()+"</td><td>"+of.getTyp()+"</td><td>"+of.getFee()+"</td><td>"+of.getMonths()+"<td>"+of.getEndDate()+"</td><td><form id='del_"+index+" name='del_"+index+"' action='DeleteOffer' method='post'><input type='hidden' id='offerID' name='offerID' value="+of.getNam() +"><input type='submit' value='Delete'><input type='submit' value='Delete'></form></td></td> </tr>");
                                }
                            }
                            
                        out.println("</tbody>");
                    out.println("</table>");
                out.println("</div>");
            out.println("</div>");
            out.println("<div id='newOffer' style='float: left; width: 75%; height: 70%; margin: 15px; margin-left: 40px; border: 2px solid grey; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;'>");
                out.println("<form method='post' action='CreateOffer'>");
                    out.println("<div style='float: left; width: 100%; height: 80px' class='tableWrapper'>");
                        out.println("<div id='offerDetails' style='float:left; width:50%;'>");
                            out.println("<label>Type:</label>");
                            out.println("<input type='radio' name='offerType' value='vehicle' > Vehicle Ad");
                            out.println("<input type='radio' name='offerType' value='business'> Business Ad <br>");
                            out.println("<label>Offer Name:</label> <input type='text' name='name'><br>");
                            out.println("<label>End date:</label> <input type='text' id='datepicker' name='enddate'>");
                        out.println("</div>");
                        out.println("<div id='offerDetails2' style='float:left; width:50%;'>");
                            out.println("<label>Fee (&euro;):</label> <input type='text' name='fee'><br>");
                            out.println("<label>Months:</label> <input type='text' name='months'><br>");
                        out.println("</div>");
                    out.println("</div>");
                    out.println("<div id='offerSubmit' style='float: left; width: 100%; margin-top: 5px;'>");
                        out.println("<input type='submit' value='Create Offer' style='margin-left: auto; margin-right: auto; display:block;'>");
                    out.println("</div>");
                out.println("</form>");
            out.println("</div>");
            out.println("<div id='viewAdmins' style='float: left; width: 75%; height: 70%; margin: 15px; margin-left: 40px; border: 2px solid grey; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;'>");
                out.println("<div id='tableContainer' style='float: left; margin-left: 240px;' >");
                    out.println("<table id='admins' style='float: left;' class='tablesorter'>");
                        out.println("<thead style='display: block;'>");
                            out.println("<tr><th style='width:199px;'>Admin</th><th style='width:100px'>Delete</th></tr>");
                        out.println("</thead>");
                        out.println("<tbody style=' height: 100px; overflow: auto; display: block;'>");
                            // Insert admin from database query
                            index = 0;
                            for(Administrato admin: admins){
                                if(index==0){
                                   out.println("<tr><td style='width:199px;'>"+admin.getUsername()+"</td><td style='width:100px'><form id='del_"+index+" name='del_"+index+"' action='DeleteAdmin' method='post'><input type='hidden' id='adminID' name='adminID' value="+admin.getAdminID()+"><input type='submit' value='Delete'></form></td></tr>");
                                }else{
                                    out.println("<tr><td>"+admin.getUsername()+"</td><td><form id='del_"+index+" name='del_"+index+"' action='DeleteAdmin' method='post'><input type='hidden' id='adminID' name='adminID' value="+admin.getAdminID()+"><input type='submit' value='Delete'></form></td></tr>");
                                }
                            }
                            
                        out.println("</tbody>");
                    out.println("</table>");
                out.println("</div>");
            out.println("</div>");
            out.println("<div id='newAdmin' style='float: left; width: 75%; height: 70%; margin: 15px; margin-left: 40px; border: 2px solid grey; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;'>");
                    out.println("<form action='CreateAdmin' method='post'>");
                        out.println("<div id='leftPanel' style='float: left; width: 50%; padding: 0px;'>");
                            out.println("<label for='id'>ID</label>");
                            out.println("<input id='id' name='id' class='required' minlength='4' maxlength='10' type='text'><br>"
                                    + "<label for=\"email\">Email</label>\n <input id=\"email\" name=\"email\" class=\"required\" minlength=\"4\" maxlength=\"50\" type=\"email\"> <br>");
                            out.println("<label for='password'>Password</label>");
                            out.println("<input name='password' id='password' type='password' class='required' minlength='4' maxlength='50'><br>");
                            out.println("<label for='confirmpassword'>Confirm Password</label>");
                            out.println("<input name='confirmpassword' type='password' class='required' equalTo='#password' id='confirmpassword'>");
                        out.println("</div>");
                        out.println("<div id='rightPanel' style='float: left; width: 50%;'>");
                            out.println("<label for='terms'><a href='/legal.jsp' target='_blank'>Terms and conditions</a></label>");
                            out.println("<input id='terms' name='terms' class='required' type='checkbox'>");
                            out.println("<div class='password-meter' style='margin-top:20px;'>");
                                out.println("<div class='password-meter-message'> </div>");
                                out.println("<div class='password-meter-bg'>");
                                       out.println("<div class='password-meter-bar'></div>");
                                out.println("</div>");
                            out.println("</div>");
                        out.println("</div>");
			out.println("<div id='submitPanel' style='width:100%; float: left; margin-top: 10px;'>");
                            out.println("<input type='submit' value='Register New Admin' style='margin-left: auto; margin-right: auto; display:block;'>");
                        out.println("</div>");
                    out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            request.getRequestDispatcher("/footer.jsp").include(request, response);
        }finally {            
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
