
<%-- 
    Document   : index
    Created on : Mar 21, 2022, 4:05:07 PM
    Author     : RAJAB IMAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Technologies - Mini Project</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <div>
            <h1>Login to Book Reservation Dashboard </h1>
            <form action="AuthServlet" name="loginForm" onsubmit="" method="post" >
            <fieldset class="infoFieldset">
                <legend>Sign In:</legend>
                <label for="login">Login:</label>
                <input type="text" name="login" id="login" required="required"/>
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" required="required"/>
               <div id="msg"></div>
            </fieldset>
            <input type="submit" value="Login" id="btn"/>
        </form>
        </div>
    </body>
</html>
