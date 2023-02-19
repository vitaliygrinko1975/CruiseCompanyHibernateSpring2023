<<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Admin</title>
    <link href='<c:url value="/resources/style/style2.css"/>' rel='stylesheet' type='text/css'>
</head>
<fmt:setLocale value="${local}"/>
<fmt:setBundle basename="local" var="loc"/>
<fmt:message bundle="${loc}" key="local.logout" var="logout"/>
<fmt:message bundle="${loc}" key="local.login" var="login"/>
<fmt:message bundle="${loc}" key="local.password" var="password"/>
<fmt:message bundle="${loc}" key="local.first_name" var="first_name"/>
<fmt:message bundle="${loc}" key="local.last_name" var="last_name"/>
<fmt:message bundle="${loc}" key="local.email" var="email"/>
<fmt:message bundle="${loc}" key="local.phone" var="phone"/>
<fmt:message bundle="${loc}" key="local.sign_up" var="sign_up"/>
<fmt:message bundle="${loc}" key="local.enter" var="enter"/>

<body>
<<ul>
    <li style="float:right"><a href="welcome">${logout}</a></li>
</ul>
<div class='mydiv'>
    <h1 align='center'>${sign_up}</h1>
    <form method='post' action="controller">
        <input type="hidden" name="command" value="signUpUser"/>
        Login: <input type='text' name='addLoginUser' required='required'/>
        Password: <input type='text' name='addPasswordUser' required='required'/>
        First name: <input type='text' name='addFirstNameUser' required='required'/>
        Last name: <input type='text' name='addLastNameUser' required='required'/>
        Email: <input type='email' name='addEmailUser' required='required'/>
        Phone: <input type='text' pattern="^[+3]\d{12,12}$" title="В формате +3ххххххххххх" name='addPhoneUser' required='required'/>
        <button type='submit' name='Butt' value='0' class='btn btn-primary btn-block btn-large'>${enter}</button>
    </form>
</div>
</body>
</html>

