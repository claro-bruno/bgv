<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="flex-container">
    <div class="left">
        <%@ include file="common/navigation.jspf"%>
    </div>
    <div class="right">
        <h2>${title}</h2><br>
        <div id="errors">
            ${errorMessage}
        </div>

        <form:form class="row g-3 needs-validation" method="post" modelAttribute="request" novalidate="true">

            <form:hidden path="id"/>

            Employement History: <br>
            Previous Company Details-1<br>
            <div>

                <form:label path="companyName1" for="companyName1" class="form-label">Company Name:</form:label>
                <form:input path="companyName1" oninput="this.value = this.value.replace(/[^a-zA-Z0-9.]/g, '').replace(/(\..*)\./g, '$1');" type="text" class="form-control" maxlength="50" id="companyName1"  name="companyName1" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div>
                <form:label path="doj1" for="doj1" class="form-label">Date of Joining:</form:label>
                <form:input path="doj1" type="text" class="form-control" readonly="true" id="doj1" maxlength="50" name="doj1" placeholder="dd-mm-yyyy" required="required"/>
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div>
                <form:label path="lastwd1" for="lastwd1" class="form-label">Last Working Day:</form:label>
                <form:input path="lastwd1" type="text" class="form-control"  readonly="true" id="lastwd1"  maxlength="50" name="lastwd1" placeholder="dd-mm-yyyy" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div>
                <form:label path="adress1" for="adress1" class="form-label">Address:</form:label>
                <form:input path="adress1" type="text" class="form-control" id="adress1"  maxlength="50" name="adress1" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            Previous Company Details-2<br>
            <div>

                <form:label path="companyName2"  for="companyName2" class="form-label">Company Name:</form:label>
                <form:input path="companyName2" oninput="this.value = this.value.replace(/[^a-zA-Z0-9.]/g, '').replace(/(\..*)\./g, '$1');" type="text" class="form-control" id="companyName2"  maxlength="50" name="companyName2" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div>
                <form:label path="doj2" for="doj2" class="form-label">Date of Joining:</form:label>
                <form:input path="doj2" type="text" class="form-control" id="doj2" readonly="true" name="doj2" maxlength="50" placeholder="dd-mm-yyyy" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div>
                <form:label path="lastwd2" for="lastwd2" class="form-label">Last Working Day:</form:label>
                <form:input path="lastwd2" type="text" class="form-control" readonly="true" id="lastwd2" maxlength="50" name="lastwd2" placeholder="dd-mm-yyyy" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div>
                <form:label path="adress2" for="adress2" class="form-label">Address:</form:label>
                <form:input path="adress2" type="text" class="form-control" id="adress2" maxlength="50"  name="adress2" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>


            Educational Details:

            <div>
                <form:label path="hdegree" for="hdegree" class="form-label">Highest Degree:</form:label>
                <form:input path="hdegree" type="text" class="form-control" id="hdegree"  name="hdegree" maxlength="50" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div>
                <form:label path="college" for="college" class="form-label">College / University:</form:label>
                <form:input path="college" type="text" class="form-control" id="college"  name="college" maxlength="50" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div>
                <form:label path="passedOutYear" for="passedOutYear" class="form-label">Passed out year:</form:label>
                <form:input path="passedOutYear" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"  type="text" class="form-control" id="passedOutYear"  name="passedOutYear" placeholder="yyyy" maxlength="4" minlength="4" required="required" />
                <div class="invalid-feedback">
                    Invalid Credentials
                </div>
            </div>

            <div class="col-12">
                <button class="btn btn-primary" type="submit">Submit</button>
            </div>
        </form:form>
    </div>
</div>




<%@ include file="common/footer.jspf"%>

<script>
$('#doj1').datepicker({
format : 'dd-mm-yyyy'
});
$('#doj2').datepicker({
    format : 'dd-mm-yyyy'
});
$('#lastwd1').datepicker({
    format : 'dd-mm-yyyy'
});
$('#lastwd2').datepicker({
    format : 'dd-mm-yyyy'
});
</script>