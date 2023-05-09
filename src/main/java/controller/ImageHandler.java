package controller;
import facade.MemberFacade;
import facade.ProductFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Member;
import model.Product;

import java.io.*;

@WebServlet(name = "ImageHandler", value = "/images/*")
public class ImageHandler extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String memberId = request.getParameter("memberId");
        String productId = request.getParameter("productId");

        if(memberId != null){
            Member member = memberFacade.getMemberById(memberId);
            byte[] profile = member.getProfile();
            response.setContentType("image/jpeg"); // Set the content type of the response to image/png
            response.setContentLength(profile.length); // Set the content length of the response to the length of the image data
            response.getOutputStream().write(profile); // Write the image data to the response output stream
            response.getOutputStream().flush();
            response.getOutputStream().close();
            return;
        }

        if(productId != null){
            Product product = productFacade.getProductById(productId);
            byte[] image = product.getImage();
            response.setContentType("image/jpeg"); // Set the content type of the response to image/png
            response.setContentLength(image.length); // Set the content length of the response to the length of the image data
            response.getOutputStream().write(image); // Write the image data to the response output stream
            response.getOutputStream().flush();
            response.getOutputStream().close();
            return;
        }

        ServletContext sc = getServletContext();
        try (InputStream is = sc.getResourceAsStream("/images"+request.getPathInfo())) {
            OutputStream os = response.getOutputStream();
            if (is == null) {
                response.setContentType("text/plain");
                os.write("Failed".getBytes());
            } else {
                response.setContentType("image/jpeg");
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        }
    }

}