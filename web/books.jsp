<%-- 
    Document   : books
    Created on : Mar 21, 2022, 4:06:52 PM
    Author     : RAJAB IMAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books - Mini Project</title>
    </head>
    <body>
         <% 
            if (session.getAttribute("login") == null) {
                    response.sendRedirect("index.jsp");
                }
           %>
        <div>
            <h1>Books </h1> 
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
        <div>
            <h3>Books Search Results</h3>
            <table>
                <tr>
                    <th>ISN</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>123</td>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Available</td>
                    <td><a href="">Reserve Book</a></td>
                </tr>
                <tr>
                    <td>125</td>
                    <td>Java Ultimate</td>
                    <td>Deitel and Deitel</td>
                    <td>Available</td>
                    <td><a href="">Reserve Book</a></td>
                </tr>
            </table>

        </div>
    </body>
</html>
