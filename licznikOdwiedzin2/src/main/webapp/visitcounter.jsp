<%-- 
    Document   : visitcounter
    Created on : 4 lut 2025, 20:06:30
    Author     : olaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= request.getAttribute("visitCount")%> </h1>
    </body>
</html>
