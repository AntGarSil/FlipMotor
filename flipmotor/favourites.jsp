<%@include file="header.jsp" %>

    <script>


        /*$('#results').ready(function() {
            $('#results').dataTable({
               "sScrollY": "380px",
               "bPaginate": false
            });
        } );*/
        $('#tabs').ready(function(){
            $("#results").tablesorter();
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

            $('#visitAd1').click(function(){
                 $('#dialog').dialog('open');
                 return false;
            });

            $('#closeButton').click(function(){
                 $('#dialog').dialog('close');
                 return false;
            });
        });
        
        $("#tabs").ready(function() {
                $( "#tabs" ).tabs();
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

    <div id="bodycontent">
        <div id="tabs" style="width: 90%; height: 500px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;" >
            <ul>
                <li><a href="#tabs-1">Results</a></li>
            </ul>
            <div id="tabs-1" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:100%; margin-bottom: 20px;">
                <div id="tableContainer" class="tableWrapper">
                <table id="results" style="margin: auto; margin: auto;" class="tablesorter">
                    
                    <thead style="display: block;">
                        <tr><th style="width:195px;">Date</th><th style="width:60px;">Photo</th><th style="width:180px;">Brand and Model</th><th style="width:190px;">State</th><th style="width:50px;">Year</th><th style="width:100px;">Price</th><th style="width:65px;">Visit</th></tr>
                    </thead>
                    <tbody style="overflow: auto; display: block; height: 390px;">
                        <tr id="row1"><td style="width:199px;">16/10/2012 at 16:00</td><td style="width:62px;"><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td style="width:180px;">BMW 320</td><td style="width:201px;">Barcelona</td><td style="width:52px;">2008</td><td style="width:102px;">4000</td><td style="width:66px;"><input type="button" id="visitAd1" value="Visit AD"></td></tr>
                        
                    </tbody>
                </table>
                </div>
            </div>
        </div>
    </div>
<%@include file="footer.jsp" %>