<%@include file="header.jsp" %>
    <style>
    .ui-tabs-vertical { width: 55em; }
    .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
    .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
    .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
    .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
    .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}
    </style>
    <script src="js/jquery.validate.js" type="text/javascript"></script>
    <script src="js/register.js" type="text/javascript"></script>
    <script src="js/jquery.validate.password.js" type="text/javascript"></script>
    <script>
        $('#tabs').ready(function(){
           $('#tabs').tabs();
        });

        $('#extraManagement').ready(function(){
           $('#extraManagement').tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
           $("#extraManagement li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
           $('#datepicker').datepicker();
        });

        /*$('#results').ready(function() {
            $('#results').dataTable({
               "sScrollY": "380px",
               "bPaginate": false
            });
        } );*/
        $('#tabs').ready(function(){
            $("#vehicle").tablesorter();
            $("#business").tablesorter();
        });


        $(function(){
            $('#dialog').dialog({
                autoOpen: false,
                resizable: false,
                draggable: false,
                height: 400,
                width: 800,
                title: "Anuncio"
            });

            $('#bRow1').click(function(){
                 $('#dialog').dialog('open');
                 return false;
            });

            $('#closeButton').click(function(){
                 $('#dialog').dialog('close');
                 return false;
            });
        });



    </script>

    <div id="bodycontent" style="margin-top: 10px;">
        <div id="tabs" style="width: 90%; height: 300px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;" >
            <ul>
                <li><a href="#tabs-1">Vehicle ADs Validator</a></li>
                <li><a href="#tabs-2">Business ADs Validator</a></li>
            </ul>
            <div id="tabs-1" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:240px; margin-bottom: 20px;">
                <form id="vehiclesForm" action="AdminPage" method="post">
                <div id="tableContainer" style="float: left;" class="tableWrapper">
                <table id="vehicle" style="float:left;" class="tablesorter">
                    <thead style="display: block;">
                        <tr><th style="width:199px;">Date</th><th style="width:350px">Advertiser</th><th style="width:130px;">Fee</th><th style="width:50px;">Payed</th><th style="width:70px;">See AD</th><th style="width:100px;">Validate AD</th></tr>
                    </thead>
                    <tbody style="overflow: auto; display: block; height: 150px;">
                        <tr><td style="width:199px;">20/10/12</td><td style="width:358px">Perico</td><td style="width:130px;">10</td><td style="width:55px;"><input type="checkbox" checked disabled ></td><td style="width:70px;"><button id="bRow1" onclick="">See AD</button></td><td style="width:85px;"><input type="checkbox" name="vRow1"></td></tr>
                        <tr><td>20/10/12</td><td>Manuel</td><td>20</td><td><input type="checkbox" checked disabled ></td><td><button id="bRow2" onclick="">See AD</button></td><td><input type="checkbox" name="vRow2"></td></tr>

                    </tbody>
                </table>
                </div>
                <div id="validateSubmit2" style="float: left; width: 100%; margin-top: 5px;">
                    <input type="submit" value="Validate" style="margin-left: auto; margin-right: auto; display:block;">
                 </div>
                </form>
            </div>
            <div id="tabs-2" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:230px; margin-bottom: 20px;">

                <form id="businessForm" action="AdminPage" method="post">
                <div id="tableContainer" style="float: left;" class="tableWrapper">
                <table id="business" style="float: left;" class="tablesorter">
                    <thead style="display: block;">
                        <tr><th style="width:199px;">Date</th><th style="width:350px">Advertiser</th><th style="width:130px;">Fee</th><th style="width:50px;">Payed</th><th style="width:70px;">See AD</th><th style="width:100px;">Validate AD</th></tr>
                    </thead>
                    <tbody style="overflow: auto; display: block; height: 150px;">
                    
                        <tr><td style="width:199px;">20/10/12</td><td style="width:358px">OpenBank</td><td style="width:130px;">10</td><td style="width:55px;"><input type="checkbox" checked disabled ></td><td style="width:70px;"><button id="bRow1" onclick="">See AD</button></td><td style="width:85px;"><input type="checkbox" name="vRow1"></td></tr>
                        <tr><td>20/10/12</td><td>Danone</td><td>20</td><td><input type="checkbox" checked disabled ></td><td><button id="bRow2" onclick="">See AD</button></td><td><input type="checkbox" name="vRow2"></td></tr>
                        <tr><td>20/10/12</td><td>CocaCola</td><td>20</td><td><input type="checkbox" checked disabled ></td><td><button id="bRow2" onclick="">See AD</button></td><td><input type="checkbox" name="vRow2"></td></tr>
                        <tr><td>20/10/12</td><td>IKEA</td><td>20</td><td><input type="checkbox" checked disabled ></td><td><button id="bRow2" onclick="">See AD</button></td><td><input type="checkbox" name="vRow2"></td></tr>
                        <tr><td>20/10/12</td><td>HP</td><td>20</td><td><input type="checkbox" checked disabled ></td><td><button id="bRow2" onclick="">See AD</button></td><td><input type="checkbox" name="vRow2"></td></tr>

                    </tbody>
                </table>
                </div>
                 <div id="validateSubmit2" style="float: left; width: 100%; margin-top: 5px;">
                    <input type="submit" value="Validate" style="margin-left: auto; margin-right: auto; display:block;">
                 </div>
                </form>
            </div>

        </div>
        <div id="extraManagement" style="font-size:12px; width:90%; height: 200px; background-color: white; margin:auto; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;">
            <ul>
                <li><a href="#viewOffers">Existing Offers</a></li>
                <li><a href="#newOffer">Create Offer</a></li>
                <li><a href="#viewAdmins">Existing Admins</a></li>
                <li><a href="#newAdmin">Create Admin</a></li>
            </ul>
            <div id="viewOffers" style="float: left; width: 75%; height: 70%; margin: 15px; margin-left: 40px; border: 2px solid grey; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;">
                <div id="tableContainer" style="float: left;" >
                    <table id="offers" style="float: left;" class="tablesorter">
                        <thead style="display: block;">
                            <tr><th style="width:199px;">Name</th><th style="width:280px">Type</th><th style="width:115px;">Fee</th><th style="width:50px;">Months</th><th style="width:70px;"># Ads</th><th style="width:80px;">Expires</th><th style="width:80px;">Delete</th></tr>
                        </thead>
                        <tbody style=" height: 100px; overflow: auto; display: block;">

                            <tr><td style="width:180px;">20/10/12</td><td style="width:260px">OpenBank</td><td style="width:115px;">10</td><td style="width:60px;"><td style="width:70px;"></td><td style="width:80px;"></td><td style="width:70px"><form id="del_id" action="DeleteOffer" method="post"><input type="submit" value="Delete"></form></td></td> </tr>
                            <tr><td style="width:180px;">20/10/12</td><td style="width:260px">OpenBank</td><td style="width:115px;">10</td><td style="width:60px;"><td style="width:70px;"></td><td style="width:80px;"></td><td style="width:70px"><input type="checkbox" checked disabled ></td></td> </tr>
                            <tr><td style="width:180px;">20/10/12</td><td style="width:260px">OpenBank</td><td style="width:115px;">10</td><td style="width:60px;"><td style="width:70px;"></td><td style="width:80px;"></td><td style="width:70px"><input type="checkbox" checked disabled ></td></td> </tr>
                            <tr><td style="width:180px;">20/10/12</td><td style="width:260px">OpenBank</td><td style="width:115px;">10</td><td style="width:60px;"><td style="width:70px;"></td><td style="width:80px;"></td><td style="width:70px"><input type="checkbox" checked disabled ></td></td> </tr>
                            
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="newOffer" style="float: left; width: 75%; height: 70%; margin: 15px; margin-left: 40px; border: 2px solid grey; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;">
                <form method="post" action="AdminPage">
                    <div style="float: left; width: 100%; height: 80px" class="tableWrapper">
                        <div id="offerDetails" style="float:left; width:50%;">
                            <label>Type:</label>
                            <input type="radio" name="offerType" value="vehicle" > Vehicle Ad
                            <input type="radio" name="offerType" value="business"> Business Ad <br>
                            <label>Offer Name:</label> <input type="text" name="name"><br>
                            <label>End date:</label> <input type="text" id="datepicker">
                        </div>
                        <div id="offerDetails2" style="float:left; width:50%;">
                            <label>Fee (&euro;):</label> <input type="text" name="fee"><br>
                            <label>Months:</label> <input type="text" name="months"><br>
                            <label>Number of ads:</label> <input type="text" name="numberAds">
                        </div>
                    </div>
                    <div id="offerSubmit" style="float: left; width: 100%; margin-top: 5px;">
                        <input type="submit" value="Create Offer" style="margin-left: auto; margin-right: auto; display:block;">
                    </div>
                </form>
            </div>
            <div id="viewAdmins" style="float: left; width: 75%; height: 70%; margin: 15px; margin-left: 40px; border: 2px solid grey; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;">
                <div id="tableContainer" style="float: left; margin-left: 240px;" >
                    <table id="admins" style="float: left;" class="tablesorter">
                        <thead style="display: block;">
                            <tr><th style="width:199px;">Admin</th><th style="width:100px">Delete</th></tr>
                        </thead>
                        <tbody style=" height: 100px; overflow: auto; display: block;">
                            <tr><td style="width:199px;">Admin</td><td style="width:100px"><form id="del_id" action="DeleteAdmin" method="post"><input type="submit" value="Delete"></form></td></tr>
                            <tr><td>Admin</td><td><form id="del_id" action="DeleteAdmin" method="post"><input type="submit" value="Delete"></form></td></tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="newAdmin" style="float: left; width: 75%; height: 70%; margin: 15px; margin-left: 40px; border: 2px solid grey; -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;">
                    <form id="adminSignUp" action="AdminPage" method="POST">
                        <div id="leftPanel" style="float: left; width: 50%; padding: 0px;">
                            <label for="id">ID</label>
                            <input id="id" name="id" class="required" minlength="4" maxlength="10" type="text"><br>
                            <label for="email">Email</label>
                            <input id="email" name="email" class="required" minlength="4" maxlength="50" type="email"> <br> <label for="password">Password</label>
                            <input name="password" id="password" type="password" class="required" minlength="4" maxlength="50"><br>
                            <label for="confirmpassword">Confirm Password</label>
                            <input name="confirmpassword" type="password" class="required" equalTo="#password" id="confirmpassword">
                        </div>
                        <div id="rightPanel" style="float: left; width: 50%;">
                            <label for="terms"><a href="/legal.jsp" target="_blank">Terms and conditions</a></label>
                            <input id="terms" name="terms" class="required" type="checkbox">
                            <div class="password-meter" style="margin-top:20px;">
                                <div class="password-meter-message"> </div>
                                <div class="password-meter-bg">
                                        <div class="password-meter-bar"></div>
                                </div>
                            </div>
                        </div>
			<div id="submitPanel" style="width:100%; float: left; margin-top: 25px;">
                            <input type="submit" value="Register New Admin" style="margin-left: auto; margin-right: auto; display:block;">
                        </div>
                    </form>
            </div>
        </div>



        

    </div>
<%@include file="footer.jsp" %>