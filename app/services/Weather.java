package services;

import javax.inject.*;

import com.fasterxml.jackson.databind.JsonNode;
import play.Play;
import play.libs.ws.*;
import play.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class Weather {
    private final WSClient ws;
    private final String baseUrl = "http://api.openweathermap.org/data/2.5/weather";
    private final String appId = Play.application().configuration().getString("APP_ID");

    @Inject
    public Weather(WSClient ws) {
        this.ws = ws;
    }

    public Double fetchTemperature() {
        WSRequest request = ws.url(baseUrl);
        WSRequest complexRequest = request.setQueryParameter("zip", "07030")
                .setQueryParameter("appid", appId);
        CompletionStage<JsonNode> jsonPromise = complexRequest.get().thenApply(WSResponse::asJson);
        CompletableFuture<JsonNode> json = jsonPromise.toCompletableFuture();

        String temp;

        try {
            temp = json.get().get("main").get("temp").asText();
            return Double.valueOf(temp) - 273.15;
        } catch(Exception e){
            Logger.warn(e.toString());
            return 0.0;
        }
    }
}
