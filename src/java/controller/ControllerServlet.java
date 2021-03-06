/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antón García Dosil
 */
@WebServlet(name = "ControllerServlet",
            loadOnStartup = 1,
            urlPatterns = {"/Home",
                           "/Cars",
                           "/General",
                           "/Motorbikes",
                           "/UserProfile",
                           "/Register",
                           "/RegisterAction",
                           "/TermsAndConditions",
                           "/About",
                           "/AdminPage",
                           "/PostAd",
                           "/EditProfile",
                           "/UserProfile",
                           "/RegisterError",
                           "/ViewAdController",
                           "/ReceiptAction",
                           "/DetailsAction",
                           "/PaymentAction",
                           "/MakeFavourite",
                           "/Login",
                           "/DeleteMessage",
                           "/SendMessage",
                           "/LoginController"
                           })
public class ControllerServlet extends HttpServlet {

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

        String userPath = request.getServletPath();

        /**
         * SAMPLE CODE
         */
        // if category page is requested
        if (userPath.equals("/Advert")) {            
            userPath = "/ViewAdController";

        // if cart page is requested
        } else if (userPath.equals("/toMotorQuery")) {
            // TODO: Implement motorbike page request
            

        // if checkout page is requested
        }else if (userPath.equals("/AdvancedSearch")) {
            // TODO: Implement motorbike page request
            userPath = "/QueryController";
	}else{
            userPath = "/notFound.jsp";
        }

        // use RequestDispatcher to forward request internally
        String url = userPath;

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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

        String userPath = request.getServletPath();
        if(userPath.equals("/Home")){
            userPath = "/index.jsp";
        }
        // if toVehicleQuery action is called
        else if(userPath.equals("/Cars")) {
            // TODO: Implement toVehicleQuery action
            userPath = "/QueryController?opt=Cars";
        }else if (userPath.equals("/Motorbikes")) {
            // TODO: Implement motorbike page request
            
             userPath = "/QueryController?opt=Motorbikes";
        // if checkout page is requested
        } else if (userPath.equals("/General")) {

                // TODO: Implement general page request                
                
                userPath = "/QueryController?opt=General";
            // if checkout page is requested

        } else if (userPath.equals("/UserProfile")) {
            // TODO: Implement motorbike page request
            userPath = "/UserProfileController";

             //userPath = "/query";
        // if checkout page is requested
        } else if (userPath.equals("/DetailsAction")) {
            // TODO: Implement motorbike page request
            userPath = "/details.jsp";

             //userPath = "/query";
        // if checkout page is requested
        } else if (userPath.equals("/Register")) {
            // TODO: Implement motorbike page request
            userPath = "/registration.jsp";

             //userPath = "/query";
        // if checkout page is requested
        }
        else if (userPath.equals("/About")) {
            // TODO: Implement motorbike page request
            userPath = "/aboutus.jsp";

             //userPath = "/query";
        // if checkout page is requested
        }else if (userPath.equals("/TermsAndConditions")) {
            // TODO: Implement motorbike page request
            userPath = "/termsandconditions.jsp";

             //userPath = "/query";
        // if checkout page is requested
        }else if (userPath.equals("/PostAd")) {
            // TODO: Implement motorbike page request
            userPath = "/postAd.jsp";
		
	}else if (userPath.equals("/EditProfile")) {
            // TODO: Implement motorbike page request
            userPath = "/EditProfileController";
            
	}else if (userPath.equals("/RegisterAction")) {
            // TODO: Implement motorbike page request
            userPath = "/RegistrationController";
            
	}else if (userPath.equals("/ReceiptAction")) {
            // TODO: Implement motorbike page request
            userPath = "/ReceiptHelper";
            
	}else if (userPath.equals("/RegisterError")) {
            // TODO: Implement motorbike page request
            userPath = "/RegisterError.jsp";
	}else if (userPath.equals("/MakeFavourite")) {
            // TODO: Implement motorbike page request
            userPath = "/ToggleFavouriteController";
	}else if (userPath.equals("/Advert")) {
            // TODO: Implement motorbike page request
            userPath = "/ViewAdController";
	}else if (userPath.equals("/Favorites")) {
            // TODO: Implement motorbike page request
            userPath = "/FavouriteViewController";
	}else if (userPath.equals("/PaymentAction")) {
            // TODO: Implement motorbike page request
            userPath = "/PaymentController";
	}else if (userPath.equals("/SendMessage")) {
            // TODO: Implement motorbike page request
            userPath = "/MessageSenderController";
	}else if (userPath.equals("/DeleteMessage")) {
            // TODO: Implement motorbike page request
            userPath = "/MessageDeleteController";
	}else if (userPath.equals("/Login")) {
            // TODO: Implement motorbike page request
            userPath = "/LoginController";
	}else if (userPath.equals("/CreateAdmin")) {
            // TODO: Implement motorbike page request
            userPath = "/CreateAdminController";
	}else if (userPath.equals("/DeleteAdmin")) {
            // TODO: Implement motorbike page request
            userPath = "/DeleteAdminController";
	}else if (userPath.equals("/CreateOffer")) {
            // TODO: Implement motorbike page request
            userPath = "/CreateOfferController";
	}else if (userPath.equals("/DeleteOffer")) {
            // TODO: Implement motorbike page request
            userPath = "/DeleteOfferController";
	}else if (userPath.equals("/AdminLogIn")) {
            // TODO: Implement motorbike page request
            userPath = "/AdminAccessController";
	}else if (userPath.equals("/AdminPage")) {
            // TODO: Implement motorbike page request
            userPath = "/AdminController";
	}else if (userPath.equals("/AdvancedSearch")) {
            // TODO: Implement motorbike page request
            userPath = "/QueryController";
	}else if (userPath.equals("/ValidateVehicle")) {
            // TODO: Implement motorbike page request
            userPath = "/ValidateVehicleController";
	}else if (userPath.equals("/ValidateBusiness")) {
            // TODO: Implement motorbike page request
            userPath = "/ValidateBusinessController";
	}


        // use RequestDispatcher to forward request internally
        String url = userPath;

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}