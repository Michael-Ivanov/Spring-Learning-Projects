package miv.study.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSomething() {
            System.out.println(getClass() + ": DOING STUFF. ADDING SOMETHING");

            return true;
    }
}
