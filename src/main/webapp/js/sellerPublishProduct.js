$(document).ready(function() {
    function calculateDiscountedPrice() {
        var price = parseFloat($('#productPrice').val());
        var discount = parseFloat($('#productDiscount').val());
        var discountedPrice = price - (price * (discount / 100));

        if (!isNaN(discountedPrice)) {
            $('#discountedPrice').text('Discounted Price: $' + discountedPrice.toFixed(2)).show();
        } else {
            $('#discountedPrice').hide();
        }
    }

    // Call the calculateDiscountedPrice function when the price or discount inputs change
    $('#productPrice, #productDiscount').on('input', calculateDiscountedPrice);
});