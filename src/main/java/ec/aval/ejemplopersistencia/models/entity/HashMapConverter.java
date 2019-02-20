package ec.aval.ejemplopersistencia.models.entity;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

	private static final Logger logger = LoggerFactory.getLogger(HashMapConverter.class);
	
    @Override
    public String convertToDatabaseColumn(Map<String, Object> properties) {
        String propertiesJson = null;
        try {
        	propertiesJson = new ObjectMapper().writeValueAsString(properties);
        } catch (final JsonProcessingException e) {
            logger.error("JSON writing error", e);
        }
        return propertiesJson;
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public Map<String, Object> convertToEntityAttribute(String propertiesJson) {
        Map<String, Object> properties = null;
        try {
        	properties = new ObjectMapper().readValue(propertiesJson, Map.class);
        } catch (final IOException e) {
            logger.error("JSON reading error", e);
        }
        return properties;
    }
 
}
