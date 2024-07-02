package br.com.alura.cursospring.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IDataConverter{
    <T> T getData(String json, Class<T> clazz) throws JsonProcessingException;
}
