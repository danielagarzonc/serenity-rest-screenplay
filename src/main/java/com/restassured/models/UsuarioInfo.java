package com.restassured.models;

import com.restassured.models.builders.UsuarioInfoBuilder;

public class UsuarioInfo {
    private String name;
    private String job;

    public UsuarioInfo(UsuarioInfoBuilder usuarioInfoBuilder){
        this.name = usuarioInfoBuilder.getName();
        this.job = usuarioInfoBuilder.getJob();
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
