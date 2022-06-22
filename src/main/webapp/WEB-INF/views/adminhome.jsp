
<%@ include file="common/header.jspf"%>

<%@ include file="common/welcome.jsp"%>
<div class="flex-container">

    <div class="left">
        <%@ include file="common/navigationAdmin.jspf"%>
    </div>
    <div class="right">
        <h2>Requests Pending for approval</h2>
        <div id="errorMsg">
            ${error.message}
        </div>
        <table class="table table-striped">
            <caption>Requests Pending for approval</caption>
            <thead>
            <tr>
                <th>Request Number</th>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Date Submitted</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requests}" var="request">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.employeeId}</td>
                    <td>${request.employeeName}</td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy"
                                        value="${request.submittedDate}" /></td>
                    <td>${request.status}</td>
                    <td>
                        <a id="updateStatus${request.id}" type="button" class="btn btn-primary" href="updateStatus?id=${request.id}">Update Status</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>





<%@ include file="common/footer.jspf"%>