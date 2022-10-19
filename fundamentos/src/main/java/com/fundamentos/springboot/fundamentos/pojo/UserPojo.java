package com.fundamentos.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
public class UserPojo {

    private String email;
    private String nombre;
    private String apellido;
    private String password;
    private int edad;

    public UserPojo(String email, String nombre, String apellido, String password, int edad) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.edad = edad;
    }

    public String getCorreo() {
        return email
                ;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContraseña() {
        return password;
    }

    public int getEdad() {
        return edad;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
