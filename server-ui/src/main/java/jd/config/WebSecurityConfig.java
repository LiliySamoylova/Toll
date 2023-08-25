package jd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css", "/image", "/css/**").permitAll() // "/css/**", "/css/homeStyle.css"
                .antMatchers("/", "/home", "/error").authenticated()
                .antMatchers("/routes").hasRole("CLIENT")
                .antMatchers("/payments").hasRole("CLIENT")
                .antMatchers("/registerClient").hasRole("MANAGER")
                .antMatchers("/registerManager").hasRole("ROOT")
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("client").password("123").roles("CLIENT")
                .and()
                .withUser("manager").password("456").roles("MANAGER", "CLIENT")
                .and()
                .withUser("root").password("789").roles("ROOT", "MANAGER", "CLIENT");
    }
}
