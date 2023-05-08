<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="modal" id="error-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" >
            <div class="modal-content">

                <!-- Modal body -->
                <div class="modal-body">

                    <div class="text-center pt-2">
                        <i class="bi bi-x-circle-fill text-danger" style="font-size: 9.5rem;"></i>
                    </div>

                    <div class="message mt-2 font-primary text-center">
                        ${errorMessage}
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer justify-content-center mt-5">
                    <button type="button" class="btn btn-primary btn-lg" data-bs-dismiss="modal" id="error-button">${buttonText}</button>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
