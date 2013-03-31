
$(function() {
    $('#noDistractions').waypoint(function() {
                        
        $(this).animate({
            width:"550px"
        }, function(){
            $('#firstArrow').addClass("arrow-1").hide().fadeIn(300, function(){
                            
                $('#secondArrow').addClass("arrow-2").hide().fadeIn(300);
            });  

        });
                        
    }, {
        offset: '30%',
        triggerOnce: true
    });
});
                
$(function() {
    $('#first').waypoint(function() {
                        
        $('.vote-accepted-off','#second').addClass("vote-accepted-on").hide().fadeIn(1000);
        $('.vote-up-off','#second').removeClass('vote-up-off').addClass("customVoteOn").hide().fadeIn(1000);
        $('.vote-count-post','#second').text("4").hide().fadeIn(1000);

        $("#first").fadeOut(2000, function(){

            $("#second").show("clip", {
                direction: "horizontal"
            }, 2000);
            $("#third").replaceWith(this)
            $("#first").fadeIn(2000);
                            
        });  
        $('#second').hide("clip", {
            direction: "horizontal"
        }, 2000);

    }, {
        offset: '30%',
        triggerOnce: true
    });
});
                
                
$(function() {
    $('.tagBlock').waypoint(function() {
                        
        $(this).animate({
            width:"550px"
        }, function(){

            $('.arrow2Marker').addClass("arrow-2").hide().fadeIn(300);
        });
                        
    }, {
        offset: '30%',
        triggerOnce: true
    });
});
                       
$(function() {
    $('.repArea').waypoint(function() {
                    
        $(this).animate({
            width:"550px"
        });
        $('.user-info-mini').animate({
            width:"530px"
        }, function(){
            $('.arrow3Marker').addClass("arrow-2RepArea").hide().fadeIn(300);
            $('.repArea2').animate({
                width:"550px"
            }, function(){
                $('.arrow4Marker').addClass("arrow-4").hide().fadeIn(300);
                $('.repArea3').animate({
                    width:"550px"
                }, function(){
                    $('.arrow5Marker').addClass("arrow-4").hide().fadeIn(300);
                });
            });
                        
        });

                    
                                            
    }, {
        offset: '30%',
        triggerOnce: true
    });
});
            
            
                       
            
$(function() {
    $('#editingBlock').waypoint(function() {
                        
        $(this).animate({
            width:"550px"
        }, function(){
            $('#arrow8Marker').addClass("arrow-2").hide().fadeIn(300);
            $('#arrow9Marker').addClass("arrow-2").hide().fadeIn(300);

                       
        });
                        
    }, {
        offset: '30%',
        triggerOnce: true
    });
});
            
$(function() {
    $('#askAboutTopic').waypoint(function() {
                        
        $(this).animate({
            width:"550px"
        }, function(){
            $('#arrow6Marker').addClass("arrow-4").hide().fadeIn(300);
            $('#dontAskAbout').animate({
                width:"550px"
            }, function(){
                $('#arrow7Marker').addClass("arrow-4").hide().fadeIn(300);
            });
                       
        });
                        
    }, {
        offset: '40%',
        triggerOnce: true
    });
});
           
            
$(function() {
    $('#aboutBadgesBlock').waypoint(function() {
                    
        $(this).animate({
            width:"550px"
        });
                    
                                            
    }, {
        offset: '70%',
        triggerOnce: true
    });
});
                
               
$(document).ready(function() {
                        
    var img = $('<img id="dynamic">'); //Equivalent: $(document.createElement('img'))
    img.attr('src', 'Logo_Single_S.png');
    img.appendTo('#strideSymbol');
    img.hide().fadeIn(2000);
                    
                        
});


