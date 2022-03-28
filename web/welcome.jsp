<%-- 
    Document   : welcome
    Created on : Mar 21, 2022, 4:06:25 PM
    Author     : RAJAB IMAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome - Mini Project</title>
    </head>
    <body>
        <div>
           <h1>Welcome to Web Technologies Mini Project! </h1> 
           Hi! <%= request.getAttribute("login") %>
           <br>
           <form method="GET" action="AuthServlet">
               <input type="submit" value="Log Out" />
           </form>
        </div>
           <div>
               <h3>Book Search</h3>
               <form action="" method="post">
                   <input type="text" placeholder="Enter Book Name" />
                   <input type="submit" value="Search" />
               </form>
           </div>
        
    </body>
</html>
