package com.example.creditscards.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenDto {

    @JsonProperty("userId")
    private Long userID;
    @JsonProperty("iat")
    private Long iat;
    @JsonProperty("exp")
    private Long exp;

}
