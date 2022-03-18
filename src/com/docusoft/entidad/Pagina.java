package com.docusoft.entidad;

import java.util.ArrayList;
import java.util.List;

public class Pagina extends Documento{
    private String url;
    private Persona propietario;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }
    
    @Override
    public List<String> obtenerDatosDeBusqueda() {
        List<String> datosDeBusqueda = new ArrayList();
        datosDeBusqueda.add(titulo);
        datosDeBusqueda.add(descripcion);
        datosDeBusqueda.add(propietario.getNombre() + " " + propietario.getApellido());
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
        atributoValor = new String[]{"URL", url};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Propietario", propietario.getNombre() + " " + propietario.getApellido()};
        listaAtributoValor.add(atributoValor);
        return listaAtributoValor;
    }
}
