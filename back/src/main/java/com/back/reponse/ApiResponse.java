package com.back.reponse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiResponse {
    @JsonProperty
    private int status;
    @JsonProperty
    private String message;
    @JsonProperty
    private Date data;
    
    public ApiResponse() {
    }

    public ApiResponse(int status, Date data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public void setSuccess(String message){
        this.status = 200;
        this.data = new Date();
        this.message = message;
    }

    public void setSuccessObj(Object data) {
        this.status = 200;
        this.data = new Date();
        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.message = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            this.status = 500;
            this.message = "Erro ao serializar o objeto.";
        }
    }
    /*public void setSuccess(String message) {
        this.status = 200;
        this.data = new Date();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", message);
        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.message = objectMapper.writeValueAsString(responseMap);
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao serializar o JSON: " + e.getMessage());
        }
    }*/

    public void setBadRequest(String message) {
        this.status = 400;
        this.data = new Date();
        this.message = "Bad Request. " + message;
    }

    public void setServerError(String message) {
        this.status = 500;
        this.data = new Date();
        this.message = "Server Error. " + message;
    }
    
    public int getStatus() {
        return status;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
