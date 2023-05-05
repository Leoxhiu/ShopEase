package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import service.*;
import utility.Email;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sign-up", value = "/sign-up")
public class SignUp extends HttpServlet {

    @EJB
    private AddressService addressService;

    @EJB
    private AdminService adminService;

    @EJB
    private CartService cartService;

    @EJB
    private CustomerService customerService;

    @EJB
    private CustomerOrderService customerOrderService;

    @EJB
    private DiscountService discountService;

    @EJB
    private MemberService memberService;

    @EJB
    private OrderCartService orderCartService;

    @EJB
    private PaymentService paymentService;

    @EJB
    private ProductService productService;

    @EJB
    private ReviewService reviewService;

    @EJB
    private ReviewReplyService reviewReplyService;

    @EJB
    private SellerService sellerService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String get_user_type = request.getParameter("account");

        char user_type = get_user_type.charAt(0);

        PrintWriter out = response.getWriter();

        try {
            Email.sendCode();
            out.println(user_type + " succcess");

            Address address = new Address("latitude", "longitude", "address");
            addressService.create(address);

            Admin admin = new Admin("Member_id");
            adminService.create(admin);

            Cart cart = new Cart("customer_id", "product_id", 50, 20.99);
            cartService.create(cart);

            Customer customer = new Customer("member_id", "img.img", "address_id", 25.50);
            customerService.signUp(customer);

            CustomerOrder customerOrder = new CustomerOrder("customer_id", "payment_id", "date eh");
            customerOrderService.create(customerOrder);

            Discount discount = new Discount("seller_id", "product_id", 30, "05/05/2023");
            discountService.create(discount);

            String name = Email.get_front(email);
            Member new_member = new Member(name, email, confirm_password, user_type);
            memberService.signUp(new_member);

            OrderCart orderCart = new OrderCart("cart_id", "order_id", 45.99, 1);
            orderCartService.create(orderCart);

            Payment payment = new Payment("order_id", 59.99);
            paymentService.create(payment);

            Product product = new Product("seller_id", 2, "img.jpg", "Doll", "This is doll", 99.99, 99, true);
            productService.create(product);

            Review review = new Review("product_id", 4, "Good product");
            reviewService.create(review);

            ReviewReply reviewReply = new ReviewReply("review_id", "customer_id", "seller_id", "Your response are wack");
            reviewReplyService.create(reviewReply);

            Seller seller = new Seller("address_id", "user_id", "img.png", "bank_account", 500.85, true);
            sellerService.create(seller);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        // perform validation checks on the form data
//        if (!confirm_password.equals(password)) {
//            response.setContentType("application/json");
//            response.setStatus(400);
//            PrintWriter out = response.getWriter();
//            String responseString = "{\"message\": \"Password does not match\", \"button\": \"Understand\"}";
//            out.println(responseString);
//            out.close();
//            return;
//        }
//
//        String name = Email.get_front(email);
//        Member new_member = new Member(name, email, confirm_password, user_type);
//        memberService.signUp(new_member);
//
//        // return success response
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        String responseString = "{" +
//                "\"message\": \"Registration success\", " +
//                "\"button\": \"Login now\", " +
//                "\"url\": \"/shopease/customer/sign-in\"" +
//                "}";
//        out.println(responseString);
//        out.close();

    }
}