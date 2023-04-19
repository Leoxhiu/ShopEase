package service;

import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Member;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Stateless(name = "MemberService")
@LocalBean
public class MemberService implements MemberServiceI{

    @EJB
    private MemberFacade memberFacade;

    @Override
    public String getFrontEmail(String email){
        Pattern pattern = Pattern.compile("^(.*?)@");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            String result = matcher.group(1);
            return result;
        }
        return email;
    }

    @Override
    public void signUp(Member member) {
        memberFacade.createMember(member);
    }
}
