package edu.kcc.repository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

import edu.kcc.utils.Constants;


public class CountryRepository implements ICountryRepository {

    Logger logger = Logger.getLogger(CountryRepository.class.getName());

    @Override
    public List<String> getAllCountryCodes() {
        logger.info("Getting all country codes");
        List<String> countryCodes = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Code FROM Country")) {

            while (rs.next()) {
                countryCodes.add(rs.getString("Code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryCodes;
    }

    private Connection getConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "Technoman54!";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
