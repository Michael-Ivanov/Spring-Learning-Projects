package miv.study.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addSomething() {
            System.out.println(getClass() + ": DOING STUFF. ADDING SOMETHING");
    }
}
