<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>--%>
<%--<%@ taglib uri="mytaglib" prefix="mt" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <link href='<c:url value="/resources/style/style2.css"/>' rel='stylesheet' type='text/css'>
</head>

<fmt:message key="local.logout" var="logout"/>
<fmt:message key="local.admin_page" var="admin_page"/>
<fmt:message key="local.cruises" var="cruises"/>
<fmt:message key="local.orders" var="orders"/>
<fmt:message key="local.users" var="users"/>
<fmt:message key="local.remove" var="remove"/>
<fmt:message key="local.update" var="update"/>
<fmt:message key="local.add_new_user" var="add_new_user"/>
<fmt:message key="local.login" var="login"/>
<fmt:message key="local.password" var="password"/>
<fmt:message key="local.first_name" var="first_name"/>
<fmt:message key="local.last_name" var="last_name"/>
<fmt:message key="local.email" var="email"/>
<fmt:message key="local.phone" var="phone"/>
<fmt:message key="local.role" var="role"/>
<fmt:message key="local.accounts_id" var="accounts_id"/>
<fmt:message key="local.en" var="en"/>
<fmt:message key="local.ru" var="ru"/>

<body>
<ul>
    <li><a href="pageAdminCruises">${cruises}</a></li>
    <li><a href="pageAdminOrders">${orders}</a></li>

    <li style="float:right"><a href="login?logout">${logout}</a></li>
    <li style="float:right"><a href="?local=en">${en}</a></li>
    <li style="float:right"><a href="?local=ru">${ru}</a></li>
</ul>



<h1 align='center'>${admin_page}</h1>
<div align='center'>
    <table border='1'>
        <caption><h2>${users}</h2></caption>
        <tr>
            <td>№</td>
            <td>${first_name}</td>
            <td>${last_name}</td>
            <td>${email}</td>
            <td>${phone}</td>
            <td>${role}</td>
        </tr>
        <c:set var="k" value="0"/>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <c:if test="${user.role.id eq '1'}">
                <td>admin</td>
                </c:if>
                <c:if test="${user.role.id eq '2'}">
                    <td>client</td>
                </c:if>
                <td>
                    <form method="post" action="adminPageRemoveUser">
                        <button type="submit" name="removeButt" value="${user.id}"
                                class="btn btn-primary btn-block btn-large">${remove}</button>
                    </form>
                </td>
                <td>
                    <form method="get" action="adminGoToUpdatingPage">
                        <button type="submit" name="userIdForUpdateButt" value="${user.id}"
                                class="btn btn-primary btn-block btn-large">${update}</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div align='center' style="display: inline-block;">
        <a href="adminGoToPageAddingUser">
            <button class="btn btn-primary btn-block btn-large">${add_new_user}</button>
        </a>
    </div>
</div>

<%--<caption><h2>users</h2></caption>--%>
</body>
</html>
