package project.qasystem.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import project.qasystem.persistence.model.User;
import project.qasystem.persistence.repositories.QuestionRepository;
import project.qasystem.persistence.repositories.UserRepository;
import project.qasystem.persistence.service.DataBaseService;

import javax.swing.*;

@SpringBootApplication
public class StartWebApplication {


    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(StartWebApplication.class).headless(false).run(args);
    }

    ;

    /**
     * Class that handles database initialization on startup
     */
    @Component
    class DemoCommandLineRunner implements CommandLineRunner {

        @Autowired
        DataBaseService dbService;

        @Override
        public void run(String... args) throws Exception {
            int n = JOptionPane.showConfirmDialog(
                    null,
                    "Sollen Standard-Werte in die Datenbank eingetragen werden?",
                    "Datenbank-Initialisierung",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                dbService.initializeData();
                JOptionPane.showMessageDialog(null, "Ein Nutzerkonto, eine Frage und eine Antwort wurden angelegt. " +
                        "\nNutzername: defaultuser \nPasswort: password", "Datenbank-Initialisierung", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Es wurden keine Daten angelegt.", "Datenbank-Initialisierung", 1);
            }
        }
    }
}





