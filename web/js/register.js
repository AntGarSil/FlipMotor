$("#tabs").ready(function() {
	$("#tabs").tabs();
	$("#clientSignUp").validate({
		groups: {
			birthdate: "birthdateDay birthdateMonth birthdateYear"
		},
		errorPlacement: function(label, element) {
			if (/^birthdate/.test(element[0].name)) {
				label.insertAfter("#birthdateYear");
			} else {
				label.insertAfter(element);
			}
		}
	});
        $("#adminSignUp").validate({
		groups: {
			birthdate: "birthdateDay birthdateMonth birthdateYear"
		},
		errorPlacement: function(label, element) {
			if (/^birthdate/.test(element[0].name)) {
				label.insertAfter("#birthdateYear");
			} else {
				label.insertAfter(element);
			}
		}
	});
        //$("#register").validate();
	/*
	// validate the other two selects when one changes to update the whole group
	var birthdaySelects = $("#birthdateGroup select").click(function() {
		birthdaySelects.not(this).valid();
	})
	
	// overwrite focusInvalid to activate tab with invalid elements
	validator.focusInvalid = function() {
		if( this.settings.focusInvalid ) {
			try {
				var focused = $(this.findLastActive() || this.errorList.length && this.errorList[0].element || []).filter(":visible");
				tabs.tabs("select", tabs.find(">div").index(focused.parent().parent()));
				focused.focus();
			} catch(e) {
				// ignore IE throwing errors when focusing hidden elements
			}
		}
	};*/
});