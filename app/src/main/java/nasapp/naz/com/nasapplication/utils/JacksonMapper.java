package nasapp.naz.com.nasapplication.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Bryan on 30/03/2017.
 */

public class JacksonMapper {

    public static <T> T mapToObject(Class<T> classToMap, String input) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(input, classToMap);
    }

    public static <T> String mapToString(T input) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(input);
    }
}
