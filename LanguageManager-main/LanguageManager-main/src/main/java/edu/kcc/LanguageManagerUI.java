package edu.kcc;

import edu.kcc.repository.CountryLanguageRepository;
import edu.kcc.repository.CountryRepository;
import edu.kcc.repository.ICountryLanguageRepository;
import edu.kcc.entity.CountryLanguage;
import edu.kcc.repository.ICountryRepository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LanguageManagerUI extends JFrame {

    private JComboBox<String> cmbCode;
    private JTextArea txtArea;
    private ICountryRepository countryRepository;
    private ICountryLanguageRepository countryLanguageRepository;


    public LanguageManagerUI() {

        countryRepository = new CountryRepository();
        countryLanguageRepository = new CountryLanguageRepository();

        setSize(600, 500);
        setTitle("Language Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container mainPanel = getContentPane();
        mainPanel.setLayout(new BorderLayout());

        txtArea = new JTextArea();
        mainPanel.add(txtArea, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        JLabel label = new JLabel("Country Code:");

        cmbCode = new JComboBox<>();
        cmbCode.addItem("-- Select One --");

        fetchCountryCodes();

        JButton submit = new JButton("Search");
        submit.addActionListener(evt -> {
            String selectCode = (String) cmbCode.getSelectedItem();
            if (selectCode != null && !selectCode.equals("-- Select One --")) {
                fetchLanguages(selectCode);
            }

        });

        topPanel.add(label);
        topPanel.add(cmbCode);
        topPanel.add(submit);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        setVisible(true);
    }
    private void fetchCountryCodes() {
        try{
            List<String> countryCodes = countryRepository.getAllCountryCodes();
            for (String countryCode : countryCodes) {
                cmbCode.addItem(countryCode);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void fetchLanguages(String countryCode) {
        try {
            List<CountryLanguage> languages =
                    countryLanguageRepository.getLanguagesForCountryCode(countryCode);
            txtArea.setText("");
            for (CountryLanguage language : languages) {
                txtArea.append(language.toString() + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String [] args){
        SwingUtilities.invokeLater( () ->
                new LanguageManagerUI() );
    }
}
