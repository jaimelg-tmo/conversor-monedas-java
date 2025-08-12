package com.alura.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaConversion {

    private static final String API_KEY = "a245c4837e4c3a5487b14321"; // Reemplazar con su API Key

    public double obtenerTasaPar(String monedaOrigen, String monedaDestino) throws Exception {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;

        try (HttpClient cliente = HttpClient.newHttpClient()) {
            HttpRequest solicitud = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() != 200) {
                throw new RuntimeException("Error HTTP: " + respuesta.statusCode());
            }

            JsonObject json = JsonParser.parseString(respuesta.body()).getAsJsonObject();
            if (!json.get("result").getAsString().equals("success")) {
                throw new RuntimeException("Error en la respuesta de la API: " + json.get("result").getAsString());
            }

            return json.get("conversion_rate").getAsDouble();
        }
    }
}