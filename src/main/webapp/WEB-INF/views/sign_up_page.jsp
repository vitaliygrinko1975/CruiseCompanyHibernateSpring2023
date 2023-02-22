<
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Admin</title>
    <link href='<c:url value="/resources/style/style2.css"/>' rel='stylesheet' type='text/css'>
</head>

<fmt:message key="local.logout" var="logout"/>
<fmt:message key="local.login" var="login"/>
<fmt:message key="local.password" var="password"/>
<fmt:message key="local.first_name" var="first_name"/>
<fmt:message key="local.last_name" var="last_name"/>
<fmt:message key="local.email" var="email"/>
<fmt:message key="local.phone" var="phone"/>
<fmt:message key="local.sign_up" var="sign_up"/>
<fmt:message key="local.enter" var="enter"/>
<fmt:message key="local.en" var="en"/>
<fmt:message key="local.ru" var="ru"/>

<body>
<
<ul>
    <li style="float:right"><a href="login?logout">${logout}</a></li>

    <li style="float:right"><a href="?local=en">${en}</a></li>
    <li style="float:right"><a href="?local=ru">${ru}</a></li>
</ul>
<div class='mydiv'>
    <h1 align='center'>${sign_up}</h1>
    <form method='post' action="signUpUser">
        ${login}: <input type='text' name='addLoginUser' required='required'/>
        ${password}: <input type='text' name='addPasswordUser' required='required'/>
        ${first_name}: <input type='text' name='addFirstNameUser' required='required'/>
        ${last_name}: <input type='text' name='addLastNameUser' required='required'/>
        ${email}: <input type='email' name='addEmailUser' required='required'/>
        ${phone}: <input type='text' pattern="^[+3]\d{12,12}$" title="В формате +3ххххххххххх" name='addPhoneUser'
                         required='required'/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type='submit' name='Butt' value='0' class='btn btn-primary btn-block btn-large'>${enter}</button>
    </form>
</div>
</body>
</html>

