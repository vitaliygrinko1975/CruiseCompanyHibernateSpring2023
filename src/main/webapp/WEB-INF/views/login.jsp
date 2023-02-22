<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/style/style2.css" />" rel="stylesheet">
    <title>Login</title>
</head>
<fmt:message key="local.registration" var="registration"/>
<fmt:message key="local.login" var="login"/>
<fmt:message key="local.registration" var="registration"/>
<fmt:message key="local.en" var="en"/>
<fmt:message key="local.ru" var="ru"/>
<fmt:message key="local.home" var="home"/>
<body>
<ul>
    <li><a href="goToWelcomePage">${home}</a>

    <li style="float:right"><a href="?local=en">${en}</a></li>
    <li style="float:right"><a href="?local=ru">${ru}</a></li>
</ul>
<div class="login">
    <h1>${login}</h1>
    <form id="login" action="login" method="post" class="form-horizontal">
        <input type="text" name="username" placeholder="Username" required="required"/>
        <input type="password" name="password" placeholder="Password" required="required"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">${login}</button>
    </form>
    <form id="registration" method="get" action="signUpPage">
        <button type="submit" class="btn btn-primary btn-block btn-large">${registration}</button>
    </form>
</div>


<div align='center' class="g-recaptcha" data-sitekey="6LcnqxkkAAAAAEiO0dh5hcpAmxy-sgibiy3hbbAx"
     required="required"></div>
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
            } else {
                error.innerHTML = "Complete the captcha";
            }
        });
        form1.addEventListener("submit", function (event) {
            event.preventDefault();
            const response = grecaptcha.getResponse();
            if (response) {
                form1.submit();
            } else {
                error.innerHTML = "Complete the captcha";
            }
        });
    }
</script>
</html>

