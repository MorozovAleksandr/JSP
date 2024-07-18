<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_bootstrap.jsp" />
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <jstl:if test="${sessionScope.user == null}">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/login">login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/registration">registration</a>
                    </li>
                </jstl:if>
                <jstl:if test="${sessionScope.user != null}">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/calc">calc</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/history">history</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/logout">logout</a>
                    </li>
                </jstl:if>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
