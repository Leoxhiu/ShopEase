<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="modal" id="filter-modal" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable">
        <form action="${param.formDirect}" method="get">
            <input type="hidden" name="isFilter" value="true">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h5 class="modal-title font-bold">Filter</h5>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <div class="container">
                        <!-- User Type filter -->
                        <div class="mb-4">
                            <h5 class="font-primary">User Type</h5>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="selectedUserTypes" value="c" id="userTypeCustomer">
                                <label class="form-check-label" for="userTypeCustomer">
                                    Customer
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="selectedUserTypes" value="s" id="userTypeSeller">
                                <label class="form-check-label" for="userTypeSeller">
                                    Seller
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="selectedUserTypes" value="a" id="userTypeAdmin">
                                <label class="form-check-label" for="userTypeAdmin">
                                    Admin
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer justify-content-between">
                    <a href="${param.clearDirect}">Clear all</a>
                    <button type="submit" class="btn btn-primary">Apply</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
