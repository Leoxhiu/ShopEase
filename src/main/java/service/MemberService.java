package service;

import facade.AddressFacade;
import facade.CustomerFacade;
import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Address;
import model.Customer;
import model.Member;
import model.Seller;

@Stateless(name = "MemberService")
@LocalBean
public class MemberService implements MemberServiceI{

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private AddressFacade addressFacade;

    @Override
    public boolean signUp(Member member) {
        boolean isSuccess = memberFacade.createMember(member);

        if(member.getUserType() == 'c' && isSuccess){
            // perform customer registration
            Address address = new Address("", "", "");
            isSuccess = addressFacade.createAddress(address);

            Customer customer = new Customer(member, address, 0);
            isSuccess = customerFacade.createCustomer(customer);

            return isSuccess;

        } else if (member.getUserType() == 's' && isSuccess){
            // perform seller registration
            Address address = new Address("", "", "");

            return isSuccess;

        } else if (member.getUserType() == 'a' && isSuccess){
            // perform admin registration
            return isSuccess;
        }

        return isSuccess;
    }
}
