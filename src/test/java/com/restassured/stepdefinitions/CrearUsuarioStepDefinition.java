package com.restassured.stepdefinitions;

import com.restassured.questions.ElCodigoDeRespuesta;
import com.restassured.questions.ElUsuarioFueCreadoCorrectamente;
import com.restassured.tasks.CrearUsuario;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.restassured.models.builders.UsuarioInfoBuilder.con;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CrearUsuarioStepDefinition {
    private EnvironmentVariables environmentVariables;

    @Dado("^que (.*) crea su usuario con su nombre y su empleo de (.*)$")
    public void queJuanCreaSuUsuarioConSuNombreYSuEmpleo(String nombre, String empleo){
        OnStage.theActorCalled(nombre).whoCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl")))
                .attemptsTo(CrearUsuario.enElSistema(con().elNombre(nombre).yElEmpleo(empleo)));
    }

    @Entonces("^debe ver que su usuario se crea correctamente$")
    public void debeVerQueSuUsuarioSeCreaCorrectamente(){
        OnStage.theActorInTheSpotlight().should(seeThat(ElCodigoDeRespuesta.obtenido(), equalTo(201)));
        OnStage.theActorInTheSpotlight().should(seeThat(ElUsuarioFueCreadoCorrectamente.enElSistema()));
    }
}
