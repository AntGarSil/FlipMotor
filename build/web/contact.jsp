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
                    <h3>FlipMotor S.A</h3>
                    <div style="width:80%; height: 300px; margin-top:25px;">
                        FlipMotor S.A is a spanish leader company in second hand vehicle selling providing customers with valuable, convenient, relevant and trustable online advertisements.
                        The main orientation of the company is providing our clients a tool to announce their vehicles so that their offers are accessible to anyone, making easier for them
                        the task of finding a buyer.

                        <h4>What makes the difference</h4>
                        Although there are many pages among the World Wide Web providing similar services, FlipMotor guarantees best rate offers and assure prioritized search positioning in
                        main web search engines.
                    </div>
                </div>
                <div style="float:left; width: 40%; height:100%">
                    <div id="contactMap" style="width: 100%; height: 70%; background-color: red;">
                        <img src="images/contactMap.png" alt="Map" style="width:100%; height: 100%;">
                    </div>
                    <div id="contactInfo" style="width: 100%; height: auto; margin-top: 10px;">
                        <h4>Contact</h4> <br>
                        Address:  Calle de Faraday 12, Madrid<br>
                        E-mail: contact@flipmotor.com <br>
                        Phone: 912345678
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>