package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.ProductService;
import utility.*;

import java.io.IOException;

@WebServlet(name = "SellerPublishProduct", value = "/seller/s/publish/product")
@MultipartConfig(maxFileSize = 16177215)
public class SellerPublishProduct extends HttpServlet {

    @EJB
    private ProductService productService;

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

        // perform validation
        if(!productService.isValidNameLength(productName)){
            request.setAttribute("productName", "");
            MessageHandler.setMessage(request, Message.PRODUCT_NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        if(!productService.isValidDescription(productDescription)){
            request.setAttribute("productDescription", "");
            MessageHandler.setMessage(request, Message.PRODUCT_DESCRIPTION_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        double price = 0;
        try{
            price = Double.parseDouble(productPrice);
        } catch(Exception e){
            request.setAttribute("productPrice", "");
            MessageHandler.setMessage(request, Message.PRODUCT_PRICE_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
        }
        if(!productService.isValidPrice(price)){
            request.setAttribute("productPrice", "");
            MessageHandler.setMessage(request, Message.PRODUCT_PRICE_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        if(!productService.isValidQuantity(Integer.parseInt(productQuantity))){
            request.setAttribute("productQuantity", "");
            MessageHandler.setMessage(request, Message.PRODUCT_QUANTITY_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }
        if(!productService.isValidDiscount(Integer.parseInt(productDiscount))){
            request.setAttribute("productDiscount", "");
            MessageHandler.setMessage(request, Message.PRODUCT_DISCOUNT_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
            return;
        }

        // get the user
        HttpSession session = request.getSession();
        String sellerId = (String) session.getAttribute("sellerId");

        if(productService.publish(
                sellerId, productImage, productName, productDescription,
                Double.parseDouble(productPrice), Integer.parseInt(productQuantity),productCategory,
                Integer.parseInt(productDiscount)
        )){
            MessageHandler.setMessage(request, Message.PRODUCT_PUBLISH_SUCCESS, ButtonText.UNDERSTAND, JspPage.SELLER_PUBLISH_PRODUCT.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
        } else {
            MessageHandler.setMessage(request, Message.PRODUCT_PUBLISH_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PUBLISH_PRODUCT.getPath());
        }
    }
}
