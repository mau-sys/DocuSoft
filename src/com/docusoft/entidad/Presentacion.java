package com.docusoft.entidad;

import java.util.ArrayList;
import java.util.List;

public class Presentacion extends Documento{
    private String tema;
    private Persona presentador;

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setPresentador(Persona presentador) {
        this.presentador = presentador;
    }
    
    @Override
    public List<String> obtenerDatosDeBusqueda() {
        List<String> datosDeBusqueda = new ArrayList();
        datosDeBusqueda.add(titulo);
        datosDeBusqueda.add(descripcion);
        datosDeBusqueda.add(tema);
        datosDeBusqueda.add(presentador.getNombre() + " " + presentador.getApellido());
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
        atributoValor = new String[]{"Tema", tema};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Presentador", presentador.getNombre() + " " + presentador.getApellido()};
        listaAtributoValor.add(atributoValor);
        return listaAtributoValor;
    }
}
