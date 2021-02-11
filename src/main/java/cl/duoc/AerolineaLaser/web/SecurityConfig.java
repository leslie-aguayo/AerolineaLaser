package cl.duoc.AerolineaLaser.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN","USERTURISMO","USERPREMIUM")
                .and()
                .withUser("usertur")
                .password("{noop}123")
                .roles("USERTURISMO")
                .and()
                .withUser("userpre")
                .password("{noop}123")
                .roles("USERPREMIUM");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/servicioPremium","/servicioTurismo")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USERTURISMO","USERPREMIUM","ADMIN")                
                .antMatchers("/servicioPremium")
                .hasRole("USERPREMIUM")
                .antMatchers("/servicioTurismo")
                .hasRole("USERTURISMO")
                .and()
                .formLogin()
                        .loginPage("/login")                
                .and()                
                .exceptionHandling().accessDeniedPage("/login")
                .and()
              .logout()                              
                  .logoutSuccessUrl("/logout");
    }
    
}
