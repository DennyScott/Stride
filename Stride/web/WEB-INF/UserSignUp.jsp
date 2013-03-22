<%-- 
    Document   : UserSignUp
    Created on : 22-Mar-2013, 1:29:24 AM
    Author     : Denny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Sign-Up</title>
    </head>
    <body>
        <form name="SignUp" action="SignUp" method="POST">
           UserName: <input type="text" name="username" id="username"/><br>
           Password: <input type="text" name="password" id="password"/><br>
           Image: <input type="text" name="image" id="image"/><br>
           Reputation: <input type="text" name="reputation" id="reputation"/><br>
           First Name: <input type="text" name="firstName" id="firstName"/><br>
           Last Name: <input type="text" name="lastName" id="lastName"/><br>
           Email: <input type="text" name="email" id="email"/><br>
           Number of Questions: <input type="text" name="numQuestions" id="numQuestions"/><br>
           Number of Answers: <input type="text" name="numAnswers" id="numAnswers"/><br>
           Votes: <input type="text" name="votes" id="votes"/><br>
           Rank: <input type="text" name="rank" id="rank"/><br>
           Bio: <input type="text" name="bio" id="bio"/><br>
           Gold: <input type="text" name="gold" id="gold"/><br>
           Silver: <input type="text" name="silver" id="silver"/><br>
           Bronze: <input type="text" name="bronze" id="bronze"/><br>
           Joined Date: <input type="text" name="join" id="join"/><br>
           Last Online: <input type="text" name="lastOnline" id="lastOnline"/><br>
           isAnnonymous: <input type="checkbox" name="isAnon" value="ON" checked="checked" />
            
           <input type="submit" value="submit" />
        </form>
    </body>
</html>
