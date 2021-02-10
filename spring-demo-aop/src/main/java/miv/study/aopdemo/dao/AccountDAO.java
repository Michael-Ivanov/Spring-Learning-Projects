package miv.study.aopdemo.dao;

import miv.study.aopdemo.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceName;


    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John", "Silver"));
        accounts.add(new Account("Madhu", "Platinum"));
        accounts.add(new Account("Luca", "Gold"));

        return accounts;
    }

    public void addAccount(String... param) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": DOING MY BOOLEAN WORK HERE");
        return true;
    }

    public String getName() {
        System.out.println(getClass() + ": DOING MY getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": DOING MY setName");
        this.name = name;
    }

    public String getServiceName() {
        System.out.println(getClass() + ": DOING MY getServiceName");
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        System.out.println(getClass() + ": DOING MY setServiceName");
        this.serviceName = serviceName;
    }
}
