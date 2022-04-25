package com.restassured.stepdefinitions;

import com.restassured.questions.ElCodigoDeRespuesta;
import com.restassured.tasks.ConsultarLaListaDeUsuarios;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ConsultarListaUsuariosStepDefinition {
    private EnvironmentVariables environmentVariables;

    @Dado("^que (.*) solicita la lista de usuarios registrados$")
    public void queAndreaSolicitaLaListaDeUsuariosRegistrados(String nombreActor){
        OnStage.theActorCalled(nombreActor).whoCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl")))
                .attemptsTo(ConsultarLaListaDeUsuarios.registrados());
    }

    @Entonces("^debe ver la lista de usuarios exitosamente$")
    public void debeVerLaListaDeUsuariosExitosamente(){
        OnStage.theActorInTheSpotlight().should(seeThat(ElCodigoDeRespuesta.obtenido(), equalTo(200)));
    }

    @Y("^debe ver a (.*) en la lista$")
    public void debeVerAEnLaLista(String nombreUsuario){
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(response->response
                .body("data.first_name", Matchers.hasItem(nombreUsuario))));
    }
}
