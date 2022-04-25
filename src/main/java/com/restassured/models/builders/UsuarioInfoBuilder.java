package com.restassured.models.builders;

import com.restassured.models.UsuarioInfo;

public class UsuarioInfoBuilder {
    public String name;
    public String job;

    public static UsuarioInfoBuilder con(){
        return new UsuarioInfoBuilder();
    }

    public UsuarioInfoBuilder elNombre(String nombre){
        this.name = nombre;
        return this;
    }

    public UsuarioInfoBuilder yElEmpleo(String empleo){
        this.job = empleo;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public UsuarioInfo build(){
        return new UsuarioInfo(this);
    }
}
