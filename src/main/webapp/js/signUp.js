$(document).ready(function() {
    $("#signUpForm").submit(function(event) {
        event.preventDefault(); // prevent default form submission
        submitForm(); // call the function to submit the form using AJAX
    });

    function submitForm() {
        var formData = $("#signUpForm").serialize(); // serialize the form data
        $.ajax({
            type: "POST", // or "GET" depending on your form method
            url: "/shopease/sign-up", // URL of the server-side script that processes the form data
            data: formData,
            success: function(data) {
                $('#success-modal').modal('show');
            },
            error: function() {
                alert('Update Failed');
            }
        });
    }

});