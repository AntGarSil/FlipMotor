/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$('#tabs').ready(function(){
       $('#tabs').tabs();
});

            $('#row1').click(function(){
                 $('#dialog').dialog('open');
                 return false;
            });