<%@include file="header.jsp" %>
<div id="bodyContent">
<script>
    $('#tabs').ready(function(){
        $('#tabs').tabs();
        $('#posted').tablesorter();
        $('#editProfileButton').click(function() {
            $('#rightProfilePanel').toggle();
        });
    });
</script>
            <div id='bodycontent' style='margin-top: 10px;'>
                 <div id='tabs' class='tabs'  style='width: 90%; height: 500px; margin: auto; font-size: 12px; border: 2px solid grey; padding: 3px;
                     -moz-border-radius: 5px; -webkit-border-radius: 5px; -khtml-border-radius: 5px;' >
                      <ul>
                          <li><a href='#tabs-1'>Profile</a></li>
                          <li><a href='#tabs-2'>Advertisements</a></li>
                      </ul>
            <div id='tabs-1' class='tabs-1'>
                    <div id="leftProfilePanel" style="float:left; width: 50%;">
                        <div style="float:left; width: 100%; height: 390px; margin: 0px 10px 10px;">
                            <h4>Profile</h4>
				<label for="name">Name</label>
				<input id="name" name="name" class="required" minlength="1" maxlength="30" type="text" />


                                <label for="surname">Surname</label>
                                <input id="surname" name="surname" class="required" minlength="1" maxlength="30" type="text" /><br>


                                <label for="nif">NIF</label>
                                <input id="nif" name="nif" class="required" minlength="8" maxlength="9" type="password" />



                                <label for="phone">Phone</label>
                                <input id="phone" name="phone" class="required" minlength="9" maxlength="13" type="number" /><br>


                                <label for="email">Email address</label>
                                <input id="email" name="email" class="required email" type="text"  style="width:200px"/><br>


                                <label for="card">Credit card</label>
                                <input id="card" name="card" class="required" minlength="20" maxlength="20" type="number"  style="width:200px"/><br>


				<h4>Address</h4>


                                Street:
                                <input id="street" name="street" class="required" minlength="1" maxlength="30" type="text" />


                                Number:
                                <input id="number" name="number" class="required" minlength="1" maxlength="5" type="number" style="width:20px; margin-right: 20px;"/>


                                Flat:
                                <input id="flat" name="flat" class="required" minlength="1" maxlength="2" type="number"  style="width:20px; margin-right: 20px;"/>


                                Letter:
                                <input id="leter" name="leter" class="required" minlength="1" maxlength="2" type="text"  style="width:20px; margin-right: 20px;"/><br>


                                PC:
                                <input id="pc" name="pc" class="required" minlength="3" maxlength="7" type="number"  style="width:40px; margin-right: 20px;"/>


                                City:
                                <input id="city" name="city" class="required" minlength="1" maxlength="30" type="text" style="margin-right: 20px;" />


                                Province:
                                <input id="province" name="province" class="required" minlength="1" maxlength="30" type="text" style="margin-right: 20px;"/>

                        </div>
                         
                         <div id="submitProfile" style="float: left; width: 100%; margin-top: 5px;">
                            <input type="button" id="editProfileButton" value="Edit Profile" style="margin-left: auto; margin-right: auto; display:block;">
                         </div>
                    </div>
                    <div id="rightProfilePanel" style="float:left; width: 49%; display: none; border-left: 1px gray solid;">
                        <form id="editedProfile" method="POST" action="Controller">
                            <div style="float:left; width: 100%; height: 390px; margin: 0px 10px 10px;">
                                <h4>Edit your Profile here:</h4>
				<label for="name">Name</label>
				<input id="name" name="name" class="required" minlength="1" maxlength="30" type="text" />
                            

                                <label for="surname">Surname</label>
                                <input id="surname" name="surname" class="required" minlength="1" maxlength="30" type="text" /><br>


                                <label for="nif">NIF</label>
                                <input id="nif" name="nif" class="required" minlength="8" maxlength="9" type="password" />



                                <label for="phone">Phone</label>
                                <input id="phone" name="phone" class="required" minlength="9" maxlength="13" type="number" /><br>


                                <label for="email">Email address</label>
                                <input id="email" name="email" class="required email" type="text"  style="width:200px"/><br>


                                <label for="card">Credit card</label>
                                <input id="card" name="card" class="required" minlength="20" maxlength="20" type="number"  style="width:200px"/><br>
                            
                             
				<h4>Address</h4>
                            

                                Street: 
                                <input id="street" name="street" class="required" minlength="1" maxlength="30" type="text" />


                                Number:
                                <input id="number" name="number" class="required" minlength="1" maxlength="5" type="number" style="width:20px; margin-right: 20px;"/>


                                Flat:
                                <input id="flat" name="flat" class="required" minlength="1" maxlength="2" type="number"  style="width:20px; margin-right: 20px;"/>


                                Letter:
                                <input id="leter" name="leter" class="required" minlength="1" maxlength="2" type="text"  style="width:20px; margin-right: 20px;"/><br>


                                PC: 
                                <input id="pc" name="pc" class="required" minlength="3" maxlength="7" type="number"  style="width:40px; margin-right: 20px;"/>


                                City:
                                <input id="city" name="city" class="required" minlength="1" maxlength="30" type="text" style="margin-right: 20px;" />


                                Province: 
                                <input id="province" name="province" class="required" minlength="1" maxlength="30" type="text" style="margin-right: 20px;"/>

                                <h4>New password</h4>
                                <label for="password">Password</label>
                                <input name="password" id="password" type="password" class="required" minlength="4" maxlength="50" />

                                <div class="password-meter">
                                        <div class="password-meter-message"> </div>
                                        <div class="password-meter-bg">
                                                <div class="password-meter-bar"></div>
                                        </div>
                                </div>
                                    <label for="confirmpassword">Confirm Password</label>
                                    <input name="confirmpassword" type="password" class="required" equalTo="#password" id="confirmpassword" />
                           </div>
                           <div id="submitProfile" style="float: left; width: 100%; margin-top: 5px;">
                                <input type="submit" id="saveProfileChanges" value="Save Changes" style="margin-left: auto; margin-right: auto; display:block;">
                           </div>
                        </form>
                    </div>
            </div>

            <div id='tabs-2' class='tabs-1'>
                <div id="tableContainer" style="float: left;" class="tableWrapper">
                <table id="postedAds" style="float:left;" class="tablesorter">
                    <thead style="display: block;">
                           <tr><th style='width:300px;'>Date</th><th style='width:280px;'>Brand and Model</th><th style='width:200px;'>Vehicle</th><th style='width:80px;'>Delete Ad</th><th style='width:80px;'>Edit Ad</th></tr>
                    </thead>
                    <tbody style="overflow: auto; display: block; height: 400px;">
                        <tr><td style="width:305px;">20/10/12</td><td style="width:200px">BMW</td><td style="width:200px;">Motorbike</td><td style="width:80px;"><input type="button" value="Delete Ad"></td><td style="width:70px;"><input type="button" value="Edit Ad"></tr>
                        <tr><td>20/10/12</td><td style="width:280px">BMW</td><td>Motorbike</td><td><input type="button" value="Delete Ad"></td><td><input type="button" value="Edit Ad"></tr>
                        <tr><td>20/10/12</td><td style="width:280px">BMW</td><td>Motorbike</td><td><input type="button" value="Delete Ad"></td><td><input type="button" value="Edit Ad"></tr>
                        <tr><td>20/10/12</td><td style="width:280px">BMW</td><td>Motorbike</td><td><input type="button" value="Delete Ad"></td><td><input type="button" value="Edit Ad"></tr>
                        <tr><td>20/10/12</td><td style="width:280px">BMW</td><td>Motorbike</td><td><input type="button" value="Delete Ad"></td><td><input type="button" value="Edit Ad"></tr>
                        <tr><td>20/10/12</td><td style="width:280px">BMW</td><td>Motorbike</td><td><input type="button" value="Delete Ad"></td><td><input type="button" value="Edit Ad"></tr>
                        <tr><td>20/10/12</td><td style="width:280px">BMW</td><td>Motorbike</td><td><input type="button" value="Delete Ad"></td><td><input type="button" value="Edit Ad"></tr>
                        
                    </tbody>
                </table>
                </div>
             </div>
         </div>
     </div>

</div>
<%@include file="footer.jsp" %>

