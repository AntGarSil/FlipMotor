<%@include file="header.jsp" %>
<script>
        $('#contactContainer').ready(function(){
           $('#contactContainer').tabs();
        });
</script>
<div id="bodycontent" style="margin-top: 10px;">
    <div id="contactContainer" style="width: 90%; height: 500px;  margin: auto; border: 2px solid grey; padding: 3px; margin-top: 5px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px; font-size: 12px;">
            <ul>
                <li><a href="#tabs-1">About Us</a></li>
            </ul>
        <div id="tabs-1" class="tableWrapper" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:410px; margin-bottom: 20px;">
            <div id="contactWrapper" style="overflow: auto; height: 100%; padding: 10px;" class="tableWrapper">
                <div id="Description" style="float:left; width: 55%; height:100%;">
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
                </div>
                <div style="float:left; width: 40%; height:100%">
                    <div id="contactMap" style="width: 100%; height: 70%; background-color: red;">
                        Photo
                        <img src="" alt="Map">
                    </div>
                    <div id="contactInfo" style="width: 100%; height: auto; margin-top: 10px;">
                        Contact <br>
                        Name: Perico <br>
                        E-mail: cuchuflete@oletuscohones.com <br>
                        Phone: 123456789
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>