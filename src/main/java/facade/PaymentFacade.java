package facade;

import jakarta.ejb.Stateless;
import model.Payment;

import java.util.List;

@Stateless
public class PaymentFacade extends AbstractFacade<Payment>{

    public PaymentFacade() {
        super(Payment.class);
    }

    public boolean createPayment(Payment payment) {
        try{
            this.create(payment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editPayment(Payment payment) {
        try{
            this.edit(payment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void removePayment(Payment payment) {
        this.remove(payment);
    }

    public List<Payment> getAllPayment() {
        return this.findAll();
    }

    public List<Payment> getRangePayment(int[] range) {
        return this.findRange(range);
    }

    public Payment getPaymentById(String id) {
        return this.find(id);
    }

    public int countPayment() {
        return this.count();
    }
}