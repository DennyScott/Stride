
window.onload = init;

function init(){
    var count = document.getElementsByClassName("mini-counts");
    var prefix = document.getElementsByClassName("prefix");
    
	
    for (var i = 0; i < count.length; i++) {
        if(count[i].innerHTML >= 1000)
        {
            prefix[i].innerHTML = "K " + prefix[i].innerHTML;
            count[i].innerHTML = count[i].innerHTML/1000;
        }
    }
}
