<%@include file="header.jsp" %>
<!--<script src="js/register_jq.js" type="text/javascript"></script>-->
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/register.js" type="text/javascript"></script>
<script type="text/javascript">

function register_Validator(theForm)
{
	
   		var nowDate = new Date();		
  		var nowYear = nowDate.getFullYear();	 
   		var nowMonth = nowDate.getMonth() + 1;
   		var expYear = theForm.cboExpYear.options[theForm.cboExpYear.selectedIndex].value;
  		var expMonth = theForm.cboExpMonth.options[theForm.cboExpMonth.selectedIndex].value;
		
		if ((12 == expYear)&&(12 > expMonth))
		{
  		 alert("expire date can't be in the past!");
   		return false;
		}		
}

</script>
<div id="bodyContent">



	<div id="tabs" style="width: 90%; height: 400px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
    -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;" >
		<ul>
			<li><a href="#payment">Payment</a></li>
		</ul>
		<div id="payment" style="-webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 20px; height:480px; margin-bottom: 20px;">
                    <form id="clientSignUp" method="POST" action="PaymentAction" onsubmit="return register_Validator(this)">
                        <div id="leftPanel" style="float: left; width: 50%;">
                            <p>
				<label for="card">Credit Card</label>
				<input id="card" name="card" class="required" minlength="16" maxlength="16" type="number" />
                            </p><p><b>Expiry Date</b></br>
                                   Month:<SELECT NAME="cboExpMonth" SIZE="1">

                                        <option VALUE="00" selected></option>
                                                <OPTION VALUE="01">01</OPTION>
                                                <OPTION VALUE="02">02</OPTION>
                                                 <OPTION VALUE="03">03</OPTION>
                                                <OPTION VALUE="04">04</OPTION>
                                                <OPTION VALUE="05">05</OPTION>
                                                <OPTION VALUE="06">06</OPTION>
                                                <OPTION VALUE="07">07</OPTION>
                                                <OPTION VALUE="08">08</OPTION>
                                                <OPTION VALUE="09">09</OPTION>
                                                <OPTION VALUE="10">10</OPTION>
                                                <OPTION VALUE="11">11</OPTION>
                                                <OPTION VALUE="12">12</OPTION>
                                         </SELECT>

                                Year:    <SELECT NAME="cboExpYear" SIZE="1">		

                                                <option VALUE="00" selected></option>
                                                        <OPTION VALUE="12">12</OPTION>
                                                        <OPTION VALUE="13">13</OPTION>
                                                <OPTION VALUE="14">14</OPTION>
                                                <OPTION VALUE="15">15</OPTION>
                                                <OPTION VALUE="16">16</OPTION>
                                                <OPTION VALUE="17">17</OPTION>
                                         </SELECT>
                        </div>
                        
                        <div id="submitPanel" style="float: left; width: 100%; margin-top: 5px;">
                            <input type="submit" value="Pay" style="margin-left: auto; margin-right: auto; display:block;" />
                        </div>
                        
                    </form>
		</div>
		
	</div>
</div>
<%@include file="footer.jsp" %>