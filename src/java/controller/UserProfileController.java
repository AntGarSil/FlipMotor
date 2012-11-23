package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
import model.RegisteredclientJpaController;


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
            
            
                        
            HttpSession session = request.getSession(true);
            String uid = "";
            if(null != session.getAttribute("userid")){
                uid = (String) session.getAttribute("userid");    
            } else{
                out.println("Session Expired");
                throw new Exception ("Something funky going on with your session");
            }
                        
            RegisteredclientJpaController userJPA = new RegisteredclientJpaController();
            userJPA.findRegisteredclient(1234);
            
            /**
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
             * */
             
            
            
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
            out.println("                 <div id='tabs' class='tabs'  style='width: 90%; height: 500px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px; ");
            out.println("                     -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;' > ");
            out.println("                      <ul> ");
            out.println("                          <li><a href='#tabs-1'>Profile</a></li> ");
            out.println("                          <li><a href='#tabs-2'>Advertisements</a></li> ");
            out.println("                      </ul> ");
            out.println("            <div id='tabs-1' class='tabs-1'> ");
            out.println("                    <div id='leftProfilePanel' style='float:left; width: 50%;'> ");
            out.println("                        <div style='float:left; width: 100%; height: 390px; margin: 0px 10px 10px;'> ");
            out.println("                               <h4>Profile</h4> ");

            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD NAME HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                               <label for='name'>Name: " +  "</label> ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD SURNAME HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                               <label for='surname'>Surname: </label> ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD NIF HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////             
            out.println("                               <label for='nif'>NIF: " + "</label> ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD PHONE HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                               <label for='phone'>Phone: " + "</label> ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD EMAIL HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////             
            out.println("                                <label for='email'>Email address: " + "</label> ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD CREDITCARD HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                                <label for='card'>Credit card: </label> ");


            out.println("                                <h4>Address</h4> ");

            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD STREET HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                                Street: ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD NUMBER HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                                Number: ");

            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD FLAT HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                                Flat: ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD LETTER HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                                Letter: ");

            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD PC HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                                PC: ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD CITY HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                                City: ");


            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD PROVINCE HERE                               //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                               Province: ");


            out.println("                        </div> ");

            out.println("                         <div id='submitProfile' style='float: left; width: 100%; margin-top: 5px;'> ");
            out.println("                            <input type='button' id='editProfileButton' value='Edit Profile' style='margin-left: auto; margin-right: auto; display:block;'> ");
            out.println("                         </div> ");
            out.println("                    </div> ");
            out.println("                    <div id='rightProfilePanel' style='float:left; width: 49%; display: none; border-left: 1px gray solid;'> ");

            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      IMPLEMENT EDIT PROFILE                      //////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                        <form id='editedProfile' method='POST' action='EditProfile'> ");
            out.println("                            <div style='float:left; width: 100%; height: 390px; margin: 0px 10px 10px;'> ");
            out.println("                                <h4>Edit your Profile here:</h4> ");
            out.println("				<label for='name'>Name</label> ");
            out.println("				<input id='name' name='name' class='required' minlength='1' maxlength='30' type='text' /> ");


            out.println("                                <label for='surname'>Surname</label> ");
            out.println("                                <input id='surname' name='surname' class='required' minlength='1' maxlength='30' type='text' /><br> ");


            out.println("                                <label for='nif'>NIF</label> ");
            out.println("                                <input id='nif' name='nif' class='required' minlength='8' maxlength='9' type='password' /> ");



            out.println("                                <label for='phone'>Phone</label> ");
            out.println("                                <input id='phone' name='phone' class='required' minlength='9' maxlength='13' type='number' /><br> ");


            out.println("                                <label for='email'>Email address</label> ");
            out.println("                                <input id='email' name='email' class='required email' type='text'  style='width:200px'/><br> ");


            out.println("                                <label for='card'>Credit card</label> ");
            out.println("                                <input id='card' name='card' class='required' minlength='20' maxlength='20' type='number'  style='width:200px'/><br> ");


            out.println("				<h4>Address</h4> ");


            out.println("                                Street:  ");
            out.println("                                <input id='street' name='street' class='required' minlength='1' maxlength='30' type='text' /> ");


            out.println("                                Number: ");
            out.println("                                <input id='number' name='number' class='required' minlength='1' maxlength='5' type='number' style='width:20px; margin-right: 20px;'/> ");


            out.println("                                Flat: ");
            out.println("                                <input id='flat' name='flat' class='required' minlength='1' maxlength='2' type='number'  style='width:20px; margin-right: 20px;'/> ");


            out.println("                                Letter: ");
            out.println("                                <input id='leter' name='leter' class='required' minlength='1' maxlength='2' type='text'  style='width:20px; margin-right: 20px;'/><br> ");


            out.println("                                PC:  ");
            out.println("                                <input id='pc' name='pc' class='required' minlength='3' maxlength='7' type='number'  style='width:40px; margin-right: 20px;'/> ");


            out.println("                                City: ");
            out.println("                                <input id='city' name='city' class='required' minlength='1' maxlength='30' type='text' style='margin-right: 20px;' /> ");


            out.println("                                Province:  ");
            out.println("                                <input id='province' name='province' class='required' minlength='1' maxlength='30' type='text' style='margin-right: 20px;'/> ");

            out.println("                                <h4>New password</h4> ");
            out.println("                                <label for='password'>Password</label> ");
            out.println("                                <input name='password' id='password' type='password' class='required' minlength='4' maxlength='50' /> ");

            out.println("                                <div class='password-meter'> ");
            out.println("                                        <div class='password-meter-message'> </div> ");
            out.println("                                        <div class='password-meter-bg'> ");
            out.println("                                                <div class='password-meter-bar'></div> ");
            out.println("                                        </div> ");
            out.println("                                </div> ");
            out.println("                                    <label for='confirmpassword'>Confirm Password</label> ");
            out.println("                                    <input name='confirmpassword' type='password' class='required' equalTo='#password' id='confirmpassword' /> ");
            out.println("                           </div> ");
            out.println("                           <div id='submitProfile' style='float: left; width: 100%; margin-top: 5px;'> ");
            out.println("                                <input type='submit' id='saveProfileChanges' value='Save Changes' style='margin-left: auto; margin-right: auto; display:block;'> ");
            out.println("                           </div> ");
            out.println("                        </form> ");
            out.println("                    </div> ");
            out.println("            </div> ");

            out.println("            <div id='tabs-2' class='tabs-1'> ");
            out.println("                <div id='tableContainer' style='float: left;' class='tableWrapper'> ");
            out.println("                <table id='postedAds' style='float:left;' class='tablesorter'> ");
            out.println("                    <thead style='display: block;'> ");
            out.println("                           <tr><th style='width:300px;'>Date</th><th style='width:280px;'>Brand and Model</th><th style='width:200px;'>Vehicle</th><th style='width:80px;'>Delete Ad</th><th style='width:80px;'>Edit Ad</th></tr> ");
            out.println("                    </thead> ");
            out.println("                    <tbody style='overflow: auto; display: block; height: 400px;'> ");
            out.println("                        <tr><td style='width:305px;'>20/10/12</td><td style='width:200px'>BMW</td><td style='width:200px;'>Motorbike</td><td style='width:80px;'><input type='button' value='Delete Ad'></td><td style='width:70px;'><input type='button' value='Edit Ad'></tr> ");

            //////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////                      ADD ADVERTISEMENTS                          //////////////
            //////////  LOOP FILLING IN SAMPLE <TR> BELOW
            //////////////////////////////////////////////////////////////////////////////////////////////////
            out.println("                        <tr><td>20/10/12</td><td style='width:280px'>BMW</td><td>Motorbike</td><td><input type='button' value='Delete Ad'></td><td><input type='button' value='Edit Ad'></tr> ");
            //////////////////////////////////////////////////////////////////////////////////////////////////

            out.println("                    </tbody> ");
            out.println("                </table> ");
            out.println("                </div> ");
            out.println("             </div> ");
            out.println("         </div> ");
            out.println("     </div> ");

            out.println("</div> ");
            
            
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
