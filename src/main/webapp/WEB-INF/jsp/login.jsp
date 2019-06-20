

<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<h2>Log in</h2>

<p>You asked for a protected resource. Please log in:</p>

<form action="/doLogin" method="POST">
    <fieldset>

        <p>
            <label for="username">Username</label><br/>
            <input class="text" type="text" id="username" name="username"/>
        </p>

        <p>
            <label for="password">Password</label><br/>
            <input class="text" type="password" id="password" name="password"/>
        </p>

        <button type="submit" id="formSubmitButton" class="button positive">
            <img src="/css/blueprint/plugins/buttons/icons/tick.png" alt=""/>Log in
        </button>

    </fieldset>
</form>

<hr>

<p>Two users should exist: </p>

<pre>username/password</pre>
<pre>anotheruser/anotherpassword</pre>


<jsp:include page="/WEB-INF/jsp/footer.jsp"/>