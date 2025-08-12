package com.alura.conversor;

import com.google.gson.JsonObject;

public class RespuestaConversion {

    private JsonObject tasas;

    public RespuestaConversion(JsonObject tasas) {
        this.tasas = tasas;
    }

    public double getTasa(String codigoMoneda) {
        if (!tasas.has(codigoMoneda)) {
            throw new IllegalArgumentException("Moneda no soportada: " + codigoMoneda);
        }
        return tasas.get(codigoMoneda).getAsDouble();
    }
}