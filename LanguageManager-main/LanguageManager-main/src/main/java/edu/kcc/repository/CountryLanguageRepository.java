package edu.kcc.repository;

import edu.kcc.entity.CountryLanguage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class CountryLanguageRepository implements ICountryLanguageRepository {

    Logger logger = Logger.getLogger(CountryLanguageRepository.class.getName());

    @Override
    public List<CountryLanguage> getLanguagesForCountryCode(String code) {
        logger.info(String.format("Getting languages for %s", code));
        List<CountryLanguage> languages = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM CountryLanguage WHERE CountryCode = '" + code + "'")) {
            while (rs.next()) {
                CountryLanguage cl = new CountryLanguage(
                        rs.getString("CountryCode"),
                        rs.getString("Language"),
                        rs.getBoolean("IsOfficial"),
                        rs.getFloat("Percentage")
                );
                languages.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

        private Connection getConnection() throws Exception{
            String url = "jdbc:mysql://localhost:3306/world";
            String user = "root";
            String password = "Technoman54!";
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        }
    }
