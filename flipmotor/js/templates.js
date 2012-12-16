$(document).ready(function() {
    $('#loginButtonId').click(function(e) {
         $('#loginpopup').lightbox_me({
        centered: true, 
        //showOverlay: false,
        onLoad: function() { 
            $('#loginpopup').find('input:first').focus()
            }
        });
    });
});

$(document).ready(function() {
    $('#closeLoginPopup').click(function(e) {
        $('#loginpopup').trigger('close');
    });
});

$(document).ready(function() {
    $('#adminButtonId').click(function(e) {
         $('#adminpopup').lightbox_me({
        centered: true, 
        //showOverlay: false,
        onLoad: function() { 
            $('#adminpopup').find('input:first').focus()
            }
        });
    });
});
