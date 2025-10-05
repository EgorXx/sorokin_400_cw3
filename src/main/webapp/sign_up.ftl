<html lang="en">
<#include "base.ftl">

<#macro title>SignUp Page</#macro>

<#macro header>SignUp</#macro>

<#macro content>

    <form method="post" action="/sign_up">
        Name:
        <input type="text" name="name" placeholder="type your name here">
        Lastname:
        <input type="text" name="lastname" placeholder="type your lastname here">
        Login:
        <input type="text" name="login" placeholder="type your login here">
        Password:
        <input type="password" name="password">
        <br>
        <input type="submit" value="sign_up">
    </form>

</#macro>


</html>