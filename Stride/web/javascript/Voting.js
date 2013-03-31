/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function questionVoteUp(num){
    if(getUserData()>0){
        $.get('VoteUp?id='+num+"&question=true", function(data) {
            var user = document.getElementById("questionVote");
        
            user.innerHTML = data;
        });
    }
}

function questionVoteDown(num){
    if(getUserData()>0){
        $.get('VoteDown?id='+num+"&question=true", function(data) {
            var user = document.getElementById("questionVote");
        
            user.innerHTML = data;
        });
    }
}

function getUserData(){
    var elements = document.getElementsByTagName("input");
    var len = elements.length;
    var uData = 0;
    
    for(var i = 0; i<len; i++){
        if(elements[i].name=="userData"){
            if(elements[i].value != ""){
            uData = elements[i].value;
            }else{
                uData = 0;
            }
            break;
        }
    }
    return uData;
}

function answerVoteUp(num){
    if(getUserData()>0){
        $.get('VoteUp?id='+num+"&question=false", function(data) {
            var user = document.getElementById("answerVote-"+num);
            user.innerHTML = data;
        });
    }
}

function answerVoteDown(num){
    if(getUserData()>0){
        $.get('VoteDown?id='+num+"&question=false", function(data) {
            var user = document.getElementById("answerVote-"+num);
            user.innerHTML = data;
        });
    }
}

function voteDown(num, question){
    $.get('VoteDown?id='+num+"&question="+question, function(data) {
        var user = document.getElementById("questionVote");
        user.innerHTML = data;
    });
}