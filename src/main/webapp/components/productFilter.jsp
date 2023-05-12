<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="modal" id="filter-modal" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" >
            <form action="${param.formDirect}" method="get">
                <input hidden name="isFilter" value="true">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h5 class="modal-title font-bold">Filter</h5>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <main>
                            <!--    Categories filter-->
                            <section class="categories">
                                <h5 class="font-primary">
                                    Categories
                                </h5>
                                <div class="row ms-auto">
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedCategories" value="ETR" id="ETR">
                                        <label class="form-check-label" for="ETR">
                                            Electronics
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedCategories" value="CLT" id="CLT">
                                        <label class="form-check-label" for="CLT">
                                            Clothing
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedCategories" value="BTY" id="BTY">
                                        <label class="form-check-label" for="BTY">
                                            Beauty
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedCategories" value="HAK" id="HAK">
                                        <label class="form-check-label" for="HAK">
                                            Home & Kitchen
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedCategories" value="SAO" id="SAO">
                                        <label class="form-check-label" for="SAO">
                                            Sports & Outdoors
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedCategories" value="BAM" id="BAM">
                                        <label class="form-check-label" for="BAM">
                                            Books & Media
                                        </label>
                                    </div>
                                </div>

                            </section>

                            <!-- Price filter -->
                            <section class="price mt-4">
                                <h5 class="font-primary">
                                    Price
                                </h5>
                                <div class="row ms-auto">
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="radio" name="priceOrder" id="price1" value="lowToHigh">
                                        <label class="form-check-label" for="price1">
                                            Low to High
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="radio" name="priceOrder" id="price2" value="highToLow">
                                        <label class="form-check-label" for="price2">
                                            High to Low
                                        </label>
                                    </div>
                                </div>
                            </section>

                            <!-- Discount filter -->
                            <section id="discount" class="discount mt-4">
                                <h5 class="font-primary">
                                    Discount
                                </h5>
                                <div class="row ms-auto">
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedDiscounts" value="20" id="discount20">
                                        <label class="form-check-label" for="discount20">
                                            > 20%
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedDiscounts" value="50" id="discount50">
                                        <label class="form-check-label" for="discount50">
                                            > 50%
                                        </label>
                                    </div>
                                    <div class="form-check col-4">
                                        <input class="form-check-input" type="checkbox" name="selectedDiscounts" value="80" id="discount80">
                                        <label class="form-check-label" for="discount80">
                                            > 80%
                                        </label>
                                    </div>
                                </div>
                            </section>

                            <!-- Rating filter -->
                            <section class="rating mt-4">
                                <h5 class="font-primary">
                                    Rating
                                </h5>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="selectedRatings" value="5" id="rating5" placeholder="">
                                    <label class="form-check-label text-warning" for="rating5">
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="selectedRatings" value="4" id="rating4" placeholder="">
                                    <label class="form-check-label text-warning" for="rating4">
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="selectedRatings" value="3" id="rating3" placeholder="">
                                    <label class="form-check-label text-warning" for="rating3">
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="selectedRatings" value="2" id="rating2" placeholder="">
                                    <label class="form-check-label text-warning" for="rating2">
                                        <span class="bi-star-fill"></span>
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="selectedRatings" value="1" id="rating1" placeholder="">
                                    <label class="form-check-label text-warning" for="rating1">
                                        <span class="bi-star-fill"></span>
                                    </label>
                                </div>
                            </section>
                        </main>
                    </div>

                    <!-- Modal footer -->
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
