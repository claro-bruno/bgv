<%@ include file="common/header.jspf"%>

<div class="container">
    <p>Login</p>
      <div id="errors">
        ${errorMessage}
      </div>
    <form class="row g-3 needs-validation" action="login" method="POST" novalidate>
        <div class="col-md-4">
            <label for="userName" class="form-label">User name</label>
            <input type="text" class="form-control" id="userName"  name="userName" maxlength="30" required>
            <div class="invalid-feedback">
                Invalid Credentials
            </div>
        </div>
        <div class="col-md-4">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password"  name="password" maxlength="30" required>
            <div class="invalid-feedback">
                Invalid Credentials
            </div>
        </div>

        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit</button>
        </div>
    </form>

</div>
<script type="text/javascript">
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
<%@ include file="common/footer.jspf"%>