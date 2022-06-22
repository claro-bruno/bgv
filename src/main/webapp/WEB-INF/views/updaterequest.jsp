<%@ include file="common/header.jspf"%>

<%@ include file="common/welcome.jsp"%>
<div class="flex-container">
    <div class="left">
        <%@ include file="common/navigation.jspf"%>
    </div>
    <div class="right">
        <h2>Edit Request</h2>
        <div id="errorMsg">
            ${error.message}
        </div>
        <br />

        <form class="row g-3 needs-validation" method="post"  id="request">

            <input type="hidden" name="id" value="${request.getId()}"/>

            <div>
                <label class="form-label">Employment History: </label>
            </div>
            <div>
                <label class="form-label"><strong>Previous Company Details-1:</strong></label>
            </div>
            <div>
                <label for="companyName1" class="form-label">Company Name:</label>
                <input type="text" class="form-control" id="companyName1" name="companyName1" value="${request.companyName1}" />
            </div>

            <div>
                <label for="doj1" class="form-label">Date of Joining:</label>
                <input type="text" class="form-control" id="doj1"  name="doj1" placeholder="dd-mm-yyyy"  required="required" value="${request.doj1}" />
            </div>

            <div>
                <label for="lastwd1" class="form-label" >Last Working Day:</label>
                <input type="text" class="form-control" id="lastwd1"  name="lastwd1" placeholder="dd-mm-yyyy"  required="required" value="${request.lastwd1}" />
            </div>

            <div>
                <label for="address1" class="form-label">Address:</label>
                <input type="text" class="form-control" id="address1"  name="address1" required="required" value="${request.address1}"/>
            </div>

            <div>
                <label class="form-label"><strong>Previous Company Details-2:</strong></label>
            </div>
            <div>
                <label for="companyName2" class="form-label">Company Name:</label>
                <input type="text" class="form-control" id="companyName2" name="companyName2" value="${request.companyName2}" />
            </div>

            <div>
                <label for="doj2" class="form-label">Date of Joining:</label>
                <input type="text" class="form-control" id="doj2"  name="doj2" placeholder="dd-mm-yyyy"  required="required" value="${request.doj2}" />
            </div>

            <div>
                <label for="lastwd2" class="form-label" >Last Working Day:</label>
                <input type="text" class="form-control" id="lastwd2"  name="lastwd2" placeholder="dd-mm-yyyy"  required="required" value="${request.lastwd2}" />
            </div>

            <div>
                <label for="address2" class="form-label">Address:</label>
                <input type="text" class="form-control" id="address2"  name="address1" required="required" value="${request.address2}"/>
            </div>


            <div>
                <label class="form-label"><strong>Educational Details:</strong></label>
            </div>

            <div>
                <label for="hdegree" class="form-label">Highest Degree:</label>
                <input type="text" class="form-control" id="hdegree"  name="hdegree" required="required" value="${request.hdegree}" />
            </div>

            <div>
                <label for="college" class="form-label">College / University:</label>
                <input type="text" class="form-control" id="college"  name="college" required="required" value="${request.college}" />
            </div>

            <div>
                <label for="passedOutYear" class="form-label">Passed out year:</label>
                <input type="text" class="form-control" id="passedOutYear"  name="passedOutYear" placeholder="yyyy" required="required" value="${request.passedOutYear}" />
            </div>


                <div class="col-12">
                    <button class="btn btn-primary" type="submit" id="editRequest">Submit</button>
                </div>
        </form>

    </div>
</div>



<%@ include file="common/footer.jspf"%>
