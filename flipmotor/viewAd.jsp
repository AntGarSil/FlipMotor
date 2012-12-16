<%@include file='header.jsp' %>
<script>
        $('#adContainer').ready(function(){
           $('#adContainer').tabs();
        });
</script>
<div id='bodyContent'>
    <div id='adContainer' style='width: 90%; height: 500px;  margin: auto; border: 2px solid grey; padding: 3px; margin-top: 5px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px; font-size: 12px;'>
            <ul>
                <li><a href='#tabs-1'>Nombre de mi Ad</a></li>
            </ul>
            <div id='tabs-1' style='-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:420px; margin-bottom: 20px;'>
            
            <div style='float:left; width: 240px; height:100%'>
                <div id='adPhoto' style='width: 100%; height: 70%; background-color: red;'>
                    Photo
                    <img src='' alt='Photo'>
                </div>
                <div id='favBox' style='width: 100%; height: 30%;'>
                    <input type='image' src='images/Star-Favorite-Black.png' style='width: 50px;  margin-top: 30px;  margin-left: auto; margin-right: auto; display: block;'>
                </div>
            </div>
            
            <div id='adDescription' style='float:left; width: 380px; height:100%; margin-left: 40px;'>
                <h2>Details</h2>
                <div style='height: 60px;'>
                    <div style='float:left; width: 50%;'>
                    Type: <br>
                    Brand:<br>
                    Model:<br>
                    Color:<br>
                </div>
                <div style='float:left; width: 50%;'>
                    Year:<br>
                    Km: <br>
                    Price: <br>
                    Ad date: <br>
                </div>

                </div>
                
                <div style='width:100%; height: 150px; margin-top:25px;'>
                    <h4>Description</h4>
                    Descripcion y más detalles del vehículo
                </div>
                <div id='footBar' style='width:100%; height:auto;'>
                </div>
            </div> 
            <div id='contactBox' style='float:left; width: 275px; height:100%; margin-left: 20px; border-left: 2px solid gray;'>
                <div id='contactInfo' style='width: 100%; height: auto; margin-top: 10px;'>
                    <form action='ControllerServlet' method='POST'>
                        <div style='margin-left: 10px; margin-top: 20px;'>
                            <h2>Contact the Advertiser</h2>
                            Name: <br>
                            <input id='contactName' type='text'>
                        </div>
                        <div style='margin-left: 10px; margin-top: 20px;'>
                            Message:<br>
                            <input id='message' type='textarea' maxlength='250' style='height: 100px; width: 240px;'>
                        </div>
                        <div style='margin-left: 10px; margin-top: 20px;'>
                            E-mail:<br>
                            <input id='contactEmail' type='text'>
                        </div>
                        <div id='submitMessage' style='width: 100%; margin-top: 25px;'>
                            <input id='submitMessageButton' type='Submit' value='Send Message' style='margin-left: auto; margin-right: auto; display:block;'>
                        </div>
                    </form>
                </div>
            </div>
       </div>
    </div>

</div>
<%@include file='footer.jsp' %>