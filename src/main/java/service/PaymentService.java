package service;

import facade.PaymentFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Payment;

@Stateless (name = "PaymentService")
@LocalBean
public class PaymentService implements PaymentServiceI{

    @EJB
    private PaymentFacade paymentFacade;

    @Override
    public void create(Payment payment) {
        paymentFacade.createPayment(payment);
    }
}
