package com.restassured.questions;

import com.restassured.models.UsuarioInfo;
import com.restassured.utils.OperacionesJson;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

import static com.restassured.tasks.CrearUsuario.DATA_USUARIO;
import static com.restassured.utils.OperacionesJson.convertirAMap;

public class ElUsuarioFueCreadoCorrectamente implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        UsuarioInfo usuarioInfo = actor.recall(DATA_USUARIO);
        Map respuesta = convertirAMap(SerenityRest.lastResponse().body().prettyPrint());
        return usuarioInfo.getName().equals(respuesta.get("name")) && usuarioInfo.getJob().equals(respuesta.get("job"));
    }

    public static ElUsuarioFueCreadoCorrectamente enElSistema(){
        return new ElUsuarioFueCreadoCorrectamente();
    }
}
