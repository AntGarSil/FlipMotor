/***************************************************************************************
*   Maria 100291452
**************************************************************************************** */


// Checks every possible field and take actions according to the requirements

function Validate() {

	// Checks if the NAME introduced are correct using a regex
	var regex = /^[a-zA-z]+$/;
	var name = document.formulario.name.value;
	var lastname = document.formulario.lastname.value;

	if(regex.test(name) == false) {
		document.getElementById('name').style.color = 'red';
	}

	// Checks if the YEAR introduced is correct using a regex
	// We do not allow people from the year 3000
	var regex = /^[0-2][0-9][0-9][0-9]$/;
	var year = document.formulario.year.value;

	if(regex.test(year) == false) {
		document.getElementById('year').style.color = 'red';
	}

	// Checks if the E-MAIL introduced is correct using a regex
	var regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var address = document.formulario.email.value;

	if(regex.test(address) == false) {
		document.getElementById('email').style.color = 'black';
		document.getElementById('email').style.fontStyle = 'italic';
	}

	// Checks if the NUMBER introduced is correct using a regex
	var regex = /^[0-9][0-9][0-9] [0-9][0-9][0-9] [0-9][0-9][0-9]$/;
	var number = document.formulario.phone.value;

	if(regex.test(number) == false) {
		document.getElementById('phone').style.color = 'black';
		document.getElementById('phone').style.fontStyle = 'italic';
	}
	
	//kilometers and price
	var regex = /^[0-9]+$/; //at least one
	var kilometers = document.formulario.kilometers.value;
	var price = document.formulario.price.value;

	if(regex.test(kilometers) == false) {
		document.getElementById('kilometers').style.color = 'red';
	}
	
	if(regex.test(price) == false) {
		document.getElementById('price').style.color = 'red';
	}
	

	// Checks if there is a VEHICLE selected

	if ( document.formulario.vehicle.selectedIndex == 0 ){
		 document.getElementById('vehicle').style.color = 'red';
   }

	// Checks if there is a FEE selected

	if ( document.formulario.fee.selectedIndex == 0 ){
		 document.getElementById('feeT').style.color = 'red';
   }
 


}





