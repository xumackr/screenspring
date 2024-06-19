package br.com.alura.screenmatch.Services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteApi {

    <T> T converterApi (String json, Class <T> classe) throws JsonProcessingException;

}
