package controller;

import facade.CartFacade;
import facade.MemberFacade;
import facade.ReviewFacade;
import facade.ReviewReplyFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Member;
import model.Review;
import model.ReviewReply;
import utility.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SellerSalesReview", value = {"/seller/sales/review", "/seller/s/sales/review"})
public class SellerSalesReview extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private CartFacade cartFacade;

    @EJB
    private ReviewFacade reviewFacade;

    @EJB
    private ReviewReplyFacade reviewReplyFacade;

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
        ServletNavigation.forwardRequest(request,response, JspPage.SELLER_SALES_REVIEW.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reviewId = request.getParameter("reviewId");
        Review review = reviewFacade.getReviewById(reviewId);

        String comment = request.getParameter("comment");

        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("memberId");
        Member member = memberFacade.getMemberById(memberId);

        ReviewReply reviewReply = new ReviewReply(review, member, comment);

        if(reviewReplyFacade.createReviewReply(reviewReply)){

            MessageHandler.setMessage(request, Message.COMMENT_SUCCESS, ButtonText.UNDERSTAND, JspPage.SELLER_SALES.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_SALES_REVIEW.getPath());

        } else{
            MessageHandler.setMessage(request, Message.COMMENT_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_SALES_REVIEW.getPath());
        }
    }
}
