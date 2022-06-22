<%@ include file="common/header.jspf"%>

<div class="container">
    <p>Login</p>
      <div id="errors" name="errors">
        ${errorMsg}
      </div>
    <form class="row g-3 needs-validation" id="login" action="login" method="POST">
        <div class="col-md-4">
            <label for="userName" class="form-label">User name</label>
            <input type="text" class="form-control" id="userName"  name="userName">
            <div class="invalid-feedback">
                Invalid Credentials
            </div>
        </div>
        <div class="col-md-4">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password"  name="password">
            <div class="invalid-feedback">
                Invalid Credentials
            </div>
        </div>

        <div class="col-12">
            <button class="btn btn-primary" type="submit" name="login">Submit</button>
        </div>
    </form>

</div>

<%@ include file="common/footer.jspf"%>
<script src="${pageContext.request.contextPath}/resources/validate.js"></script>