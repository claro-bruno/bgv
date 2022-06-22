<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="common/welcome.jsp"%>
<div class="flex-container">
    <div class="left">
        <%@ include file="common/navigationAdmin.jspf"%>
    </div>
    <div class="right">
        <h2>Update Request Status</h2>
        <div id="errorMsg">
            ${error.message}
        </div>
    <form:form class="row g-3 needs-validation" method="post" modelAttribute="request" novalidate="true">
        <form:hidden path="id"/>

        <div>
            <label for="empNum" class="form-label">Emp Number:</label>
            <label type="text" class="form-control" id="empNum"  name="empNum" >${request.employeeId}</label>
        </div>
        <div>
            <label for="empName" class="form-label">Employee Name:</label>
            <label type="text" class="form-control" id="empName"  name="empName" >${request.employeeName}</label>
        </div>
        <div>
            <label class="form-label">Employment History: </label>
        </div>
        <div>
            <label class="form-label"><strong>Previous Company Details-1:</strong></label>
        </div>
        <div>
            <form:label path="companyName1" for="companyName1" class="form-label">Company Name:</form:label>
            <form:label path="companyName1" type="text" class="form-control" id="companyName1" name="companyName1" >${request.companyName1}</form:label>
        </div>

        <div>
            <form:label path="doj1" for="doj1" class="form-label">Date of Joining:</form:label>
            <form:label path="doj1" type="text" class="form-control" id="doj1"  name="doj1" placeholder="dd-mm-yyyy"  disabled="true" required="required" ><fmt:formatDate pattern="dd-MM-yyyy"
                                                                                                                                                                               value="${request.doj1}" /></form:label>
        </div>

        <div>
            <form:label path="lastwd1" for="lastwd1" class="form-label" >Last Working Day:</form:label>
            <form:label path="lastwd1" type="text" class="form-control" id="lastwd1"  name="lastwd1" placeholder="dd-mm-yyyy"  disabled="true" required="required"><fmt:formatDate pattern="dd-MM-yyyy"
                                                                                                                                                                                   value="${request.lastwd1}" /></form:label>
        </div>

        <div>
            <form:label path="address1" for="address1" class="form-label">Address:</form:label>
            <form:label path="address1" type="text" class="form-control" id="address1"  name="address1" required="required">${request.address1}</form:label>
        </div>

        <div>
            <label class="form-label"><strong>Previous Company Details-2:</strong></label>
        </div>
        <div>

            <form:label path="companyName2" for="companyName2" class="form-label">Company Name:</form:label>
            <form:label path="companyName2" type="text" class="form-control" id="companyName2"  name="companyName2" required="required">${request.companyName2}</form:label>
        </div>

        <div>
            <form:label path="doj2" for="doj2" class="form-label">Date of Joining:</form:label>
            <form:label path="doj2" type="text" class="form-control" id="doj2"  name="doj2" placeholder="dd-mm-yyyy"  disabled="disabled" required="required"><fmt:formatDate pattern="dd-MM-yyyy"
                                                                                                                                                                              value="${request.doj2}" /></form:label>
        </div>

        <div>
            <form:label path="lastwd2" for="lastwd2" class="form-label">Last Working Day:</form:label>
            <form:label path="lastwd2" type="text" class="form-control" id="lastwd2"  name="lastwd2" placeholder="dd-mm-yyyy" required="required"><fmt:formatDate pattern="dd-MM-yyyy"
                                                                                                                                                                  value="${request.lastwd2}" /></form:label>
        </div>

        <div>
            <form:label path="address2" for="address2" class="form-label">Address:</form:label>
            <form:label path="address2" type="text" class="form-control" id="address2"  name="address2" required="required">${request.address2}</form:label>
        </div>


        <div>
            <label class="form-label"><strong>Educational Details:</strong></label>
        </div>

        <div>
            <form:label path="hdegree" for="hdegree" class="form-label">Highest Degree:</form:label>
            <form:label path="hdegree" type="text" class="form-control" id="hdegree"  name="hdegree" required="required">${request.hdegree}</form:label>
        </div>

        <div>
            <form:label path="college" for="college" class="form-label">College / University:</form:label>
            <form:label path="college" type="text" class="form-control" id="college"  name="college" required="required">${request.college}</form:label>
        </div>

        <div>
            <form:label path="passedOutYear" for="passedOutYear" class="form-label">Passed out year:</form:label>
            <form:label path="passedOutYear" type="text" class="form-control" id="passedOutYear"  name="passedOutYear" placeholder="yyyy" required="required">${request.passedOutYear}</form:label>
        </div>

        <div>
            <label class="form-label"><strong>New Status:</strong></label>
        </div>

        <div>
            <label for="status" class="form-label">Status</label>
            <select name="status" class="form-control" id="status" required="required">
                <option value="Approved" selected>Approved</option>
                <option value="Rejected">Rejected</option>

            </select>

            <label for="remarks" class="form-label">Remarks</label>
            <input type="text" class="form-control" id="remarks"  name="remarks" maxlength="50"  required="required" />
            <div class="invalid-feedback">
                Invalid Credentials
            </div>
        </div>


        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit</button>
        </div>
    </form:form>


</div>


<%@ include file="common/footer.jspf"%>