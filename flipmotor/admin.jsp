<%@include file="header.jsp" %>

    <script src="js/jquery.validate.js" type="text/javascript"></script>
    <script src="js/register.js" type="text/javascript"></script>
    <script src="js/jquery.validate.password.js" type="text/javascript"></script>
    <script>
        $('#tabs').ready(function(){
           $('#tabs').tabs();
        });

        $('#accordionContainer').ready(function(){
           $('#accordionContainer').accordion();
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

        <div id="dialog" style="font-size: 14px;">
            <div style="float:left; width: 240px; height:100%">
                <div id="adPhoto" style="width: 100%; height: 70%; background-color: red;">
                    Photo
                    <img src="" alt="Photo">
                </div>
                <div id="contactInfo" style="width: 100%; height: auto; margin-top: 10px;">
                    Contact <br>
                    Name: Perico <br>
                    E-mail: cuchuflete@oleole.com <br>
                    Phone: 123456789
                </div>
            </div>

            <div id="adDescription" style="float:left; width: 500px; height:100%; margin-left: 20px;">
                <h3>Details</h3>
                <div style="height: 60px;">
                    <div style="float:left; width: 50%;">
                    Type: <br>
                    Brand:<br>
                    Model:<br>
                    Color:<br>
                </div>
                <div style="float:left; width: 50%;">
                    Year:<br>
                    Km: <br>
                    Price: <br>
                    Ad date: <br>
                </div>

                </div>

                <div style="width:100%; height: 150px; margin-top:25px;">
                    <h4>Description</h4>
                    Descripcion y más detalles del vehículo
                </div>
                <div id="footBar" style="width:100%; height:auto; background-color: white;">
                    <button id="closeButton" style="float: right; margin-right: 25px; margin-top: 20px;">Close</button>
                </div>


            </div>
        </div>

    <div id="bodycontent" style="margin-top: 10px;">
        <div id="tabs" style="width: 90%; height: 300px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;" >
            <ul>
                <li><a href="#tabs-1">Vehicle ADs Validator</a></li>
                <li><a href="#tabs-2">Business ADs Validator</a></li>
            </ul>
            <div id="tabs-1" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:240px; margin-bottom: 20px;">
                <form id="vehiclesForm" action="ControllerServlet" method="post">
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

                <form id="businessForm" action="ControllerServlet" method="post">
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
        <div id="accordionContainer" style="font-size:12px; width:90%; height: 200px; background-color: white; margin:auto; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;">
            <h3>New Offer</h3>
            <div id="newOffer">
                <form method="post" action="admin.jsp">
                    <div style="float: left; width: 100%; height: 80px" class="tableWrapper">
                        <div id="offerDetails" style="float:left; width:50%;">
                            Type:
                            <input type="radio" name="offerType" value="vehicle" > Vehicle Ad
                            <input type="radio" name="offerType" value="business"> Business Ad <br>
                            Offer Name: <input type="text" name="name"><br>
                            End date: <input type="text" id="datepicker">
                        </div>
                        <div id="offerDetails2" style="float:left; width:50%;">
                            Fee (&euro;): <input type="text" name="fee"><br>
                            Months: <input type="text" name="months"><br>
                            Number of ads: <input type="text" name="numberAds">
                        </div>
                    </div>
                    <div id="offerSubmit" style="float: left; width: 100%; margin-top: 5px;">
                        <input type="submit" value="Create Offer" style="margin-left: auto; margin-right: auto; display:block;">
                    </div>
                </form>
            </div>
            <h3>New Admin Account</h3>
            <div id="newAdmin">
                    <form id="adminSignUp" action="/Controller" method="POST">
                        <div id="leftPanel" style="float: left; width: 50%; padding: 0px;">
                            <label for="id">ID</label>
                            <input id="id" name="id" class="required" minlength="4" maxlength="10" type="text"><br>
                            <label for="password">Password</label>
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
			<div id="submitPanel" style="width:100%; float: left;">
                            <input type="submit" value="Register New Admin" style="margin-left: auto; margin-right: auto; display:block;">
                        </div>
                    </form>
            </div>
        </div>



        

    </div>
<%@include file="footer.jsp" %>