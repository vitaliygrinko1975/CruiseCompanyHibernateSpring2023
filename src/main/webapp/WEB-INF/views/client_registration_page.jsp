<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link href="<c:url value="/resources/style/style2.css" />" rel="stylesheet">
</head>
<body>
<<ul>
    <li style="float:right"><a href="welcome">${logout}</a></li>
</ul>
<div class='mydiv'>
    <h1 align='center'>Sign up</h1>
    <form method='post' action="registrationUser">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        Login: <input type='text' name='addLoginUser' required='required'/>
        Password: <input type='text' name='addPasswordUser' required='required'/>
        First name: <input type='text' name='addFirstNameUser' required='required'/>
        Last name: <input type='text' name='addLastNameUser' required='required'/>
        Email: <input type='email' name='addEmailUser' required='required'/>
        Phone: <input type='text' pattern="^[+3]\d{12,12}$" title="В формате +3ххххххххххх" name='addPhoneUser' required='required'/>
        <button  class='btn btn-primary btn-block btn-large'>CREATE</button>
    </form>
</div>
</body>
</html>

