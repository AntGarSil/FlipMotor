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
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
public class ReceiptHelper extends HttpServlet {

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
          
             String fee = request.getParameter("fee");
            HttpSession session = request.getSession(true);
                //Log in will expire every 20 minutes
                session.setMaxInactiveInterval(20 * 60);
                //Store user credential
                int f=Integer.valueOf(fee);
                session.setAttribute("fee", f);
                        
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
            
            out.println("                          <li><a href='#receipt'>Receipt</a></li> ");
            out.println("                      </ul> ");
            out.println("            <div id='receipt'style='-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:420px; margin-bottom: 20px;'>");
            out.println("                <div id='vehicleContainer' style='overflow: auto; height: 100%;' class='tableWrapper'>");
            out.println("                   <form id='receipt' method='POST' action='DetailsAction'>");
            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      RECEIPT HERE                              //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            if(fee.equalsIgnoreCase("15"))
            {
                 out.println("                               <div>Cost: 15€ </div> ");
                 out.println("                               <div>Duration: 1 month </div> ");
            }else if(fee.equalsIgnoreCase("20")){
                out.println("                               <div>Cost: 20€ </div> ");
                 out.println("                               <div>Duration: 2 months </div> ");
            }
            else if(fee.equalsIgnoreCase("25")){
                out.println("                               <div>Cost: 25€ </div> ");
                 out.println("                               <div>Duration: 3 months </div> ");
            }
            out.println("<p> <label for='offer'>Offer Code</label>");   
	out.println("<input id='offer' name='offer' class='required' minlength='1' maxlength='10' type='number' /></p>");	
	out.println("<div id='submitPanel' style='float: left; width: 100%; margin-top: 5px;'>");			
	out.println("<input type='submit' value='Confirm' style='margin-left: auto; margin-right: auto; display:block;'>");
			
		out.println("                </div> ");
            out.println("                </form> ");
            out.println("             </div> ");
            out.println("         </div> ");
            out.println("     </div> ");
            out.println("   </div> ");
            out.println("</div> ");	
            
                
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
