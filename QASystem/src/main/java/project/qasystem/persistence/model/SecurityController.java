package project.qasystem.persistence.model;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
        import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class SecurityController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
        registry.addViewController("/login").setViewName("signin");
        registry.addViewController("/registration").setViewName("register");
    }
}
