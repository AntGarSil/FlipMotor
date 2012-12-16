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
        <title>FlipMotor</title>
        
        <link rel="Stylesheet" href="style/templateStyles.css" type="text/css" media=screen >
        <link rel="Stylesheet" href="style/s3slider.css" type="text/css" media=screen >
        <link rel="stylesheet" type="text/css" href="style/register.css"/>
        <link rel="Stylesheet" href="style/home.css" type="text/css" media=screen >
        <link rel="stylesheet" href="style/questionmark.css" type="text/css" media="screen">
        <link rel="stylesheet" href="style/custom-theme2/jquery-ui-1.9.0.custom.css"  type="text/css">
        <link rel="stylesheet" href="js/jquery.tablesorter/themes/blue/style.css"  type="text/css">
        <link rel="stylesheet" type="text/css" href="style/jquery.validate.password.css"/>
        <script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script src="js/jquery.lightbox_me.js" type="text/javascript"></script>
        <script src="js/templates.js" type="text/javascript"></script>
        <script src="js/s3Slider.js" type="text/javascript"></script>
        <script src="js/jquery.tablesorter/jquery.tablesorter.js" type="text/javascript"></script>
        <script src="js/sliders.js" type="text/javascript"></script>
        <!--
        <link rel="stylesheet" type="text/css" media="screen" href="style/register_jquery.css" />
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
                        <%
                            if(session.getAttribute("adminid")!= null){
                        %>
                                <form action="AdminPage" method="POST">
                                    <input type="submit" class="headerText" id="headerText" value="FlipMotor">
                                </form>
                        <%
                            }else{
                        %>
                                <form action="Home" method="POST">
                                    <input type="submit" class="headerText" id="headerText" value="FlipMotor">
                                </form>
                        <%
                            }
                        %>
                    </div>
                    
                    <div id="navigationBar" style="width: 60%; height: 100%; float:left;">
                        
                        <%-- Code to paint buttons according to user log in --%>
                        <% if(null == session.getAttribute("userid") && null == session.getAttribute("adminid")){ %>                        
                                <div id="buttonBox" style="float: right; margin-top: 20px; margin-right: 50px;">
                                    <div style=""><input id='loginButtonId' type="button" class="loginbutton" value="Log in"></div>
                                    <div><form action="Register" method="POST"><input type="submit" id='registerButtonId' class="loginbutton" value="Register"/></form></div>
                                </div>
                        <% } else if(null != session.getAttribute("userid")){ %>
                        
                            <div id="buttonBox" style="float: right; margin-top: 20px; margin-right: 0px;">
                                <div><form action="UserProfile" method="POST"><input id='userProfileButtonId' type="submit" class="loginbutton" value="Profile"></form></div>
                                <div><form action="LogoutController" method="POST"><input type="submit" id='registerButtonId' class="loginbutton" value="Log Out"/></form></div>
                            </div>
                            <div id="postFavBox" style="float: right; margin-top: 20px; margin-right: 10px;">
                                <form action="PostAd" method="POST">
                                    <input type="submit" class="loginbutton" value="New Ad">
                                </form>
                                <form action="Favorites" method="POST">
                                    <input type="submit" class="loginbutton" value="Favorites">
                                </form>
                            </div>
                        <%
                             } else if(null!= session.getAttribute("adminid")){
                        %>
                            <div id="postBox" style="float: right; margin-top: 40px; margin-right: 50px;">
                                <form action="AdminLogOut" method="POST">
                                    <input type="submit" class="loginbutton" value="Log Out">
                                </form>
                            </div>
                            <div id="adminBox" style="float: right; margin-top: 40px; margin-right: 50px;">
                                <form action="AdminPage" method="POST">
                                    <input type="submit" class="loginbutton" value="Admin Page">
                                </form>
                            </div>
                        <%
                             }
                        %>
                        <%--    ------------------------------------        --%>
                        
                        <%--<div id="searchBox" style=" float: right; width: 350px; height: 100%; margin-top: 40px;">
                            <input id="searchBoxId" class="searchBox" style="width:200px; margin: 20px;" type="text" onfocus="if (this.value=='Search...') this.value = ''" value="Search..." />

                        </div>--%>
                        <%
                             if(null== session.getAttribute("adminid")){
                        %>
                        <div id="w2b-searchbox" style="margin-top:30px; margin-left:80px;">
                        <form id="w2b-searchform" action="ControllerServlet" method="get">
                            <input type="text" id="s" name="q" value=""/>
                            <input type="image" src="http://img1.blogblog.com/img/blank.gif" id="sbutton" />
                            
                        </form>
                            <input type="button" id="advSearchButton" value="Advanced Search">
                        </div>
                        <%
                             }
                        %>
                        
                        
                        
        <div id="advSearchBox" style="width:750px; height: 120px; border: 2px solid grey; padding: 10px; margin-top: 10px; background-image: url('images/seamlesstexture1_1200.jpg');
         -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px; margin:auto; display: none; z-index: 100; position: relative; left: -280px; top: 30px;">
            <form id="advSearch" method="get" action="AdvancedSearch">
            <div id="leftAdv" style="float:left; width: 40%;">
                <input type="hidden" id="opt" name="opt" value="Advanced">
                <label for="brand">Brand: </label><input name="brand" type="text"><br>
                <label for="model">Model: </label><input name="model" type="text"><br>
                <label for="vehicle">Type: </label>
                <select id="vehicle" name="vehicle">
                        <option value="car">Car</option>
                        <option value="motorbike">Motorbike</option>
                </select>
                <br>
                <label for="color">Color: </label>
                <select id="color" name="color">
                        <option value="red">Red</option>
                        <option value="red">Blue</option>
                        <option value="red">Green</option>
                        <option value="red">Black</option>
                        <option value="red">White</option>
                        <option value="red">Yellow</option>
                        <option value="red">Orange</option>
                        <option value="red">Purple</option>
                </select>
            </div>
            <div id="leftAdv" style="float:left; width: 50%; margin-left: 10px;">
                <label for="price">Price: </label><input type="text" id="price">
                        <div id="price-range" style="width:100px; display: inline-block; margin-left: 10px; vertical-align: bottom;"></div>
                        <br>
                        <label for="year">Year: </label><input type="text" id="year">
                        <div id="year-range" style="width:100px; display: inline-block; margin-left: 10px; vertical-align: bottom;"></div><br>
                        <label for="km">Km </label><input type="text" id="km">
                        <div id="km-range" style="width:100px; display: inline-block; margin-left: 10px; vertical-align: bottom;"></div><br>
                        <label for="postDate">Post Date: </label>
                        <select id="beforeAfter" name="beforeAfter">
                                <option value="after">After</option>
                                <option value="before">Before</option>
                        </select>
                        <input id="postDate" name="postDate">
            </div>
            <div id="advSearchSubmit" style="float:left; width: 100%; margin-top: 10px;">
                <input type="submit" value="Search" style="margin-left: auto; margin-right: auto; display:inline-block;">
                <input type="button" id="closeSearchButton" value="Close Box" style="margin-right: 20px;">
            </div>1
            </form>
        </div>
                        
                        
                    </div>

                    <div id="loginpopup" class="modallogin">
                        <img alt="Close" id="closeLoginPopup" src="images/gtk-close.png" class="closeButton"/>
                        <div class="loginHeaderText">Log In </div>

                        <form action="Login" method="POST">
                            <span class="loginBodyText"><b>User: </b></span>
                            <input class="roundBox" type="text" name="username"/>


                            <span class="loginBodyText"><b>Password: </b></span>
                                <input class="roundBox" type="password" name="userpass"/>
                            <input type="submit" value="Log In" class="loginbutton" style="margin-bottom:0px; margin-left: 10px;width:70px;"/>
                        </form>
                    </div>
                        
                    

                </div>
            </div>