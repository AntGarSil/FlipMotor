<%@include file="header.jsp" %>
<!--<script src="js/register_jq.js" type="text/javascript"></script>-->
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/register.js" type="text/javascript"></script>
<script src="js/jquery.validate.password.js" type="text/javascript"></script>
<div id="bodyContent" style="margin-top: 10px;">




	<div id="tabs" style="width: 90%; height: 500px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;" >
		<ul>
			<li><a href="#receipt">Receipt</a></li>
		</ul>

		<div id="receipt" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:420px; margin-bottom: 20px;">
                    <div id="vehicleContainer" style="overflow: auto; height: 100%;" class="tableWrapper">
                    <form id="receipt" method="POST" action="DetailsAction">
			<p>
				<label for="offer">Offer Code</label>
				<input id="offer" name="offer" class="required" minlength="1" maxlength="10" type="number" />
			</p>
			
			<div id="submitPanel" style="float: left; width: 100%; margin-top: 5px;">
                            <input type="submit" value="Confirm" style="margin-left: auto; margin-right: auto; display:block;">
            </div>
			</form>
                    </div>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
