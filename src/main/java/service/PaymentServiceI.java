package service;

import jakarta.ejb.Local;
import model.Payment;

@Local
public interface PaymentServiceI {

    void create(Payment payment);
}
