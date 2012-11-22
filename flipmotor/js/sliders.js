/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('#advSearchButton').click(function (){
        $('#advSearchBox').toggle();
    });
    $('#closeSearchButton').click(function (){
        $('#advSearchBox').toggle();
    });
});

$(document).ready(function() {
    $( "#price-range" ).slider({
        range: true,
        min: 0,
        max: 20000,
        values: [ 0, 20000 ],
        slide: function( event, ui ) {
            $( "#price" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
        }
    });
    $( "#price" ).val( "$" + $( "#price-range" ).slider( "values", 0 ) +
        " - $" + $( "#price-range" ).slider( "values", 1 ) );
    });

    $(document).ready(function() {
    $( "#km-range" ).slider({
        range: true,
        min: 0,
        max: 200000,
        values: [ 0, 200000 ],
        slide: function( event, ui ) {
            $( "#km" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
        }
    });
    $( "#km" ).val( "$" + $( "#km-range" ).slider( "values", 0 ) +
        " - $" + $( "#km-range" ).slider( "values", 1 ) );
    });

   $(document).ready(function() {
    $( "#year-range" ).slider({
        range: true,
        min: 1960,
        max: 2012,
        values: [ 1960, 2012 ],
        slide: function( event, ui ) {
            $( "#year" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
        }
    });
    $( "#year" ).val( "$" + $( "#year-range" ).slider( "values", 0 ) +
        " - $" + $( "#year-range" ).slider( "values", 1 ) );
    });
    
    $(document).ready(function() {
        $( "#postDate" ).datepicker();
    });