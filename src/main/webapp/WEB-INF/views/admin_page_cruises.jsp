<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <link href='<c:url value="/resources/style/style2.css"/>' rel='stylesheet' type='text/css'>
</head>


<fmt:message key="local.logout" var="logout"/>
<fmt:message key="local.back" var="back"/>
<fmt:message key="local.admin_page" var="admin_page"/>
<fmt:message key="local.cruise_name" var="cruise_name"/>
<fmt:message key="local.cruises" var="cruises"/>
<fmt:message key="local.ship" var="ship"/>
<fmt:message key="local.availability" var="availability"/>
<fmt:message key="local.start_of_cruise" var="start_of_cruise"/>
<fmt:message key="local.cruise_duration" var="cruise_duration"/>
<fmt:message key="local.description" var="description"/>
<fmt:message key="local.price" var="price"/>
<fmt:message key="local.remove" var="remove"/>
<fmt:message key="local.update" var="update"/>
<fmt:message key="local.users" var="users"/>
<fmt:message key="local.orders" var="orders"/>
<fmt:message key="local.add_cruise" var="add_cruise"/>
<fmt:message key="local.ships" var="ships"/>
<fmt:message key="local.status" var="status"/>
<fmt:message key="local.en" var="en"/>
<fmt:message key="local.ru" var="ru"/>

<body>
<ul>
    <li><a href="controller?command=pageAdminShips">${ships}</a></li>
    <li><a href="controller?command=adminPage">${users}</a></li>
    <li><a href="controller?command=pageAdminOrders&page=1">${orders}</a></li>

    <li style="float:right"><a href="login?logout">${logout}</a></li>
    <li style="float:right"><a href="?local=en">${en}</a></li>
    <li style="float:right"><a href="?local=ru">${ru}</a></li>
</ul>
<h1 align='center'>${admin_page}</h1>

<div align='center'>

    <table border='1'>
        <caption><h2>${cruises}</h2></caption>
<%--        <tr>--%>
<%--            <td>№</td>--%>
<%--            <td>${cruise_name}</td>--%>
<%--            <td>${description}</td>--%>
<%--            <td>${price}</td>--%>
<%--            <td>${availability}</td>--%>
<%--            <td>${start_of_cruise}</td>--%>
<%--            <td>${cruise_duration}</td>--%>
<%--            <td>${status}</td>--%>
<%--        </tr>--%>
        <c:set var="k" value="0"/>
        <%--@elvariable id="allCruises" type="java.util.List"--%>
        <c:forEach var="cruise" items="${allCruises}">
            <c:set var="k" value="${k+1}"/>
            <tr>
                <td><c:out value="${k}"/></td>
                <td>${cruise.name}</td>
                <td>${cruise.description}</td>
                <td>${cruise.price}</td>
                <td>${cruise.capacity}</td>
                <td>${cruise.startOfCruise}</td>
                <td>${cruise.duration}</td>
                <td>${cruise.status}</td>
                <td>
                    <form method="post" action="controller">
                        <input type="hidden" name="command" value="adminPageCruiseRemoveCruise"/>
                        <button type="submit" name="cruiseIdForRemoveCruiseButt" value="${cruise.id}"
                                class="btn btn-primary btn-block btn-large">${remove}</button>
                    </form>
                </td>
                <td>
                    <form method="get" action="controller">
                        <input type="hidden" name="command" value="adminGoToPageForUpdatingCruise"/>
                        <button type="submit" name="cruiseIdForUpdateCruiseButt" value="${cruise.id}"
                                class="btn btn-primary btn-block btn-large">${update}</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div align='center' style="display: inline-block;">
        <a href="controller?command=adminGoToPageForAddingCruise">
            <button class="btn btn-primary btn-block btn-large">${add_cruise}</button>
        </a>
    </div>
</div>
</body>
</html>
