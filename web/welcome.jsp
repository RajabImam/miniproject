<%-- 
    Document   : welcome
    Created on : Mar 21, 2022, 4:06:25 PM
    Author     : RAJAB IMAM
--%>

<%@page contentType="text/html" 
        pageEncoding="UTF-8"
        import="com.isep.miniproject.models.WelcomeViewModel, 
                com.isep.miniproject.models.BookModel,
                java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome - Mini Project</title>
    </head>
    <body>
        <div>
            <h1>Welcome to Web Technologies Mini Project! </h1> 
            <h3>Hi! <%= request.getAttribute("login")%> </h3>
            <br>
            <form method="GET" action="AuthServlet">
                <input type="submit" value="Log Out" />
            </form>
        </div>
        <%
            if (session.getAttribute("login") == null) {
                response.sendRedirect("index.jsp");
            }
        %>

        <jsp:useBean id = 'welcomeView' scope = 'request' class = 'com.isep.miniproject.models.WelcomeViewModel'/>
        <jsp:setProperty name='welcomeView' property='books' value = '<%= ((WelcomeViewModel) session.getAttribute("welcomeView")).getBooks()%>'/>
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
                <th>Author</th>
                <th>Year</th>
                <th>Status</th>
                <th>Action</th>
                </thead>
                <tbody>
                    <%
                        ArrayList<BookModel> books = welcomeView.getBooks();
                        for (BookModel book : books) {
                            out.print("<tr>");
                            out.print("<td>" + book.getIsbn() + "</td>");
                            out.print("<td>" + book.getBookTitle() + "</td>");
                            out.print("<td>" + book.getAuthor() + "</td>");
                            out.print("<td>" + book.getReleaseYear() + "</td>");
                            
                            if (book.getStatus() == 1) {
                                out.print("<td>Available</td>");
                                out.print("<td><a href=\"\">Reserve Book</a></td>");
                            } else {
                                out.print("<td>Unavailable</td>");
                            }
                            out.print("</tr>");
                        }
                    %> 
                </tbody>   
            </table>

        </div>

    </body>
</html>
