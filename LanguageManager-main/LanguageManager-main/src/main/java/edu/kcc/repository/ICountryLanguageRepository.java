package edu.kcc.repository;

import edu.kcc.entity.CountryLanguage;

import java.util.List;

public interface ICountryLanguageRepository {
    List<CountryLanguage> getLanguagesForCountryCode(String code);
}
