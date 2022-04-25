package com.restassured.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/crear_usuario.feature",
        glue = {"com/restassured/stepdefinitions"}
)
public class CrearUsuarioRunner {
}
