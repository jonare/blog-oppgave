<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<h2>Welcome to the blog! Please leave a comment!</h2>

<a href="#bottom">Go to bottom</a>

<c:if test="${sessionScope.user == null}">
    <p>
        Welcome,
        <script>
            var name = getParameter("name");
            if(name == "undefined") {
                name = "Anonymous";
            }
            document.write(name+"!");

            var timeout = getParameter("timeout");
            if(timeout) {
                setTimeout(timeout);
            }
            $(location.hash);

        function getParameter(name){
           if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
              return decodeURIComponent(name[1]);
        }
        </script>
    </p>
</c:if>

<c:if test="${sessionScope.user != null}">
    <p>You are currently browsing the site as admin!</p>
</c:if>

<h3>Posts:</h3>


<c:forEach var="comment" items="${comments}">
    <div class="post">

        <c:if test="${sessionScope.user != null}">
            <div class="buttonsContainer">
                <a class="editButton" id="edit.${comment.title}" title="Edit post" href="/edit?commentID=${comment.ID}">&nbsp;</a>
                <a class="deleteButton" id="delete.${comment.title}" title="Delete post" href="/admin?commentToDelete=${comment.ID}">&nbsp;</a>
            </div>
        </c:if>

        <h4 class="postTitle">${comment.title}</h4>

        <div class="postBody">
            <a href=<c:out value="${comment.homepage}"/>>Home page</a><br/>
            ${comment.comment}
            </div>
    </div>
</c:forEach>

<form id="commentForm" action="/blog" method="POST">
    <fieldset>
        <legend>Post a comment:</legend>

        <p>
            <label for="title">Title:</label><br/>
            <input class="title" type="text" size="40" id="title" name="title"/>
        </p>
        <p>
            <label for="homepage">Home page:</label><br/>
            <input class="homepage" type="text" size="40" id="homepage" name="homepage"/>
        </p>
        <p>
            <label for="comment">Comment:</label><br/>
            <textarea class="text" cols="50" rows="6" id="comment" name="comment"></textarea>
        </p>

        <button type="submit" id="commentFormSubmit" class="button positive">
            <img src="/css/blueprint/plugins/buttons/icons/tick.png" alt=""/>Post comment
        </button>
    </fieldset>
</form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
