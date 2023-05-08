// $(document).ready(function() {
//     $("#signUpForm").submit(function(event) {
//         event.preventDefault();
//         submitForm(); // call the function to submit the form using AJAX
//         $('input[type="password"]').val('');
//     });
//
//     function submitForm() {
//         var formData = $("#signUpForm").serialize(); // serialize the form data
//         $.ajax({
//             type: "POST",
//             url: "/shopease/sign-up",
//             data: formData,
//             dataType: "json",
//             success: function(response) {
//                 var message = response.message;
//                 $('#success-modal').find('.message').html('<h4>' + message + '</h4>');
//                 $('#success-button').text(response.button);
//                 $('#success-button').on('click', function() {
//                     window.location.href = response.url;
//                 });
//                 $('#success-modal').modal('show');
//             },
//             error: function(response) {
//                 var message = response.responseJSON.message;
//                 $('#error-modal').find('.message').html('<h4>' + message + '</h4>');
//                 $('#error-button').text(response.responseJSON.button);
//                 $('#error-modal').modal('show');
//             }
//         });
//     }
//
// });