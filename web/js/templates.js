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



