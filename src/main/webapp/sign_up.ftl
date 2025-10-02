<html lang="en">
<#include "base.ftl">

<#macro title>SignUp Page</#macro>

<#macro header>SignUp</#macro>

<#macro content>

    <form method="post" action="/sign_up">
        Login:
        <input type="text" name="login" placeholder="type your login here">
        Password:
        <input type="password" name="password">
        <br>
        <input type="submit" value="sign_up">
    </form>

</#macro>


</html>