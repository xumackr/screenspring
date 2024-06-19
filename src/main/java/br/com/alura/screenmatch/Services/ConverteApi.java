package br.com.alura.screenmatch.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteApi implements IConverteApi {

    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T converterApi(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json, classe);
    }
}
