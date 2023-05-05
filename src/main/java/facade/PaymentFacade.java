package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Payment;

import java.util.List;

@Stateless (name = "PaymentFacade")
@LocalBean
public class PaymentFacade extends AbstractFacade<Payment> implements PaymentFacadeI{

    public PaymentFacade() {
        super(Payment.class);
    }

    @Override
    public boolean createPayment(Payment payment) {
        try{
            this.create(payment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editPayment(Payment payment) {
        try{
            this.edit(payment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removePayment(Payment payment) {
        this.remove(payment);
    }

    @Override
    public List<Payment> getAllPayment() {
        return this.findAll();
    }

    @Override
    public List<Payment> getRangePayment(int[] range) {
        return this.findRange(range);
    }

    @Override
    public Payment getPaymentById(String id) {
        return this.find(id);
    }

    @Override
    public int countPayment() {
        return this.count();
    }
}
