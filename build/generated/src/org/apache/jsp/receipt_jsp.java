package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class receipt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>FlipMotor</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"Stylesheet\" href=\"style/templateStyles.css\" type=\"text/css\" media=screen >\n");
      out.write("        <link rel=\"Stylesheet\" href=\"style/s3slider.css\" type=\"text/css\" media=screen >\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/register.css\"/>\n");
      out.write("        <link rel=\"Stylesheet\" href=\"style/home.css\" type=\"text/css\" media=screen >\n");
      out.write("        <link rel=\"stylesheet\" href=\"style/questionmark.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style/custom-theme2/jquery-ui-1.9.0.custom.css\"  type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"js/jquery.tablesorter/themes/blue/style.css\"  type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/jquery.validate.password.css\"/>\n");
      out.write("        <script src=\"js/jquery-1.8.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"http://code.jquery.com/ui/1.9.0/jquery-ui.js\"></script>\n");
      out.write("        <script src=\"js/jquery.lightbox_me.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/templates.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/s3Slider.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/jquery.tablesorter/jquery.tablesorter.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/sliders.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!--\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style/register_jquery.css\" />\n");
      out.write("        <!--<script src=\"js/DataTables-1.9.4/media/js/jquery.dataTables.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"js/DataTables-1.9.4/media/css/jquery.dataTables.css\" type=\"text/css\">\n");
      out.write("        <script src=\"js/jquery.jqGrid-4.4.1/js/jquery.jqGrid.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/home.js\" type=\"text/javascript\"></script>\n");
      out.write("            $(\"#tabs\").ready(function() {\n");
      out.write("                $( \"#tabs\" ).tabs();\n");
      out.write("            });\n");
      out.write("        </script>-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wheel\" style=\"z-index: 1; float: left; top:0px; left: 0px; position: absolute;\"><img src=\"style/wheel.png\" style=\"height:768px;\"></div>\n");
      out.write("        <div id=\"wrapper\" class=\"wrapper\">\n");
      out.write("            <div id=\"headerContainer\" style=\"width: 100%; height:190px;\">\n");
      out.write("                <img class=\"banner\" src=\"images/EDEPOSITO_840X50_2.jpg\" alt=\"banner\" style=\"height:70px;\">\n");
      out.write("\n");
      out.write("                <div id=\"headerContent\" style=\"width: 100%; height:110px; \">\n");
      out.write("                    <div id=\"logo\" style=\"float:left;width: 40%; height: 100%;\">\n");
      out.write("                        <form action=\"Home\" method=\"POST\">\n");
      out.write("                            <input type=\"submit\" class=\"headerText\" id=\"headerText\" value=\"FlipMotor\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div id=\"navigationBar\" style=\"width: 60%; height: 100%; float:left;\">\n");
      out.write("                        \n");
      out.write("                        ");
      out.write("\n");
      out.write("                        ");
 if(null == session.getAttribute("userid") && null == session.getAttribute("adminid")){ 
      out.write("                        \n");
      out.write("                                <div id=\"buttonBox\" style=\"float: right; margin-top: 20px; margin-right: 50px;\">\n");
      out.write("                                    <div style=\"\"><input id='loginButtonId' type=\"button\" class=\"loginbutton\" value=\"Log in\"></div>\n");
      out.write("                                    <div><form action=\"Register\" method=\"POST\"><input type=\"submit\" id='registerButtonId' class=\"loginbutton\" value=\"Register\"/></form></div>\n");
      out.write("                                </div>\n");
      out.write("                        ");
 } else if(null != session.getAttribute("userid")){ 
      out.write("\n");
      out.write("                        \n");
      out.write("                            <div id=\"buttonBox\" style=\"float: right; margin-top: 20px; margin-right: 0px;\">\n");
      out.write("                                <div><form action=\"UserProfile\" method=\"POST\"><input id='userProfileButtonId' type=\"submit\" class=\"loginbutton\" value=\"Profile\"></form></div>\n");
      out.write("                                <div><form action=\"LogoutController\" method=\"POST\"><input type=\"submit\" id='registerButtonId' class=\"loginbutton\" value=\"Log Out\"/></form></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"postFavBox\" style=\"float: right; margin-top: 20px; margin-right: 10px;\">\n");
      out.write("                                <form action=\"PostAd\" method=\"POST\">\n");
      out.write("                                    <input type=\"submit\" class=\"loginbutton\" value=\"New Ad\">\n");
      out.write("                                </form>\n");
      out.write("                                <form action=\"Favorites\" method=\"POST\">\n");
      out.write("                                    <input type=\"submit\" class=\"loginbutton\" value=\"Favorites\">\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        ");

                             } else if(null!= session.getAttribute("adminid")){
                        
      out.write("\n");
      out.write("                            \n");
      out.write("                            <div id=\"postBox\" style=\"float: right; margin-top: 40px; margin-right: 50px;\">\n");
      out.write("                                <form action=\"AdminLogOut\" method=\"POST\">\n");
      out.write("                                    <input type=\"submit\" class=\"loginbutton\" value=\"Log Out\">\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        ");

                             }
                        
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        \n");
      out.write("                        ");
      out.write("\n");
      out.write("                        ");

                             if(null== session.getAttribute("adminid")){
                        
      out.write("\n");
      out.write("                        <div id=\"w2b-searchbox\" style=\"margin-top:30px; margin-left:80px;\">\n");
      out.write("                        <form id=\"w2b-searchform\" action=\"ControllerServlet\" method=\"get\">\n");
      out.write("                            <input type=\"text\" id=\"s\" name=\"q\" value=\"\"/>\n");
      out.write("                            <input type=\"image\" src=\"http://img1.blogblog.com/img/blank.gif\" id=\"sbutton\" />\n");
      out.write("                            \n");
      out.write("                        </form>\n");
      out.write("                            <input type=\"button\" id=\"advSearchButton\" value=\"Advanced Search\">\n");
      out.write("                        </div>\n");
      out.write("                        ");

                             }
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("        <div id=\"advSearchBox\" style=\"width:750px; height: 120px; border: 2px solid grey; padding: 10px; margin-top: 10px; background-image: url('images/seamlesstexture1_1200.jpg');\n");
      out.write("         -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px; margin:auto; display: none; z-index: 100; position: relative; left: -280px; top: 30px;\">\n");
      out.write("            <form id=\"advSearch\" method=\"get\" action=\"Controller\">\n");
      out.write("            <div id=\"leftAdv\" style=\"float:left; width: 40%;\">\n");
      out.write("                <label for=\"brand\">Brand: </label><input name=\"brand\" type=\"text\"><br>\n");
      out.write("                <label for=\"model\">Model: </label><input name=\"model\" type=\"text\"><br>\n");
      out.write("                <label for=\"vehicle\">Type: </label>\n");
      out.write("                <select id=\"vehicle\" name=\"vehicle\">\n");
      out.write("                        <option value=\"car\">Car</option>\n");
      out.write("                        <option value=\"motorbike\">Motorbike</option>\n");
      out.write("                </select>\n");
      out.write("                <br>\n");
      out.write("                <label for=\"color\">Color: </label>\n");
      out.write("                <select id=\"color\" name=\"color\">\n");
      out.write("                        <option value=\"red\">Red</option>\n");
      out.write("                        <option value=\"red\">Blue</option>\n");
      out.write("                        <option value=\"red\">Green</option>\n");
      out.write("                        <option value=\"red\">Black</option>\n");
      out.write("                        <option value=\"red\">White</option>\n");
      out.write("                        <option value=\"red\">Yellow</option>\n");
      out.write("                        <option value=\"red\">Orange</option>\n");
      out.write("                        <option value=\"red\">Purple</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"leftAdv\" style=\"float:left; width: 50%; margin-left: 10px;\">\n");
      out.write("                <label for=\"price\">Price: </label><input type=\"text\" id=\"price\">\n");
      out.write("                        <div id=\"price-range\" style=\"width:100px; display: inline-block; margin-left: 10px; vertical-align: bottom;\"></div>\n");
      out.write("                        <br>\n");
      out.write("                        <label for=\"year\">Year: </label><input type=\"text\" id=\"year\">\n");
      out.write("                        <div id=\"year-range\" style=\"width:100px; display: inline-block; margin-left: 10px; vertical-align: bottom;\"></div><br>\n");
      out.write("                        <label for=\"km\">Km </label><input type=\"text\" id=\"km\">\n");
      out.write("                        <div id=\"km-range\" style=\"width:100px; display: inline-block; margin-left: 10px; vertical-align: bottom;\"></div><br>\n");
      out.write("                        <label for=\"postDate\">Post Date: </label>\n");
      out.write("                        <select id=\"beforeAfter\" name=\"beforeAfter\">\n");
      out.write("                                <option value=\"after\">After</option>\n");
      out.write("                                <option value=\"before\">Before</option>\n");
      out.write("                        </select>\n");
      out.write("                        <input id=\"postDate\" name=\"postDate\">\n");
      out.write("            </div>\n");
      out.write("            <div id=\"advSearchSubmit\" style=\"float:left; width: 100%; margin-top: 10px;\">\n");
      out.write("                <input type=\"submit\" value=\"Search\" style=\"margin-left: auto; margin-right: auto; display:inline-block;\">\n");
      out.write("                <input type=\"button\" id=\"closeSearchButton\" value=\"Close Box\" style=\"margin-right: 20px;\">\n");
      out.write("            </div>1\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id=\"loginpopup\" class=\"modallogin\">\n");
      out.write("                        <img alt=\"Close\" id=\"closeLoginPopup\" src=\"images/gtk-close.png\" class=\"closeButton\"/>\n");
      out.write("                        <div class=\"loginHeaderText\">Log In </div>\n");
      out.write("\n");
      out.write("                        <form action=\"LoginController\" method=\"POST\">\n");
      out.write("                            <span class=\"loginBodyText\"><b>User: </b></span>\n");
      out.write("                            <input class=\"roundBox\" type=\"text\" name=\"username\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <span class=\"loginBodyText\"><b>Password: </b></span>\n");
      out.write("                                <input class=\"roundBox\" type=\"password\" name=\"userpass\"/>\n");
      out.write("                            <input type=\"submit\" value=\"Log In\" class=\"loginbutton\" style=\"margin-bottom:0px; margin-left: 10px;width:70px;\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                    \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>");
      out.write("\n");
      out.write("<!--<script src=\"js/register_jq.js\" type=\"text/javascript\"></script>-->\n");
      out.write("<script src=\"js/jquery.validate.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/register.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/jquery.validate.password.js\" type=\"text/javascript\"></script>\n");
      out.write("<div id=\"bodyContent\" style=\"margin-top: 10px;\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<div id=\"tabs\" style=\"width: 90%; height: 500px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;\n");
      out.write("    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;\" >\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li><a href=\"#receipt\">Receipt</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\n");
      out.write("\t\t<div id=\"receipt\" style=\"-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:420px; margin-bottom: 20px;\">\n");
      out.write("                    <div id=\"vehicleContainer\" style=\"overflow: auto; height: 100%;\" class=\"tableWrapper\">\n");
      out.write("                    <form id=\"receipt\" method=\"POST\" action=\"DetailsAction\">\n");
      out.write("\t\t\t<p>\n");
      out.write("\t\t\t\t<label for=\"offer\">Offer Code</label>\n");
      out.write("\t\t\t\t<input id=\"offer\" name=\"offer\" class=\"required\" minlength=\"1\" maxlength=\"10\" type=\"number\" />\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div id=\"submitPanel\" style=\"float: left; width: 100%; margin-top: 5px;\">\n");
      out.write("                            <input type=\"submit\" value=\"Confirm\" style=\"margin-left: auto; margin-right: auto; display:block;\">\n");
      out.write("            </div>\n");
      out.write("\t\t\t</form>\n");
      out.write("                    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        <div id=\"footer\" style=\"position: fixed; padding: 2px; bottom:0px; width:80%; margin-top:15px\" class=\"toproundBox flipmotorRed\">\n");
      out.write("            <div style=\"margin-left:10px; font-family:'FerroRosso'; float:left; font-weight: bold;\">FlipMotor &#174;</div>\n");
      out.write("            ");
 if(null == session.getAttribute("adminid") && null == session.getAttribute("userid")){ 
      out.write(" \n");
      out.write("            <input id=\"adminButtonId\" type=\"submit\" class=\"destroyLinkStyles\" id=\"headerText\" value=\"Admin\">\n");
      out.write("            ");
 }
            else if(null!=session.getAttribute("adminid")){                            
            
      out.write("\n");
      out.write("            <form action=\"AdminLogIn\" method=\"POST\"><input id=\"adminLogOut\" type=\"submit\"  class=\"destroyLinkStyles\" id=\"headerText\" value=\"Log Out\"></form>\n");
      out.write("            ");

                 } else {
            
      out.write("\n");
      out.write("            <form action=\"LogoutController\" method=\"POST\"><input id=\"userLogOut\" type=\"submit\"  class=\"destroyLinkStyles\" id=\"headerText\" value=\"Log Out\"></form>\n");
      out.write("            ");

                 }
            
      out.write("\n");
      out.write("            <form action=\"About\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" class=\"destroyLinkStyles\" id=\"headerText\" value=\"About Us\">\n");
      out.write("            </form>\n");
      out.write("            <form action=\"TermsAndConditions\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" class=\"destroyLinkStyles\" id=\"headerText\" value=\"Terms & Conditions\">\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </div> <!-- Wrapper div clos-->\n");
      out.write("                    <div id=\"adminpopup\" class=\"modallogin\">\n");
      out.write("                        <img alt=\"Close\" id=\"closeAdminPopup\" src=\"images/gtk-close.png\" class=\"closeButton\"/>\n");
      out.write("                        <div class=\"loginHeaderText\">Administrator Log In </div>\n");
      out.write("\n");
      out.write("                        <form action=\"AdminLogIn\" method=\"POST\">\n");
      out.write("                            <span class=\"loginBodyText\"><b>Admin user: </b></span>\n");
      out.write("                            <input class=\"roundBox\" type=\"text\" name=\"username\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <span class=\"loginBodyText\"><b>Password: </b></span>\n");
      out.write("                                <input class=\"roundBox\" type=\"password\" name=\"userpass\"/>\n");
      out.write("                            <input type=\"submit\" value=\"Log In\" class=\"loginbutton\" style=\"margin-bottom:0px; margin-left: 10px;width:70px;\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
