package it.nttdata.myschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
            .withUser("carlo")
            .password("pass")
            .roles("ADMIN", "SUPERADMIN")
            .and()
            .withUser("leonardo")
            .password("passleo")
            .roles("altro ruolo", "altor,,,sfs");
    }

    //NOT A GOOD IDEA. Don't do it in production!!
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // disabling csrf here, you should enable it before using in production
            .csrf().disable()
            .authorizeRequests()
           // this matcher is working for all GET/POST/... , any URL matching the reg expression
                .antMatchers("/**").permitAll().anyRequest().authenticated();
    }


    //NOT A GOOD IDEA. Don't do it in production!!
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}