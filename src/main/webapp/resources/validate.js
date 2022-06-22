


    $().ready(function(){
        var validator = $("#login").bind("invalid-form.validate",function(){
            $("#error").html("This form has "+ validator.numberOfInvalids()+" error(s)").css("color","red");

        }).validate({
            rules : {
                userName : {
                    required : true
                },
                password : {
                    required : true
                }
            },
            userName : {
                name : {
                    required : "Invalid Credentials"
                },
                password : {
                    required : "Invalid Credentials"
                }
            }
        });

    });