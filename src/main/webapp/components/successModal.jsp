<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="../css/successModal.css"%></style>
</head>
<body>
    <div class="modal" id="success-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" >
            <div class="modal-content">

                <!-- Modal body -->
                <div class="modal-body">

                    <h1 class="text-center pt-5">
                        <div class="checkmark-circle">
                            <div class="background bg-success"></div>
                            <div class="checkmark draw"></div>
                        </div>
                    </h1>

                    <div class="message mt-5 font-primary text-center">
                        ${successMessage}
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer justify-content-center mt-5">
                    <a href="${url}" type="button" class="btn btn-primary btn-lg" id="success-button">
                        ${buttonText}
                    </a>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
