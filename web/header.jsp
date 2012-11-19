<%--
    Document   : header
    Created on : 09-oct-2012, 19:47:41
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="Stylesheet" href="style/templateStyles.css" type="text/css" media=screen >
        <link rel="Stylesheet" href="style/s3slider.css" type="text/css" media=screen >
        <link rel="Stylesheet" href="style/home.css" type="text/css" media=screen >
        <link rel="stylesheet" href="style/custom-theme2/jquery-ui-1.9.0.custom.css"  type="text/css">
        <link rel="stylesheet" href="js/jquery.tablesorter/themes/blue/style.css"  type="text/css">
        <script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script src="js/jquery.lightbox_me.js" type="text/javascript"></script>
        <script src="js/templates.js" type="text/javascript"></script>
        <script src="js/s3Slider.js" type="text/javascript"></script>
        <script src="js/jquery.tablesorter/jquery.tablesorter.js" type="text/javascript"></script>
        <script src="js/tabInstantiator.js" type="text/javascript"></script>
        <!--<script src="js/DataTables-1.9.4/media/js/jquery.dataTables.js"></script>
        <link rel="stylesheet" href="js/DataTables-1.9.4/media/css/jquery.dataTables.css" type="text/css">
        <script src="js/jquery.jqGrid-4.4.1/js/jquery.jqGrid.min.js" type="text/javascript"></script>
        <script src="js/home.js" type="text/javascript"></script>
            $("#tabs").ready(function() {
                $( "#tabs" ).tabs();
            });
        </script>-->
    </head>
    <body>
        <div id="wheel" style="z-index: 1; float: left; top:0px; left: 0px; position: absolute;"><img src="style/wheel.png" style="height:768px;"></div>
        <div id="wrapper" class="wrapper">
            <div id="headerContainer" style="width: 100%; height:190px;">
                <img class="banner" src="images/EDEPOSITO_840X50_2.jpg" alt="banner" style="height:70px;">

                <div id="headerContent" style="width: 100%; height:110px; ">
                    <div id="logo" style="float:left;width: 40%; height: 100%;">
                        <a href="index.jsp" style="text-decoration:none;" class="headerText" id="headerText">FlipMotor</a>
                    </div>
                    <div id="navigationBar" style="width: 60%; height: 100%; float:left;">
                        
                        <%-- Code to paint buttons according to user log in --%>
                        <% if(null == session.getAttribute("userid")){ %>                        
                        <div id="buttonBox" style="float: right; margin-top: 20px;">
                            <div style=""><input id='loginButtonId' type="button" class="loginbutton" value="Log in"></div>
                            <div><form action="Register" method="POST"><input type="submit" id='registerButtonId' class="loginbutton" value="Register"/></form></div>
                        </div>
                        <% }
                        else {                            
                        %>
                        <div id="buttonBox" style="float: right; margin-top: 20px;">
                            <div style=""><form action="UserProfile" method="POST"><input id='userProfileButtonId' type="submit" class="loginbutton" value="Profile"></form></div>
                            <div><form action="LogoutController" method="POST"><input type="submit" id='registerButtonId' class="loginbutton" value="Log out"/></form></div>
                        </div>                        
                        <%
                             }
                        %>
                        <%--    ------------------------------------        --%>
                        
                        <div id="searchBox" style=" float: right; width: 350px; height: 100%; margin-top: 40px;">
                            <input id="searchBoxId" class="searchBox" style="width:200px; margin: 20px;" type="text" onfocus="if (this.value=='Search...') this.value = ''" value="Search..." />

                        </div>
                        
                        
                    </div>
                    
                   


                    <div id="loginpopup" class="modallogin">
                        <img alt="Close" id="closeLoginPopup" src="images/gtk-close.png" class="closeButton"/>
                        <div class="loginHeaderText">Log In </div>

                        <form action="LoginController" method="POST">
                            <span class="loginBodyText"><b>User: </b></span>
                            <input class="roundBox" type="text" name="username"/>


                            <span class="loginBodyText"><b>Password: </b></span>
                            <input class="roundBox" type="text" name="userpass"/>
                            <input type="submit" value="Log In" class="loginbutton" style="margin-bottom:0px; margin-left: 10px;width:70px;"/>
                        </form>
                    </div>

                </div>
            </div>