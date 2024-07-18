package edu.kcc.entity;

import lombok.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryLanguage {
    private String countryCode;
    private String language;
    private boolean isOfficial;
    private double percent;

    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
