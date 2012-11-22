/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

            String userReq = request.getParameter("opt");
            
            request.getRequestDispatcher("/header.jsp").include(request, response); 

            

            
            out.println("    <script>  ");
            out.println("        $('#tabs').ready(function(){ ");
            out.println("            $('#results').tablesorter(); ");
            out.println("        }); ");


            out.println("        $(function(){ ");
            out.println("            $('#dialog').dialog({ ");
            out.println("                autoOpen: false, ");
            out.println("                resizable: false, ");
            out.println("                draggable: false, ");
            out.println("                height: 400, ");
            out.println("                width: 800, ");
            out.println("                title: 'Anuncio' ");
            out.println("            }); ");

            out.println("            $('#visitAd1').click(function(){ ");
            out.println("                 $('#dialog').dialog('open'); ");
            out.println("                 return false; ");
            out.println("            }); ");

            out.println("            $('#closeButton').click(function(){ ");
            out.println("                 $('#dialog').dialog('close'); ");
            out.println("                 return false; ");
            out.println("            }); ");
            out.println("        }); ");

            out.println("        $('#tabs').ready(function() { ");
            out.println("                $( '#tabs' ).tabs(); ");
            out.println("        }); ");


            out.println("    </script> ");


            //////////////////////////////////////////////////////////////////////////////////////
                        //////////// UPDATE POPUP INFO ON CLICK /////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////
            out.println("        <div id='dialog' style='font-size: 14px;'> ");
            out.println("            <div style='float:left; width: 240px; height:100%'> ");
            out.println("                <div id='adPhoto' style='width: 100%; height: 70%; background-color: red;'> ");
            out.println("                    Photo ");
            out.println("                    <img src='' alt='Photo'> ");
            out.println("                </div> ");
            out.println("                <div id='contactInfo' style='width: 100%; height: auto; margin-top: 10px;'> ");
            out.println("                    Contact <br> ");
            out.println("                    Name: Perico <br> ");
            out.println("                    E-mail: cuchuflete@oleole.com <br> ");
            out.println("                    Phone: 123456789 ");
            out.println("                </div> ");
            out.println("            </div> ");

            out.println("            <div id='adDescription' style='float:left; width: 500px; height:100%; margin-left: 20px;'> ");
            out.println("                <h3>Details</h3> ");
            out.println("                <div style='height: 60px;'> ");
            out.println("                    <div style='float:left; width: 50%;'> ");
            out.println("                    Type: <br> ");
            out.println("                    Brand:<br> ");
            out.println("                    Model:<br> ");
            out.println("                    Color:<br> ");
            out.println("                </div> ");
            out.println("                <div style='float:left; width: 50%;'> ");
            out.println("                    Year:<br> ");
            out.println("                    Km: <br> ");
            out.println("                    Price: <br> ");
            out.println("                    Ad date: <br> ");
            out.println("                </div> ");

            out.println("                </div> ");

            out.println("                <div style='width:100%; height: 150px; margin-top:25px;'> ");
            out.println("                    <h4>Description</h4> ");
            out.println("                    Descripcion y más detalles del vehículo ");
            out.println("                </div> ");
            out.println("                <div id='footBar' style='width:100%; height:auto; background-color: white;'> ");
            out.println("                    <button id='closeButton' style='float: right; margin-right: 25px; margin-top: 20px;'>Close</button> ");
            out.println("                </div> ");


            out.println("            </div> ");
            out.println("        </div> ");




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


            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////// ADD REAL VALUES FOR QUERIES ////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(userReq.equalsIgnoreCase("cars"))
            {
                out.println("                        <tr id='row1'><td style='width:199px;'>16/10/2012 at 16:00</td><td style='width:62px;'><img src='images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg' alt='Photo' style='height:50px; margin-left: auto; margin-right: auto;'></td><td style='width:200px;'>BMW 320</td><td style='width:201px;'>Barcelona</td><td style='width:52px;'>2008</td><td style='width:102px;'>4000</td><td style='width:66px;'><input type='button' id='visitAd1' value='Visit AD'></td></tr> ");
            }

            if(userReq.equalsIgnoreCase("motos"))
            {
                out.println("                        <tr id='row2'><td>16/10/2012 at 16:00</td><td><img src='images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg' alt='Photo' style='height:50px; margin-left: auto; margin-right: auto;'></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type='button' id='visitAd2' value='Visit AD'></td></tr> ");
            }

            if(userReq.equalsIgnoreCase("gen"))
            {
                out.println("                        <tr id='row1'><td style='width:199px;'>16/10/2012 at 16:00</td><td style='width:62px;'><img src='images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg' alt='Photo' style='height:50px; margin-left: auto; margin-right: auto;'></td><td style='width:200px;'>BMW 320</td><td style='width:201px;'>Barcelona</td><td style='width:52px;'>2008</td><td style='width:102px;'>4000</td><td style='width:66px;'><input type='button' id='visitAd1' value='Visit AD'></td></tr> ");
                out.println("                        <tr id='row2'><td>16/10/2012 at 16:00</td><td><img src='images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg' alt='Photo' style='height:50px; margin-left: auto; margin-right: auto;'></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type='button' id='visitAd2' value='Visit AD'></td></tr> ");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
