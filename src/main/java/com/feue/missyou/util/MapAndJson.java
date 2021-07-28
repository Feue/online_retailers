package com.feue.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feue.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-07-26 11:01
 */
@Converter
public class MapAndJson implements AttributeConverter<Map<String, Object>, String> {
    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        try {
            if (dbData == null) {
                return null;
            }
            return mapper.readValue(dbData, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
