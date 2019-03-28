function registerUser() {
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;

    if (password===confirm_password){
        var error_message ='';

        if(password.length>=6){
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var phone = document.getElementById("phone").value;

            if (name===""
                || email==="" ||
                phone===""){
                error_message += '<div class="alert alert-danger">' +
                    '<strong>Error!! Fill in All the required' +
                    ' fields</strong>' +
                    '</div>';
            }else{
                var formData = {
                  "name":name,
                  "email":email,
                  "phone":phone,
                  "password":password
                };

                $.ajax({
                    type:"POST",
                    url:"../users/addUser",
                    data:formData,
                    dataType:"json",
                    success: function (response) {
                        console.log(response);
                        swal({
                            title:"Registration",
                            text:"You have been registered " +
                            "successfully to our platform",
                            type:"success",
                            buttonsStyling:true,
                            confirmButtonClass:"btn btn-success"
                        });
                    }

                });
            }
        }else{
            error_message += '<div class="alert alert-danger">' +
                '<strong>Error!! Passwords length too short.' +
                'Use more than 6 characters</strong>' +
                '</div>';
        }

        $("#error").html(error_message);
    }else{
        var error_message =
            '<div class="alert alert-danger">' +
            '<strong>Error!! Passwords do not match</strong>' +
            '</div>';
        $("#error").html(error_message);
    }
}

function AuthorizeUser() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    var formData={
        "email":email,
        "password":password
    };

    $.ajax({
        type:"POST",
        url:"../users/authorize",
        data:formData,
        dataType:"json",
        success:function (response) {
            console.log(response);

            var id=response.password+"###"+response.id;
            var uuid=response.uuid+"###"+response.password;


            localStorage.setItem("id",response.id);
            localStorage.setItem("uuid",btoa(uuid));
            localStorage.setItem("name",response.name);
           window.location="../thyme/dashboard";
        },
        error:function (response,status,error) {
            var jsonFile =$.parseJSON(response.responseText);
            console.log(jsonFile.message);
            console.log(status);
        }
    });


}
function windowOpener(url) {
    window.location=url;
}
function addHotel(){
    var name = document.getElementById("hotel_name").value;
    var location = document.getElementById("hotel_location").value;
    var description = document.getElementById("description").value;
    var phone = document.getElementById("phonenumber").value;
    var email = document.getElementById("email").value;

    $.ajax({
        url:"../hotel",
        method:"POST",
        dataType:"json",
        contentType:"application/json",
        data: JSON.stringify({
            name:name,
            location:{
                id:parseInt(location)
            },
            description:description,
            phone:phone,
            email:email,
            user:{
                id:parseInt(localStorage.getItem("id"))
            }

        }),
        success:function (response) {
            console.log(response);
            swal({
                title:"Hotel",
                text:"hotel added successfully ",
                type:"success",
                buttonsStyling:true,
                confirmButtonClass:"btn btn-success"
            });
            windowOpener('./dashboard');
        }
    });
}