/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function init(){
    var value = getCookie("zoom");
    var zoom = 1;
    if(value!=null){
        zoom = parseFloat(value);
    }
        return zoom
    
}

function restoreDefault(){
    document.body.style.zoom = 1.0;
    zoom = 1.0;
    document.location.href  = "StoreZoom?zoom=1.0";
    
}

function getCookie(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
{
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  if (x==c_name)
    {
    return unescape(y);
    }
  }
}

$(function(){   
    $( "#slider" ).slider({ 
        value: init()*100, 
        min: 50,
        max:200,
        slide:function(event,ui){
            var num = ui.value/100;
            document.body.style.zoom=num;
        }
    });
});
 
$(function() {
    $( "#store" )
    .button()
    .click(function() {
        if(document.location.href!=null){
            document.location.href  = "StoreZoom?zoom=" + document.body.style.zoom;
        }
    })
    .next()
    .button({
        text: false,
        icons: {
            primary: "ui-icon-triangle-1-s"
        }
    })
    .click(function() {
        var menu = $( this ).parent().next().show().position({
            my: "left top",
            at: "left bottom",
            of: this
        });
        $( document ).one( "click", function() {
            menu.hide();
        });
        return false;
    })
    .parent()
    .buttonset()
    .next()
    .hide()
    .menu();
});