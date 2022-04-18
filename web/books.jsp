<%-- 
    Document   : books
    Created on : Mar 21, 2022, 4:06:52 PM
    Author     : RAJAB IMAM
--%>

<%@page contentType="text/html" 
        pageEncoding="UTF-8"
        import="com.isep.miniproject.models.BookModel"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books - Mini Project</title>
    </head>

    <%
        if (session.getAttribute("login") == null) {
            response.sendRedirect("index.jsp");
        }
    %>

    <jsp:useBean id = 'book' scope = 'request' class = 'com.isep.miniproject.models.BookModel'/>
    <jsp:setProperty name='book' property='isbn' value = '<%= ((BookModel) session.getAttribute("book")).getIsbn()%>'/>
    <jsp:setProperty name='book' property='bookTitle' value = '<%= ((BookModel) session.getAttribute("book")).getBookTitle()%>' />
    <jsp:setProperty name='book' property='releaseYear' value = '<%= ((BookModel) session.getAttribute("book")).getReleaseYear()%>' />
    <jsp:setProperty name='book' property='author' value = '<%= ((BookModel) session.getAttribute("book")).getAuthor()%>' />
    <jsp:setProperty name='book' property='status' value = '<%= ((BookModel) session.getAttribute("book")).getStatus()%>' />

    <div>
        <h1>Books </h1> 
        <br>
        <form method="GET" action="AuthServlet">
            <input type="submit" value="Log Out" />
        </form>
    </div>
    <div>
        <h3>Book Search</h3>
        <form action="/MiniProject/ResServlet" method="get">
            <input type="text" placeholder="Enter Book ISBN" name = "isbn" />
            <input type="submit" value="Search" />
        </form>
    </div>
    <div>
        <h3>Books Search Results</h3>
        <table>
            <thead>
            <th>ISBN</th>
            <th>Title</th>
            <th>Year</th>
            <th>Author</th>
            <th>Status</th>
            <th>Action</th>
            </thead>
            <tbody>
                <tr>
                    <td><jsp:getProperty name = 'book' property = 'isbn'/></td>
                    <td><jsp:getProperty name = 'book' property = 'bookTitle'/></td>
                    <td><jsp:getProperty name = 'book' property = 'releaseYear'/></td>
                    <td><jsp:getProperty name = 'book' property = 'author'/></td>
                    <%   
                        if (book.getStatus() == 1) {
                            out.print("<td>Available</td>");
                            out.print("<td>"
                            + "<form action = \"ResServlet\" method = \"post\">"
                            + "<input type=\"hidden\" name=\"isbn\" value =" + "\"" + book.getIsbn() + "\"" + ">"
                            + "<input type=\"submit\" value =\"Reserve\" />"
                            + "</form>"
                            + "</td>");
                        } else {
                            out.print("<td>Unavailable</td>");
                            out.print("<td>"
                            + "<form action = \"ResServlet\" method = \"post\">"
                            + "<input type=\"hidden\" name=\"isbn\" value =" + "\"" + book.getIsbn() + "\"" + ">"
                            + "<input type=\"submit\" value =\"Unreserve\" />"
                            + "</form>"
                            + "</td>");
                        }                   
                    %> 

                </tr>
            </tbody>   
        </table>

    </div>

</html>
