<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>for all</title>
    <link href='<c:url value="/resources/style/style2.css"/>' rel='stylesheet' type='text/css'>
</head>
<body>
<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <form method="get" action="forRegistered">
            <input type="hidden" name="local" value="en"/>
            <button type="submit"
                    class="btn btn-primary btn-block btn-large">FOR REGISTERED</button>
        </form>
    </div>
</div>
<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <form method="get" action="forRegistered">
            <input type="hidden" name="local" value="ru"/>
            <button type="submit"
                    class="btn btn-primary btn-block btn-large">ДЛЯ ЗАРЕГИСТРИРОВАННЫХ</button>
        </form>
    </div>
</div>
<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
<form method="get" action="registrationPage">
    <input type="hidden"name="local" value="en"/>
    <button type="submit"
            class="btn btn-primary btn-block btn-large">REGISTRATION</button>
</form>
    </div>
</div>
<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <form method="get" action="registrationPage">
            <input type="hidden"name="local" value="ru"/>
            <button type="submit"
                    class="btn btn-primary btn-block btn-large">РЕГИСТРАЦИЯ</button>
        </form>
    </div>
</div>

<h1 align='center'>CRUISE COMPANY</h1>
<div align='center'><img src='<c:url value="/resources/img/CruiseCompany.png"/>' alt='Hello'></div>
<div align='center' >
    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>
</body>
</html>
