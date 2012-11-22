<%@include file="header.jsp" %>
<!--<script src="js/register_jq.js" type="text/javascript"></script>-->
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/register.js" type="text/javascript"></script>
<script src="js/jquery.validate.password.js" type="text/javascript"></script>
<div id="bodyContent" style="margin-top: 10px;">


<!--<link rel="stylesheet" type="text/css" media="screen" href="style/register_jquery.css" />
<link rel="stylesheet" type="text/css" href="style/register.css"/>
<link rel="stylesheet" type="text/css" href="style/questionmark.css"/>
<script src="js/register_jq.js" type="text/javascript"></script>
<script src="js/jquery-ui.min.js" type="text/javascript"></script>-->


	<div id="tabs" style="width: 90%; height: 500px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;" >
		<ul>
			<li><a href="#vehicles">Vehicles</a></li>
			<li><a href="#general">General</a></li>
		</ul>

		<div id="vehicles" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:420px; margin-bottom: 20px;">
                    <div id="vehicleContainer" style="overflow: auto; height: 100%;" class="tableWrapper">
                    <form id="postVehicle" method="post" action="Controller">
			<p>
				<label for="phone">Phone</label>
				<input id="phone" name="phone" class="required" minlength="9" maxlength="13" type="number" />
			</p>
			<p>
				<label for="name">Contact name</label>
				<input id="name" name="name" class="required" minlength="3" maxlength="20" type="text" />
			</p>
			<p id="vehicle">
				<label for="vehicle">Vehicle</label>
				<select id="vehicle" name="vehicle" class="required">
					<option value="">Car</option>
					<option>Motorbike</option>
				</select>
			</p>
			<p id="fee">
				<label for="fee">Ad fee</label>
				<select id="fee" name="fee" class="required">
					<option value="">Normal</option>
					<option>Medium</option>
					<option>Extra</option>
				</select>
				<a class="Ntooltip">
					<image src="images/interrogacion.jpeg" width="15" height="15"/>
						<span>
							Current fees <br/><br/>	Normal: 20&euro; for at least 1month<br /> Medium: 16&euro;/month for at least 2months <br /> Extra: 8&euro;/month for at least 3months
						</span>
					</image>
				</a>
			</p>
			<p>
				<label for="year">Year</label>
				<input id="year" name="year" class="required" minlength="4" maxlength="4" type="number" />
			</p>
			<p>
				<label for="kilometers">Kilometers</label>
				<input id="kilometers" name="kilometers" class="required" minlength="1" maxlength="7" type="number" />
			</p>
			<p>
				<label for="price">Price</label>
				<input id="price" name="price" class="required" minlength="1" maxlength="7" type="number" />
			</p>
			<p>
				<label for="description">Description</label>
				<input id="description" name="description" class="required" minlength="1" maxlength="300" type="text" />
			</p>
			<p>
				<label for="brand">Brand</label>
				<input id="brand" name="brand" class="required" minlength="2" maxlength="20" type="text" />
			</p>
			<p>
				<label for="color">Color</label>
				<input id="color" name="color" class="required" minlength="2" maxlength="20" type="text" />
			</p>
			<p>
				<label for="email">Email address</label>
				<input id="email" name="email" class="required email" type="text" />
			</p>
			
			<p>
				<label for="image">Image</label>
				<input type="button" value="Browse" onclick="Image()">
			</p>
			<p>
				<label for="terms"><a href="/termsandconditions.jsp" target="_blank">Terms and conditions</a></label>
				<input id="terms" name="terms" class="required" type="checkbox" />
			</p>
			<div id="submitPanel" style="float: left; width: 100%; margin-top: 5px;">
                            <input type="submit" value="Post Vehicle" onclick="window.location='/src/java/controller/UserProfileController.java';" style="margin-left: auto; margin-right: auto; display:block;">
            </div>
			</form>
                    </div>
		</div>
		<div id="general" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:480px; margin-bottom: 20px;">
                    <div id="generalContainer" style="overflow: auto; height: 100%;" class="tableWrapper">
                        <form id="postGeneral" method="post" action="Controller">
			<p>
				<label for="sector">Sector</label>
				<input id="sector" name="sector" class="required" type="text" />
			</p>
			<p>
				<label for="business">Business</label>
				<input id="business" name="business" class="required" type="text" />
			</p>
			<p>
				<label for="text">Text</label>
				<input name="text" class="required" type="text"  />
			</p>
			<p>
				<label for="image">Image</label>
				<input type="button" value="Browse" class="required" onclick="Image()">
			</p>
			<p>
				<label for="terms"><a href="/termsandconditions.jsp" target="_blank">Terms and conditions</a></label>
				<input id="terms" name="terms" class="required" type="checkbox" />
			</p>
			<div id="submitPanel" style="float: left; width: 100%; margin-top: 5px;">
                            <input type="submit" value="Post General" onclick="window.location='/src/java/controller/UserProfileController.java';" style="margin-left: auto; margin-right: auto; display:block;">
            </div>
			</form>
                    </div>
		</div>
	</div>

</div>
<%@include file="footer.jsp" %>