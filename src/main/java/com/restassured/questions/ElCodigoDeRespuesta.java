package com.restassured.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElCodigoDeRespuesta implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static ElCodigoDeRespuesta obtenido(){
        return new ElCodigoDeRespuesta();
    }
}
