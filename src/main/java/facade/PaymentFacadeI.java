package facade;

import jakarta.ejb.Local;
import model.Payment;


import java.util.List;

@Local
public interface PaymentFacadeI {
    boolean createPayment(Payment payment);
    boolean editPayment(Payment payment);
    void removePayment(Payment payment);
    List<Payment> getAllPayment();
    List<Payment> getRangePayment(int[] range);
    Payment getPaymentById(String id);
    int countPayment();
}
