package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Datastore.UserEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Antón García Dosil
 */
public class UserProfileController extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            /*
             * Output user profile for logged in user
             */
            
            
            ////////////////////// This section shall be replaced with a database query ///////////////////
            //(String UserName, String UserPassword, String UserID, String CreditCard, String NIF, int Phone, int AddressNo, int AddressPC, int AddressFlat, String AddressLetter, String Password)            
            UserEntity user1 = new UserEntity("juanito","juanitoh","12345678","1244141","777777777W",655554,4,3444,4,"C","juanitoputoteh@hotmail.com");            
            UserEntity user2 = new UserEntity("asdf","asdf","111111111","1244141","777777777W",655554,4,3444,4,"C","asdf@asdf.asdf");            
            List<UserEntity> userList  = new ArrayList<UserEntity>();            
            userList.add(user1);
            userList.add(user2);
            ////////////////////////////////////////////////////////////////////////////////////////////////
            
            UserEntity result = new UserEntity();
            HttpSession session = request.getSession(true);
            String uid = "";
            if(null != session.getAttribute("userid")){
                uid = (String) session.getAttribute("userid");    
            } else{
                out.println("Session Expired");
                throw new Exception ("Something funky going on with your session");
            }
                        
            
            for(int i = 0; i < userList.size(); i++){
                if(uid.equalsIgnoreCase(userList.get(i).getUserID()))
                {
                    result.setUserName(userList.get(i).getUserName());
                    result.setPhone(userList.get(i).getPhone());
                    result.setNIF(userList.get(i).getNIF());
                    result.setCreditCard(userList.get(i).getCreditCard());
                    result.setAddressPC(userList.get(i).getAddressPC());
                    result.setAddressFlat(userList.get(i).getAddressFlat());
                    result.setAddressLetter(userList.get(i).getAddressLetter());
                    result.setAddressNo(userList.get(i).getAddressNo());
                    result.setEmail(userList.get(i).getEmail());
                    break;
                }
            }
            
            if(null == result.getNIF()){
                throw new Exception ("Something funky going on with your session");
            }
            
            response.setContentType("text/html");
            request.getRequestDispatcher("/header.jsp").include(request, response); 
            
            out.println(" <div id='bodycontent' style='margin-top: 10px;'>");
            out.println("      <div id='tabs' class='tabs'>");
            out.println("           <ul>");
            out.println("               <li><a href='#tabs-1'>Profile</a></li>");
            out.println("               <li><a href='#tabs-2'>Advertisements</a></li>");
            out.println("           </ul>");
            
            //User Info
            out.println(" <div id='tabs-1' class='tabs-1'>");
            
            out.println("          <p>");
            out.println("              <label class='loginBodyText' for='nif'>NIF: ");
            out.println(result.getNIF() + "</label>");
            out.println("          </p>");
            out.println("          <p>");
            out.println("               <label class='loginBodyText' for='phone'>Phone: ");
            out.println(result.getPhone() + "</label>");
            out.println("          </p>");
            out.println("          <p>");
            out.println("                <label class='loginBodyText' for='address_number'>Address: ");
            out.println("El Carrascal " + result.getAddressNo() + " " + result.getAddressFlat() + "-" + result.getAddressLetter() + " Leganés (Madrid Spain) PC: " + result.getAddressPC() +  "</label>");
            out.println("          </p>");
            out.println("            <p>");
            out.println("                  <label class='loginBodyText' for='card'>Credit Card: ");
            out.println(result.getCreditCard() + "</label>");
            out.println("             </p>");
            out.println("             <p>");
            out.println("                    <label class='loginBodyText' for='email'>Email address: ");
            out.println(result.getEmail() + "</label>");
            out.println("              </p>");

            //Insert link to editing information here
            out.println("       </div>");
            
            out.println(" <div id='tabs-2' class='tabs-1'>");
            out.println("    <div id='tableContainer' class='tableWrapper'> ");
            out.println("        <table id='results' style='margin: auto; margin: auto;' class='tablesorter'> ");

            out.println("            <thead style='display: block;'> ");
            out.println("                <tr><th style='width:200px;'>Date</th><th style='width:60px;'>Photo</th><th style='width:200px;'>Brand and Model</th><th style='width:200px;'>State</th><th style='width:50px;'>Year</th><th style=width:100px;'>Price</th><th style='width:80px;'>Visit AD</th></tr> ");
            out.println("            </thead> ");
            out.println("            <tbody style='overflow: auto; display: block; height: 390px;'> ");
            //Link Popup to each tr element to edit
            out.println("                <tr id='row1'><td style='width:199px;'>Date</td><td style='width:62px;'>Photo</td><td style='width:200px;'>Brand and Model</td><td style='width:201px;'>State</td><td style='width:52px;'>Year</td><td style='width:102px;'>Price</td><td style='width:66px;'>Visit AD</td></tr> ");
            out.println("                <tr id='row2'><td>16/10/2012 at 16:00</td><td><img src='images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg' alt='Photo' style='height:50px; margin-left: auto; margin-right: auto;'></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><div class='arrow'></div></td></tr> ");
            out.println("                <tr><td>16/10/2012 at 16:00</td><td><img src='images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg' alt='Photo' style='height:40px;'></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td ><div class='arrow'></div></td></tr> ");
            out.println("                <tr><td>16/10/2012 at 16:00</td><td><img src='images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg' alt='Photo' style='height:40px;'></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><div class='arrow'></div></td></tr> ");
                            
            out.println("            </tbody> ");
            out.println("        </table> ");
            out.println("        </div> ");

            //Insert link to editing information here
            out.println("       </div>");
            
            out.println("   </div>");
            out.println("</div>");
            
            
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
