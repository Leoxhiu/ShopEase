package controller;

import facade.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;
import utility.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerReviewDetail", value = {"/customer/review/detail", "/customer/s/review/detail"})
public class CustomerReviewDetail extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private CartFacade cartFacade;

    @EJB
    private ReviewFacade reviewFacade;

    @EJB
    private ReviewReplyFacade reviewReplyFacade;

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cartId = request.getParameter("cartId");
        Cart cart = cartFacade.getCartById(cartId);

        Review review = reviewFacade.getReviewByCartId(cartId);

        List<ReviewReply> reviewReplyList = reviewReplyFacade.getReviewReplyByReviewId(review.getId());

        request.setAttribute("cart", cart);
        request.setAttribute("reviewId", review.getId());
        request.setAttribute("review", review);
        request.setAttribute("reviewReplyList", reviewReplyList);
        ServletNavigation.forwardRequest(request,response, JspPage.CUSTOMER_REVIEW_DETAIL.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reviewId = request.getParameter("reviewId");
        String postFeedback = request.getParameter("feedback");
        String postComment = request.getParameter("comment");

        Review review = reviewFacade.getReviewById(reviewId);

        if(postFeedback != null){

            String rating = request.getParameter("rating");
            String feedback = request.getParameter("feedback");

            if(reviewFacade.update(reviewId, Integer.parseInt(rating), feedback)){

                Cart cart = cartFacade.getCartById(review.getCart().getId());
                Product product = productFacade.getProductById(cart.getProduct().getId());

                // get purchased carts that have the product
                List<Cart> cartList = cartFacade.getPurchasedCartByProductId(product.getId());

                List<Review> reviewList = new ArrayList<>();
                for (Cart purchasedCart : cartList) {
                    Review cartReview = reviewFacade.getReviewByCartId(purchasedCart.getId());
                    reviewList.add(cartReview);
                }

                int totalRating = 0;
                int totalReview = 0;

                for (Review relatedReview : reviewList){
                    // skip 0 rating
                    if(relatedReview.getRating() != 0){
                        totalRating += relatedReview.getRating();
                        totalReview ++;
                    }
                }

                int newRating = (int) Math.round((double) totalRating / totalReview);

                productFacade.updateRating(product.getId(), newRating);

                MessageHandler.setMessage(request, Message.FEEDBACK_SUCCESS, ButtonText.UNDERSTAND, JspPage.CUSTOMER_REVIEW.getUrl());
                ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_REVIEW_DETAIL.getPath());

            } else {
                MessageHandler.setMessage(request, Message.FEEDBACK_FAILED, ButtonText.UNDERSTAND, "");
                ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_REVIEW_DETAIL.getPath());
            }

        } else if (postComment != null) {

            String comment = request.getParameter("comment");

            HttpSession session = request.getSession();
            String memberId = (String) session.getAttribute("memberId");
            Member member = memberFacade.getMemberById(memberId);

            ReviewReply reviewReply = new ReviewReply(review, member, comment);

            if(reviewReplyFacade.createReviewReply(reviewReply)){

                MessageHandler.setMessage(request, Message.COMMENT_SUCCESS, ButtonText.UNDERSTAND, JspPage.CUSTOMER_REVIEW.getUrl());
                ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_REVIEW_DETAIL.getPath());

            } else{
                MessageHandler.setMessage(request, Message.COMMENT_FAILED, ButtonText.UNDERSTAND, "");
                ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_REVIEW_DETAIL.getPath());
            }
        }
    }
}
