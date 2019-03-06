function registerUser() {
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;

    if (password===confirm_password){
        var error_message =
            '<div class="alert alert-success">' +
            '<strong>Success!! Passwords match</strong>' +
            '</div>';

        $("#error").html(error_message);
    }else{
        var error_message =
            '<div class="alert alert-danger">' +
            '<strong>Error!! Passwords do not match</strong>' +
            '</div>';
        $("#error").html(error_message);
    }
}