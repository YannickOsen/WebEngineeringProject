package project.qasystem.persistence.model;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.*;
        import org.springframework.security.authentication.AuthenticationManager;
        import org.springframework.security.authentication.AuthenticationProvider;
        import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.core.userdetails.User;
        import org.springframework.security.core.userdetails.UserDetails;
//        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import project.qasystem.persistence.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan({"project.qasystem.persistence.controller"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
        userDetailsService = new CustomUserDetailsService();
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
                .antMatchers("/newquestion").permitAll()

                .antMatchers("/logout").permitAll()
                .antMatchers("/testpage").permitAll()
                .antMatchers("/console/*").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .clearAuthentication(true);
    }
}
