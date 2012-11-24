<%@include file="header.jsp" %>
<!--<script src="js/register_jq.js" type="text/javascript"></script>-->
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/register.js" type="text/javascript"></script>
<!--<script src="js/jquery.validate.password.js" type="text/javascript"></script> -->
<div id="bodyContent">



	<div id="tabs" style="width: 90%; height: 500px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;" >
		<ul>
			<li><a href="#client">Client</a></li>
		</ul>
		<div id="client" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:480px; margin-bottom: 20px;">
                    <form id="clientSignUp" method="POST" action="RegisterAction">
                        <div id="leftPanel" style="float: left; width: 50%;">
                            <p>
				<label for="name">Name</label>
				<input id="name" name="name" class="required" minlength="1" maxlength="30" type="text" />
                            </p>
                            <p>
                                    <label for="surname">Surname</label>
                                    <input id="surname" name="surname" class="required" minlength="1" maxlength="30" type="text" />
                            </p>
                            <p>
                                    <label for="nif">NIF</label>
                                    <input id="nif" name="nif" class="required" minlength="8" maxlength="9" type="text" />
                            </p>

                            <p>
                                    <label for="phone">Phone</label>
                                    <input id="phone" name="phone" class="required" minlength="9" maxlength="13" type="number" />
                            </p>
                            <p>
                                    <label for="email">Email address</label>
                                    <input id="email" name="email" class="required email" type="text" />
                            </p>
                            <p>
                                    <label for="card">Credit card</label>
                                    <input id="card" name="card" class="required" minlength="16" maxlength="16" type="number" />
                            </p>
                            <p>

                                <label for="password">Password</label>
                                <input name="password" id="password" type="password" class="required" minlength="4" maxlength="50" />

                                <div class="password-meter">
                                        <div class="password-meter-message"> </div>
                                        <div class="password-meter-bg">
                                                <div class="password-meter-bar"></div>
                                        </div>
                                </div>
                            </p>
                            <p>
                                    <label for="confirmpassword">Confirm Password</label>
                                    <input name="confirmpassword" type="password" class="required" equalTo="#password" id="confirmpassword" />
                            </p>
                        </div>
                        <div id="rightPanel" style="float: left; width: 50%;">
                            <p>
				<h4>Address</h4>
                            </p>
                            <p>
                                    <label for="street">Street</label>
                                    <input id="street" name="street" class="required" minlength="1" maxlength="30" type="text" />
                            </p>
                            <p>
                                    <label for="number">Number</label>
                                    <input id="number" name="number" class="required" minlength="1" maxlength="5" type="number" />
                            </p>
                            <p>
                                    <label for="flat">Flat</label>
                                    <input id="flat" name="flat" class="required" minlength="1" maxlength="2" type="number" />
                            </p>
                            <p>
                                    <label for="letter">Letter</label>
                                    <input id="leter" name="leter" class="required" minlength="1" maxlength="2" type="text" />
                            </p>
                            <p>
                                    <label for="pc">PC</label>
                                    <input id="pc" name="pc" class="required" minlength="3" maxlength="7" type="number" />
                            </p>
                            <p>
                                    <label for="city">City</label>
                                    <input id="city" name="city" class="required" minlength="1" maxlength="30" type="text" />
                            </p>
                            <p>
                                    <label for="province">Province</label>
                                    <input id="province" name="province" class="required" minlength="1" maxlength="30" type="text" />
                            </p>
                            <p>
                                    <label for="terms"><a href="/legal.jsp" target="_blank">Terms and conditions</a></label>
                                    <input id="terms" name="terms" class="required" type="checkbox" />
                            </p>
                        </div>
                        <div id="submitPanel" style="float: left; width: 100%; margin-top: 5px;">
                            <input type="submit" value="Sign Up" style="margin-left: auto; margin-right: auto; display:block;" />
                        </div>
                        
                    </form>
		</div>
		
	</div>
</div>
<%@include file="footer.jsp" %>