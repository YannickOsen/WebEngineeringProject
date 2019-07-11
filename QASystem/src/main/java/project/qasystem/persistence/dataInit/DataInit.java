/**package project.qasystem.persistence.dataInit;

import project.qasystem.persistence.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.LinkedList;

public class DataInit {


    // Variables used to configure the Application
    private final boolean alwaysClearDb = true;
    private final boolean fillWithExampleData = true;
 **/



    /*
    private JdbcTemplate jdbcTemplate;
        /**
         * Initiates the data when this wasn't already done.
         *
         * @param jdbcTemplate jdbc Connection to the Database.

    public DataInit(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
        if (alwaysClearDb) {
            initateDatabase();
        } else {
            switch (checkTables()) {
                case "AllExisting":
                    break;
                case "FirstLaunch":
                    initateDatabase();
                    break;
                case "Error":
            }
        }
    }*/


  /**  public DataInit() {
        initiateDatabase();
    }

    //TODO check if all/some/zero Tables were initialised before
    private String checkTables() {
        return null;
    }

 /**   private void initiateDatabase() {
        initTables();
        // create addAdmin() if necessary;
        if (fillWithExampleData) {
            fillUsers();
            fillQuestions();
            fillAnswers();
        }
    }


 /**   private void initTables() {
        DataBaseService.getInstance().createTables();
    }

    private void fillUsers(){
        DataBaseService db = DataBaseService.getInstance();
        LinkedList<String[]> initTestData = new LinkedList<>();
        String[] TestUser1 ={"Karl", "schlechtesPasswort"};
        String[] TestUser2 ={"Dieter77", "passwort77"};
        String[] TestUser3 ={"PakaAlpaca", "ayayayaya"};
        initTestData.add(TestUser1);
        initTestData.add(TestUser2);
        initTestData.add(TestUser3);
        for (String[] o : initTestData) {
            db.insertUser(o[0], o[1]);
        }
        db.setAdvancedUserData();
    }

    private void fillQuestions(){
        DataBaseService.getInstance().insertQuestion("Wie erstelle ich Fragen?", "Hier sind nur so komische leere Felder? HIlfeß HalLO?!", "Karl");
        DataBaseService.getInstance().insertQuestion("Wo ist die Toilette", "Weiß das Jemand", "Dieter77");
    }


    private void fillAnswers(){
        DataBaseService.getInstance().insertAnswer(0, "GEFUNDEN", "Karl");
        DataBaseService.getInstance().insertAnswer(1, "Oben rechts", "PakaAlpaca");
    }

}
   **/
