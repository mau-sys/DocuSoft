package com.docusoft.entidad;

import java.util.ArrayList;
import java.util.List;

public class Guia extends Documento{
    private String subtitulo;
    private String objetivo;
    private Persona autor;

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }
    
    @Override
    public List<String> obtenerDatosDeBusqueda() {
        List<String> datosDeBusqueda = new ArrayList();
        datosDeBusqueda.add(titulo);
        datosDeBusqueda.add(descripcion);
        datosDeBusqueda.add(subtitulo);
        datosDeBusqueda.add(objetivo);
        datosDeBusqueda.add(autor.getNombre() + " " + autor.getApellido());
        return datosDeBusqueda;
    }

    @Override
    public List<String[]> obtenerListaAtributoValor() {
        List<String[]> listaAtributoValor = new ArrayList();
        String[] atributoValor;
        atributoValor = new String[]{"Codigo", codigo};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Título", titulo};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Descripción", descripcion};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Fecha", fecha.toString()};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Subtitulo", subtitulo};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Objetivo", objetivo};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Autor", autor.getNombre() + " " + autor.getApellido()};
        listaAtributoValor.add(atributoValor);
        return listaAtributoValor;
    }
}
