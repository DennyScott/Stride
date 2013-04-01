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
    var gold = document.getElementById("firstTab");
    var silver = document.getElementById("secondTab");
    var bronze = document.getElementById("thirdTab");
    
    silver.className = "youarehere";
    gold.className = "otherTab";
    bronze.className = "otherTab";
}
function goldClick(){
    var gold = document.getElementById("firstTab");
    var silver = document.getElementById("secondTab");
    var bronze = document.getElementById("thirdTab");
    
    silver.className = "otherTab";
    gold.className = "youarehere";
    bronze.className = "otherTab";
}
function bronzeClick(){
    var gold = document.getElementById("firstTab");
    var silver = document.getElementById("secondTab");
    var bronze = document.getElementById("thirdTab");
    
    silver.className = "otherTab";
    gold.className = "otherTab";
    bronze.className = "youarehere";
}

function collectData(){
    
    var tagsID = collectTagID();
    var questionID = collectQuestionID();
    var courseID = collectCourseID();
    var userID = collectUserID();
   
    var id = questionID.item(0).toString().split("id=")[1];
    document.location.href  = "QuestionCookie?id=" + id;
    
}


function setZoom(){
    var cookie = getCookie("zoom");
    if(cookie!=null){
        var num = parseFloat(cookie);
           document.body.style.zoom = num;
    }
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

function collectQuestionID(){
    return document.getElementsByName("questionID");
}

function collectUserID(){
    return document.getElementsByName("userID");
}

function collectCourseID(){
    return document.getElementsByName("courseID");
}

function collectTagID(){
    //Get Tags
    var tags = document.getElementsByName("tagList");
    var tagId = new Array();
    
    for (var i = 0; i<tags.length; i++){
        tagId[i] = tags.item(i).toString().split("id=")[1];
       
    }
}

function collectUser(){
    var user = document.getEle
}

function collectTagNames(){
    var tags = document.getElementsByName("tagList");
    var tagNames = new Array();
    
    for (var i = 0; i<tags.length; i++){
        tagNames[i]=tags[i].innerHTML;
    }
    
    return tagNames;
}
