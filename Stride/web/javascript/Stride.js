/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function setbg(color)
{
    document.getElementById("styled").style.background=color
}

function questionComment(questionID){
    var comment = document.getElementById("addQuestionComment");
    

    comment.style.width=100+"%";
    
    comment.innerHTML= "<form method=\"POST\" action=\"home?id="+questionID+"&questionComment=true\"><table><tbody><tr><td>\
<textarea name=\"qComment\" cols=\"68\" rows=\"3\"> </textarea>\n\
</td><td><input tabindex=\"0\" type=\"submit\" value=\"Add Comment\"></td></tr></tbody></table></form>";
    comment.onclick="";
}

function answerComment(questionID,spot){
    var comment = document.getElementById("answerComment-"+spot);
    

    comment.style.width=100+"%";
    
    comment.innerHTML= "<form method=\"POST\" action=\"home?id="+questionID+"&answer="+spot+"&answerComment=true\"><table><tbody><tr><td>\
<textarea name=\"aComment"+spot+"\" cols=\"68\" rows=\"3\"> </textarea>\n\
</td><td><input tabindex=\"0\" type=\"submit\" value=\"Add Comment\"></td></tr></tbody></table></form>";
    comment.onclick="";
}

function getFile(){
    var file = document.getElementById("profilePic");
    file.click();
}

function silverClick(){
    var gold = document.getElementById("GoldBadge");
    var silver = document.getElementById("SilverBadge");
    var bronze = document.getElementById("BronzeBadge");
    
    silver.className = "youarehere";
    gold.className = "otherTab";
    bronze.className = "otherTab";
}
function goldClick(){
    var gold = document.getElementById("GoldBadge");
    var silver = document.getElementById("SilverBadge");
    var bronze = document.getElementById("BronzeBadge");
    
    silver.className = "otherTab";
    gold.className = "youarehere";
    bronze.className = "otherTab";
}
function bronzeClick(){
    var gold = document.getElementById("GoldBadge");
    var silver = document.getElementById("SilverBadge");
    var bronze = document.getElementById("BronzeBadge");
    
    silver.className = "otherTab";
    gold.className = "otherTab";
    bronze.className = "youarehere";
}

function collectData(){
    
    
    }
    
    


function collectTagID(){
    //Get Tags
    var tags = document.getElementsByName("tagList")
    var tagId = new Array();
    var tagNames = new Array();
    
    for (var i = 0; i<tags.length; i++){
       tagId[i] = tags.item(i).toString().split("id=")[1];
       tagNames[i]=tags[i].innerHTML;
    }
}

function collectTagNames(){
     var tagNames = new Array();
    
    for (var i = 0; i<tags.length; i++){
       tagNames[i]=tags[i].innerHTML;
    }
    
    return tagNames;
}
