/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    $( "#check" ).button().click(function() {
        var display = document.getElementById("resizable");
        var size = parseInt(display.style.width.toString().split("px")[0])
        if(isNaN(size)||size==0){
            display.style.visibility = "visible"
            display.style.width = 300 + "px"
        }else{
            display.style.width = 0 + "px"
            display.style.visibility = "hidden";
            
        }
    });
    
});
$(function() {
    $( "#help" ).button({
        icons: {
            primary: "ui-icon-lightbulb"
        },
        text:false
    });
});

$(function(){
$( "#dialog" ).dialog({
    autoOpen: false,
    show: {
        effect: "blind",
        duration: 1000
    },
    hide: {
        effect: "explode",
        duration: 1000
    }
});

$( "#help" ).click(function() {
      $( "#dialog" ).dialog( "open" );
      
      sleep(4000);
    });
});

