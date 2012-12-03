
        <div id="footer" style="position: fixed; padding: 2px; bottom:0px; width:80%; margin-top:15px" class="toproundBox flipmotorRed">
            <div style="margin-left:10px; font-family:'FerroRosso'; float:left; font-weight: bold;">FlipMotor &#174;</div>
            <% if(null == session.getAttribute("adminid") && null == session.getAttribute("userid")){ %> 
            <input id="adminButtonId" type="submit" class="destroyLinkStyles" id="headerText" value="Admin">
            <% }
            else if(null!=session.getAttribute("adminid")){                            
            %>
            <form action="AdminLogIn" method="POST"><input id="adminLogOut" type="submit"  class="destroyLinkStyles" id="headerText" value="Log Out"></form>
            <%
                 } else {
            %>
            <form action="LogoutController" method="POST"><input id="userLogOut" type="submit"  class="destroyLinkStyles" id="headerText" value="Log Out"></form>
            <%
                 }
            %>
            <form action="About" method="POST">
                <input type="submit" class="destroyLinkStyles" id="headerText" value="About Us">
            </form>
            <form action="TermsAndConditions" method="POST">
                <input type="submit" class="destroyLinkStyles" id="headerText" value="Terms & Conditions">
            </form>
            
        </div>
    </div> <!-- Wrapper div clos-->
                    <div id="adminpopup" class="modallogin">
                        <img alt="Close" id="closeAdminPopup" src="images/gtk-close.png" class="closeButton"/>
                        <div class="loginHeaderText">Administrator Log In </div>

                        <form action="AdminLogIn" method="POST">
                            <span class="loginBodyText"><b>Admin user: </b></span>
                            <input class="roundBox" type="text" name="username"/>


                            <span class="loginBodyText"><b>Password: </b></span>
                                <input class="roundBox" type="password" name="userpass"/>
                            <input type="submit" value="Log In" class="loginbutton" style="margin-bottom:0px; margin-left: 10px;width:70px;"/>
                        </form>
                    </div>
    </body>
</html>
