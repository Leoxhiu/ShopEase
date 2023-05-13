package controller;

import facade.ProductFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Product;
import model.Seller;
import utility.*;

import java.io.IOException;

@WebServlet(name = "SellerPublishProduct", value = "/seller/s/publish/product")
@MultipartConfig(maxFileSize = 16177215)
public class SellerPublishProduct extends HttpServlet {

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        Part filePart = request.getPart("productImage");
        byte[] productImage = ImageUpload.getImageAsByte(filePart);
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String productPrice = request.getParameter("productPrice");
        String productQuantity = request.getParameter("productQuantity");
        String productCategory = request.getParameter("productCategory");
        String productDiscount = request.getParameter("productDiscount");

        request.setAttribute("productImage", productImage);
        request.setAttribute("productName", productName);
        request.setAttribute("productDescription", productDescription);
        request.setAttribute("productPrice", productPrice);
        request.setAttribute("productQuantity", productQuantity);
        request.setAttribute("productCategory", productCategory);
        request.setAttribute("productDiscount", productDiscount);

        // get the user
        HttpSession session = request.getSession();
        String sellerId = (String) session.getAttribute("sellerId");

        // perform validation
        if (!sellerFacade.isBankAccountExist(sellerId)) {
            MessageHandler.setMessage(request, Message.BANK_ACCOUNT_BLANK, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        if (!productFacade.isValidNameLength(productName)) {
            request.setAttribute("productName", "");
            MessageHandler.setMessage(request, Message.PRODUCT_NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        if (!productFacade.isValidDescription(productDescription)) {
            request.setAttribute("productDescription", "");
            MessageHandler.setMessage(request, Message.PRODUCT_DESCRIPTION_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        double price = 0;
        try {
            price = Double.parseDouble(productPrice);
        } catch (Exception e) {
            request.setAttribute("productPrice", "");
            MessageHandler.setMessage(request, Message.PRODUCT_PRICE_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
        }
        if (!productFacade.isValidPrice(price)) {
            request.setAttribute("productPrice", "");
            MessageHandler.setMessage(request, Message.PRODUCT_PRICE_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        if (!productFacade.isValidQuantity(Integer.parseInt(productQuantity))) {
            request.setAttribute("productQuantity", "");
            MessageHandler.setMessage(request, Message.PRODUCT_QUANTITY_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        if (!productFacade.isValidDiscount(Integer.parseInt(productDiscount))) {
            request.setAttribute("productDiscount", "");
            MessageHandler.setMessage(request, Message.PRODUCT_DISCOUNT_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }

        Seller seller = sellerFacade.getSellerById(sellerId);

        double discountedPrice = productFacade.findDiscountedPrice(Double.parseDouble(productPrice), Integer.parseInt(productDiscount));

        Product product = new Product(
                seller,productImage,productName,productDescription, Double.parseDouble(productPrice), Integer.parseInt(productQuantity)
                , productCategory, Integer.parseInt(productDiscount), discountedPrice, 0, 0);

        if (productFacade.createProduct(product)) {
            MessageHandler.setMessage(request, Message.PRODUCT_PUBLISH_SUCCESS, ButtonText.UNDERSTAND, JspPage.SELLER_PUBLISH_PRODUCT.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
        } else {
            MessageHandler.setMessage(request, Message.PRODUCT_PUBLISH_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
        }
    }
}
