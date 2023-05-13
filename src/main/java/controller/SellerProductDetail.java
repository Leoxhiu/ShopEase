package controller;

import facade.CartFacade;
import facade.ProductFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Cart;
import model.Member;
import model.Product;
import utility.*;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "SellerProductDetail", value = {"/seller/product/detail", "/seller/s/product/detail"})
@MultipartConfig(maxFileSize = 16177215)
public class SellerProductDetail extends HttpServlet {

    @EJB
    private ProductFacade productFacade;

    @EJB
    private CartFacade cartFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productId = request.getParameter("productId");
        Product product = productFacade.getProductById(productId);

        request.setAttribute("productId", product.getId());
        request.setAttribute("productName", product.getName());
        request.setAttribute("productDescription", product.getDescription());
        request.setAttribute("productPrice", product.getPrice());
        request.setAttribute("productQuantity", product.getQuantity());
        request.setAttribute("productCategory", product.getCategory());
        request.setAttribute("productDiscount", product.getDiscount());

        ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        Part filePart = request.getPart("productImage");
        byte[] productImage = ImageUpload.getImageAsByte(filePart);
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String productPrice = request.getParameter("productPrice");
        String productQuantity = request.getParameter("productQuantity");
        String productCategory = request.getParameter("productCategory");
        String productDiscount = request.getParameter("productDiscount");

        request.setAttribute("productId", productId);
        request.setAttribute("productName", productName);
        request.setAttribute("productDescription", productDescription);
        request.setAttribute("productPrice", productPrice);
        request.setAttribute("productQuantity", productQuantity);
        request.setAttribute("productCategory", productCategory);
        request.setAttribute("productDiscount", productDiscount);

        // perform validation
        if (!productFacade.isValidNameLength(productName)) {
            request.setAttribute("productName", "");
            MessageHandler.setMessage(request, Message.PRODUCT_NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
            return;
        }
        if (!productFacade.isValidDescription(productDescription)) {
            request.setAttribute("productDescription", "");
            MessageHandler.setMessage(request, Message.PRODUCT_DESCRIPTION_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
            return;
        }
        double price = 0;
        try {
            price = Double.parseDouble(productPrice);
        } catch (Exception e) {
            request.setAttribute("productPrice", "");
            MessageHandler.setMessage(request, Message.PRODUCT_PRICE_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
        }
        if (!productFacade.isValidPrice(price)) {
            request.setAttribute("productPrice", "");
            MessageHandler.setMessage(request, Message.PRODUCT_PRICE_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
            return;
        }
        if (!productFacade.isValidQuantity(Integer.parseInt(productQuantity))) {
            request.setAttribute("productQuantity", "");
            MessageHandler.setMessage(request, Message.PRODUCT_QUANTITY_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
            return;
        }
        if (!productFacade.isValidDiscount(Integer.parseInt(productDiscount))) {
            request.setAttribute("productDiscount", "");
            MessageHandler.setMessage(request, Message.PRODUCT_DISCOUNT_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
            return;
        }

        // get the user
        HttpSession session = request.getSession();
        String sellerId = (String) session.getAttribute("sellerId");

        Product product = productFacade.getProductById(productId);

        // perform validation on productImage
        if (filePart != null && filePart.getSize() > 0) {
            productImage = ImageUpload.getImageAsByte(filePart);
        } else {
            productImage = product.getImage();
        }

        if(productFacade.update(productId, productImage, productName, productDescription,
                price, Integer.parseInt(productQuantity), productCategory, Integer.parseInt(productDiscount))){

            List<Cart> cartList = cartFacade.getActiveCartByProductId(productId);
            double discountedPrice = productFacade.findDiscountedPrice(price, Integer.parseInt(productDiscount));
            for (Cart cart : cartList) {
                double newPrice = cart.getQuantity() * discountedPrice;
                cart.setPrice(newPrice);
                cartFacade.editCart(cart);
            }

            MessageHandler.setMessage(request, Message.PRODUCT_UDPATE_SUCCESS, ButtonText.UNDERSTAND, JspPage.SELLER_MARKET.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
        } else{
            MessageHandler.setMessage(request, Message.PRODUCT_UDPATE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
        }
    }
}
