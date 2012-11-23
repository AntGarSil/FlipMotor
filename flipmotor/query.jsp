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
        
        $("#tabs").ready(function() {
                $( "#tabs" ).tabs();
        });
           
        
    </script>
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
                        <tr><th style="width:200px;">Date</th><th style="width:60px;">Photo</th><th style="width:200px;">Brand and Model</th><th style="width:200px;">State</th><th style="width:50px;">Year</th><th style="width:100px;">Price</th><th style="width:80px;">Visit AD</th></tr>
                    </thead>
                    <tbody style="overflow: auto; display: block; height: 390px;">
                        <td style="width:199px;">16/10/2012 at 16:00</td><td style="width:62px;"><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td style="width:200px;">BMW 320</td><td style="width:201px;">Barcelona</td><td style="width:52px;">2008</td><td style="width:102px;">4000</td><td style="width:66px;"><form id="ad_id" action="Advert" method="post" ><input type="submit" id="visitAd1" value="Visit AD"></form></td></tr>
                        <tr id="row2"><td>16/10/2012 at 16:00</td><td><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type="button" id="visitAd2" value="Visit AD"></td></tr>
                        <tr id="row3"><td>16/10/2012 at 16:00</td><td><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type="button" id="visitAd2" value="Visit AD"></td></tr>
                        <tr id="row4"><td>16/10/2012 at 16:00</td><td><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type="button" id="visitAd2" value="Visit AD"></td></tr>
                        <tr id="row5"><td>16/10/2012 at 16:00</td><td><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type="button" id="visitAd2" value="Visit AD"></td></tr>
                        <tr id="row6"><td>16/10/2012 at 16:00</td><td><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type="button" id="visitAd2" value="Visit AD"></td></tr>
                        <tr id="row7"><td>16/10/2012 at 16:00</td><td><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type="button" id="visitAd2" value="Visit AD"></td></tr>
                        <tr id="row8"><td>16/10/2012 at 16:00</td><td><img src="images/motos/jet-sport-x-50-motissimo-barcelona-motos-ocasion.jpeg" alt="Photo" style="height:50px; margin-left: auto; margin-right: auto;"></td><td>BMW 320</td><td>Madrid</td><td>2009</td><td>2.000</td><td><input type="button" id="visitAd2" value="Visit AD"></td></tr>
                        
                    </tbody>
                </table>
                </div>
            </div>
        </div>
    </div>
<%@include file="footer.jsp" %>