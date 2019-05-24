<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 24.05.19
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Books</title>
</head>
<body>
<h1 align="center">All Books</h1>
<table border="1" align="center">
    <tr>
        <th>ID</th>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Type</th>
    </tr>
    <c:forEach var="list" items="${allBooks}">
        <tr>
            <td >${list.id}</td>
            <td >${list.isbn}</td>
            <td >${list.title}</td>
            <td >${list.author}</td>
            <td >${list.publisher}</td>
            <td >${list.type}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
