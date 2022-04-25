package com.restassured.tasks;

import com.restassured.models.UsuarioInfo;
import com.restassured.models.builders.UsuarioInfoBuilder;
import com.restassured.utils.OperacionesJson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.restassured.utils.OperacionesJson.convertirAJson;

public class CrearUsuario implements Task {
    private static final String ENDPOINT = "/api/users?page=2";
    public static final String DATA_USUARIO = "Datos del usuario";
    private UsuarioInfo usuarioInfo;

    public CrearUsuario(UsuarioInfo usuarioInfo){
        this.usuarioInfo = usuarioInfo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(ENDPOINT)
                .with(
                        request->
                                request.header("Content-Type", "application/json")
                                        .body(convertirAJson(usuarioInfo))
                ));
        actor.remember(DATA_USUARIO, usuarioInfo);
    }

    public static CrearUsuario enElSistema(UsuarioInfoBuilder usuarioInfoBuilder){
        return Tasks.instrumented(CrearUsuario.class, usuarioInfoBuilder.build());
    }
}
