package service;

import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Member;

@Stateless(name = "MemberService")
@LocalBean
public class MemberService implements MemberServiceI{

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private CustomerService customerService;

    @EJB
    private SellerService sellerService;


    @Override
    public boolean isExist(String email) {

        Member member = memberFacade.getMemberByEmail(email);
        return member != null;
    }

    @Override
    public boolean signUp(Member member) {

        if(memberFacade.createMember(member)){
            if(member.getUserType() == 'c'){
                // perform customer registration
                return customerService.signUp(member);

            } else if (member.getUserType() == 's'){
                // perform seller registration
                return sellerService.signUp(member);

            } else if (member.getUserType() == 'a'){
                // perform admin registration
                //return isSuccess;
            }
        }

        return false;
    }

    @Override
    public boolean updatePassword(String email, String password) {
        Member member = memberFacade.getMemberByEmail(email);
        member.setPassword(password);
        return memberFacade.editMember(member);
    }
}