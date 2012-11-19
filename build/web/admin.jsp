<%@include file="header.jsp" %>

    <script>
        $('#tabs').ready(function(){
           $('#tabs').tabs();
        });

        $('#newOfferContainer').ready(function(){
           $('#newOfferContainer').tabs();
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
                    E-mail: cuchuflete@oletuscohones.com <br>
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
        <div id="tabs" style="width: 90%; height: 350px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;" >
            <ul>
                <li><a href="#tabs-1">Vehicle ADs Validator</a></li>
                <li><a href="#tabs-2">Business ADs Validator</a></li>
            </ul>
            <div id="tabs-1" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:280px; margin-bottom: 20px;">
                <form id="vehiclesForm" action="admin.jsp" method="post">
                <div id="tableContainer" style="float: left;" class="tableWrapper">
                <table id="vehicle" style="float:left;" class="tablesorter">
                    <thead style="display: block;">
                        <tr><th style="width:199px;">Date</th><th style="width:350px">Advertiser</th><th style="width:130px;">Fee</th><th style="width:50px;">Payed</th><th style="width:70px;">See AD</th><th style="width:100px;">Validate AD</th></tr>
                    </thead>
                    <tbody style="overflow: auto; display: block; height: 200px;">

                        <tr><td style="width:199px;">Date</td><td style="width:358px">Advertiser</td><td style="width:130px;">Fee</td><td style="width:55px;"><input type="checkbox" checked disabled ></td><td style="width:70px;"><button id="bRow1" onclick="">See AD</button></td><td style="width:85px;"><input type="checkbox" name="vRow1"></td></tr>
                        <tr><td>Date</td><td>Advertiser</td><td>Fee</td><td><input type="checkbox" checked disabled ></td><td><button id="bRow2" onclick="">See AD</button></td><td><input type="checkbox" name="vRow2"></td></tr>

                    </tbody>
                </table>
                </div>
                <div id="validateSubmit2" style="float: left; width: 100%; margin-top: 5px;">
                    <input type="submit" value="Validate" style="margin-left: auto; margin-right: auto; display:block;">
                 </div>
                </form>
            </div>
            <div id="tabs-2" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:230px; margin-bottom: 20px;">

                <form id="businessForm" action="admin.jsp" method="post">
                <div id="tableContainer" style="float: left;" class="tableWrapper">
                <table id="business" style="float: left;" class="tablesorter">
                    <thead style="display: block;">
                        <tr><th style="width:199px;">Date</th><th style="width:350px">Advertiser</th><th style="width:130px;">Fee</th><th style="width:50px;">Payed</th><th style="width:70px;">See AD</th><th style="width:100px;">Validate AD</th></tr>
                    </thead>
                    <tbody style="overflow: auto; display: block; height: 200px;">
                    
                        <tr><td style="width:199px;">Date</td><td style="width:358px">Advertiser</td><td style="width:130px;">Fee</td><td style="width:55px;"><input type="checkbox" checked disabled ></td><td style="width:70px;"><button id="bRow1" onclick="">See AD</button></td><td style="width:85px;"><input type="checkbox" name="vRow1"></td></tr>
                        <tr><td>Date</td><td>Advertiser</td><td>Fee</td><td><input type="checkbox" checked disabled ></td><td><button id="bRow1" onclick="">See AD</button></td><td><input type="checkbox" name="vRow1"></td></tr>

                    </tbody>
                </table>
                </div>
                 <div id="validateSubmit2" style="float: left; width: 100%; margin-top: 5px;">
                    <input type="submit" value="Validate" style="margin-left: auto; margin-right: auto; display:block;">
                 </div>
                </form>
            </div>

        </div>
        <div id="newOfferContainer" style="width: 90%; height: 170px;  margin: auto; border: 2px solid grey; padding: 3px; margin-top: 5px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px; font-size: 12px;">
            <ul>
                <li><a href="#tabs-3">New Offer creator</a></li>
            </ul>
            <div id="tabs-3" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:100px; margin-bottom: 20px;">
                <form method="post" action="admin.jsp">
                    <div style="float: left; width: 100%; height: 70%" class="tableWrapper">
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
        </div>


    </div>
<%@include file="footer.jsp" %>