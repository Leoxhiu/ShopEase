<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="modal" id="filter-modal" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" >
            <form action="#applyFilter" method="post">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h5 class="modal-title font-bold">Filter</h5>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <main>
                            <section class="categories">
                                <h5 class="font-primary">
                                    Categories
                                </h5>
                                <div class="row ms-auto">
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="electronic" id="electronic">
                                        <label class="form-check-label" for="electronic">
                                            Electronics
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="fashion" id="fashion">
                                        <label class="form-check-label" for="fashion">
                                            Fashion
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="home" id="home">
                                        <label class="form-check-label" for="home">
                                            Home & Kitchen
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="sport" id="sport">
                                        <label class="form-check-label" for="sport">
                                            Sports & Outdoors
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="health" id="health">
                                        <label class="form-check-label" for="health">
                                            Health & Wellness
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="book" id="book">
                                        <label class="form-check-label" for="book">
                                            Books & Music
                                        </label>
                                    </div>
                                </div>

                            </section>

                            <section class="price mt-4">
                                <h5 class="font-primary">
                                    Price
                                </h5>
                                <div class="row ms-auto">
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="radio" name="price" id="price1">
                                        <label class="form-check-label" for="price1">
                                            Low to High
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="radio" name="price" id="price2">
                                        <label class="form-check-label" for="price2">
                                            High to Low
                                        </label>
                                    </div>
                                </div>
                            </section>

                            <section id="discount" class="discount mt-4">
                                <h5 class="font-primary">
                                    Discount
                                </h5>
                                <div class="row ms-auto">
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="discount20" id="discount20">
                                        <label class="form-check-label" for="discount20">
                                            > 20%
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="discount50" id="discount50">
                                        <label class="form-check-label" for="discount50">
                                            > 50%
                                        </label>
                                    </div>

                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" value="discount80" id="discount80">
                                        <label class="form-check-label" for="discount80">
                                            > 80%
                                        </label>
                                    </div>
                                </div>
                            </section>

                            <section class="rating mt-4">
                                <h5 class="font-primary">
                                    Rating
                                </h5>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="rating5" id="rating5" placeholder="">
                                    <label class="form-check-label text-warning" for="rating5">
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="rating4" id="rating4" placeholder="">
                                    <label class="form-check-label text-warning" for="rating4">
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="rating3" id="rating3" placeholder="">
                                    <label class="form-check-label text-warning" for="rating3">
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="rating2" id="rating2" placeholder="">
                                    <label class="form-check-label text-warning" for="rating2">
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="rating1" id="rating1" placeholder="">
                                    <label class="form-check-label text-warning" for="rating1">
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                            </section>
                        </main>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer justify-content-between">
                        <a href="/shopease/customer/market">Clear all</a>
                        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Apply</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
