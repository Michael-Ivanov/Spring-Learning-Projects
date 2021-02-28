package miv.study.thymeleafdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ROLE_EMPLOYEE = "EMPLOYEE";
    private static final String ROLE_MANAGER = "MANAGER";
    private static final String ROLE_ADMIN = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // add users for in-memory authentication

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles(ROLE_EMPLOYEE))
                .withUser(users.username("mary").password("test123").roles(ROLE_MANAGER))
                .withUser(users.username("susan").password("test123").roles(ROLE_ADMIN));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/employees/*Employee").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateUser")
                        .defaultSuccessUrl("/employees/list")
                        .permitAll()
                .and()
                .logout()
                        .permitAll()
                        .logoutSuccessUrl("/home");

    }
}
