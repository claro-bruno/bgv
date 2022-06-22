<%@ include file="common/header.jspf"%>

<%@ include file="common/welcome.jsp"%>
<div class="flex-container">
    <div class="left">
        <%@ include file="common/navigation.jspf"%>
    </div>
    <div class="right">
        <h2>Create Request</h2>
        <div id="errorMsg">
            ${error.message}
        </div>
        <br />

<form class="row g-3 needs-validation" method="post"  novalidate="true">


                Employement History: <br>
                Previous Company Details-1<br>
                <div>

                    <label for="companyName1" class="form-label">Company Name:</label>
                    <input oninput="this.value = this.value.replace(/[^a-zA-Z0-9.\s]/g, '').replace(/(\..*)\./g, '$1');" type="text" class="form-control" maxlength="50" id="companyName1"  name="companyName1" />

                </div>

                <div>
                    <label for="doj1" class="form-label">Date of Joining:</label>
                    <input type="text" class="form-control"  id="doj1" maxlength="50" name="doj1" placeholder="dd-mm-yyyy"  />

                </div>

                <div>
                    <label for="lastwd1" class="form-label">Last Working Day:</label>
                    <input type="text" class="form-control" id="lastwd1"  maxlength="50" name="lastwd1" placeholder="dd-mm-yyyy"  />

                </div>

                <div>
                    <label for="address1" class="form-label">Address:</label>
                    <input type="text" class="form-control" id="address1"  maxlength="50" name="address1"  />

                </div>

                Previous Company Details-2<br>
                <div>

                    <label  for="companyName2" class="form-label">Company Name:</label>
                    <input oninput="this.value = this.value.replace(/[^a-zA-Z0-9.]/g, '').replace(/(\..*)\./g, '$1');" type="text" class="form-control" id="companyName2"  maxlength="50" name="companyName2" />

                </div>

                <div>
                    <label for="doj2" class="form-label">Date of Joining:</label>
                    <input type="text" class="form-control" id="doj2" pattern="^[0-9]+(-[0-9]+)+$" name="doj2" maxlength="50" placeholder="dd-mm-yyyy"  />

                </div>

                <div>
                    <label for="lastwd2" class="form-label">Last Working Day:</label>
                    <input type="text" class="form-control"  pattern="^[0-9]+(-[0-9]+)+$" id="lastwd2" maxlength="50" name="lastwd2" placeholder="dd-mm-yyyy"  />

                </div>

                <div>
                    <label for="address2" class="form-label">Address:</label>
                    <input type="text" class="form-control" id="address2"  maxlength="50" name="address2"  />

                </div>


                Educational Details:

                <div>
                    <label for="hdegree" class="form-label">Highest Degree:</label>
                    <input type="text" class="form-control" id="hdegree"  name="hdegree" maxlength="50"  />

                </div>

                <div>
                    <label for="college" class="form-label">College / University:</label>
                    <input type="text" class="form-control" id="college"  name="college" maxlength="50" />

                </div>

                <div>
                    <label for="passedOutYear" class="form-label">Passed out year:</label>
                    <input oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"  type="text" class="form-control" id="passedOutYear"  name="passedOutYear" placeholder="yyyy" />

                </div>

                <div class="col-12">
                    <button class="btn btn-primary" type="submit" id="createRequest">Submit</button>
                </div>
            </form>

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