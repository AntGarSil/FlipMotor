
        <%@include file="header.jsp" %>
        <script>//Initialize slider
        $(document).ready(function() {
            $('#slider1').s3Slider({
                timeOut: 5000
            });

        });
        </script>
        <div id="bodycontent">
        <div id="slider1">
            <ul id="slider1Content">
                <li class="slider1Image">
                    <img src="images/2012-avenger-sedan-720x300_01.jpg" alt="1" />
                    <span class="left"><strong>Second Hand Vehicles</strong><br />Large amount of second hand vehicles just waiting to be purchased</span></li>
                <li class="slider1Image">
                    <img src="images/scaledbike.gif" alt="2" />
                    <span class="right"><strong>All your motorbikes</strong><br />Don't hesitate in finding the bike thats better for you in Flipmotor!</span></li>
                <li class="slider1Image">
                    <img src="images/Star-Trek-700x300.jpg" alt="3" />
                    <span class="right"><strong>Afraid of Hackers?</strong><br />In Flipmotor all transactions are made with a direct customer-client relationship. Don't give the geeks any unnecessary info!! </span></li>
                <li class="slider1Image">
                    <img src="images/4.jpg" alt="4" />
                    <span class="left"><strong>Best Quality</strong><br />Our advertisements are moderated by administrators that guarantee the quality of the products.</span></li>
                <div class="clear slider1Image"></div>
            </ul>
        </div>
            <div id="photoWrapper" style="min-width: 950px; padding-bottom: 10px;">
                <form action="Cars" method="POST">                   
                        <div class="firstFrameWrapper">
                        <!-- image -->
                        <input alt="Vehicles" type="image" src="images/scaledvolksvagen.gif" />
                        <!-- description div -->
                        <div class="description">
                                <!-- description content -->
                                <p class="description_content">Second hand cars</p>
                                <!-- end description content -->
                        </div>
                        <!-- end description div -->
                        </div>
                </form>
                
                <form action="Motorbikes" method="POST">
                <%-- <a href="query.jsp?search=mot"> --%>
                 <div class="genFrameWrapper">
                    <!-- image -->
                    <input alt="Motorbikes" type="image" src="images/scaledmotos_suzuki_026.gif" />                    
                    <!-- description div -->
                    <div class="description">
                            <!-- description content -->
                            <p class="description_content">Second hand motorbikes</p>
                            <!-- end description content -->
                    </div>
                    <!-- end description div -->
                </div>
                <%-- </a> --%>
                </form>
                
                
                <%-- <a href="query.jsp?search=gen"> --%>
                <form action="General" method="POST">
            <div class="genFrameWrapper">
                    <!-- image -->                    
                    <input alt="General" type="image" src="images/scaledengranajes.gif" />                    
                    <!-- description div -->
                    <div class="description">
                            <!-- description content -->
                            <p class="description_content">General</p>
                            <!-- end description content -->
                    </div>
                    <!-- end description div -->
            </div>
                </form>
               <%-- </a> --%>
            </div>
        </div>
  <%@include file="footer.jsp" %>        
    
