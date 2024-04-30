package com.example.creditscards.component;
import com.example.creditscards.dto.TokenDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;

@Component
public class TokenService {

    public boolean checkTokenIsValid(String token){
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = token.split("\\.");
        String payload = new String(decoder.decode(chunks[1]));
        JsonObject jsonObject = JsonParser.parseString(payload)
                .getAsJsonObject();
        TokenDto data = new Gson().fromJson(jsonObject, TokenDto.class);
        Date now = Date.from(ZonedDateTime.now().toInstant());
        return new Date(data.getExp()).getTime() * 1000 > now.getTime();
    }
}
