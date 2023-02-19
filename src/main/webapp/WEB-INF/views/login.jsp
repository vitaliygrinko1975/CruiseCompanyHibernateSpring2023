<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<c:set var="title" value="Login"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value="/resources/style/style2.css" />" rel="stylesheet">

</head>

<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <a href="welcome">
            <button class="btn btn-primary btn-block btn-large">Log out</button>
        </a>
    </div>
</div>

<div class="login">
    <c:url var="loginUrl" value="/login"/>
    <form id="login"  action="${loginUrl}" method="post" class="form-horizontal">
        <c:if test="${param.logout != null}">
            <div>
                <p>You have been logged out successfully.</p>
            </div>
        </c:if>
        <c:if test="${param.error != null}">
            <div>
                <p>Invalid username and password.</p>
            </div>
        </c:if>
        <input type="text" name="username" placeholder="Username" required="required"/>
        <input type="password" name="password" placeholder="Password" required="required"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">Log in</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div

<div align='center' class="g-recaptcha" data-sitekey="6LcnqxkkAAAAAEiO0dh5hcpAmxy-sgibiy3hbbAx" required="required"></div>
<div align='center' class="text-danger" id="error"></div>
</body>
<script src="https://www.google.com/recaptcha/api.js"></script>
<script>
    window.onload = function () {
        const form = document.getElementById("login");
        const form1 = document.getElementById("registration");
        const error = document.getElementById("error");
        form.addEventListener("submit", function (event) {
            event.preventDefault();
            const response = grecaptcha.getResponse();
            if (response) {
                form.submit();
            }else {
                error.innerHTML = "Complete the captcha";
            }
        });
        form1.addEventListener("submit", function (event) {
            event.preventDefault();
            const response = grecaptcha.getResponse();
            if (response) {
                form1.submit();
            }else {
                error.innerHTML = "Complete the captcha";
            }
        });
    }
</script>


</html>

