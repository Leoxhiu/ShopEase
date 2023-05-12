<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="modal" id="confirmation-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="confirmationModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">

            <!-- Modal body -->
            <div class="modal-body">
                <div class="text-center pt-2">
                    <i class="bi bi-question-circle-fill text-primary" style="font-size: 9.5rem;"></i>
                </div>

                <div class="message mt-5 font-primary text-center">
                    Are you sure you want to proceed?
                </div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer justify-content-center mt-5">
                <button type="button" class="btn btn-secondary btn-lg" data-bs-dismiss="modal">Close</button>
                <form method="post" action="${param.formDirect}">
                    <button type="submit" class="btn btn-primary btn-lg" id="submit-button">Confirm</button>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
