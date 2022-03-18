package com.docusoft.entidad;

public class Persona {
    private int persona_id;
    private String nombre;
    private String apellido;

    public Persona(int persona_id, String nombre, String apellido) {
        this.persona_id = persona_id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
}
