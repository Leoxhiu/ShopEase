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

    @Override
    public void signUp(Member member) {
        memberFacade.createMember(member);
    }
}
