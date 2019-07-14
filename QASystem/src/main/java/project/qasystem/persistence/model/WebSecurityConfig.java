package project.qasystem.persistence.model;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.*;
        import org.springframework.security.authentication.AuthenticationManager;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import project.qasystem.persistence.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO remove .heaters.frameoption.disable after H2 has be configured correctly
        http.headers().frameOptions().disable();
        http

                //TODO remove csrf.disable after H2 has be configured correctly
                .csrf().disable()

                .authorizeRequests()
                .antMatchers( "/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/questionlist").permitAll()
                .antMatchers("/question").permitAll()

                .antMatchers("/logout").permitAll()
                .antMatchers("/testpage").permitAll()
                .antMatchers("/console/*").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/login_successful", true)
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/logout_successful")
                .permitAll()
                .clearAuthentication(true);
    }
}
