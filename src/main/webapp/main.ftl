<html lang="en">
<#include "base.ftl">

<#macro title>Main page</#macro>

<#macro header>Main page</#macro>

<#macro content>

    <a href="/logout">Выйти</a>
    <h3>
        Hello, ${sessionUser}! Login successful
        <br>
        Session ID = ${sessionId}
        <br>
        Cookie user = ${cookieUser}
    </h3>

</#macro>


</html>