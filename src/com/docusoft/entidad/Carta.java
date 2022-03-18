package com.docusoft.entidad;

import java.util.ArrayList;
import java.util.List;

public class Carta extends Documento{
    private String mensaje;
    private Persona remitente;
    private Persona destinatario;

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setRemitente(Persona remitente) {
        this.remitente = remitente;
    }

    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }
    
    @Override
    public List<String> obtenerDatosDeBusqueda() {
        List<String> datosDeBusqueda = new ArrayList();
        datosDeBusqueda.add(titulo);
        datosDeBusqueda.add(descripcion);
        datosDeBusqueda.add(mensaje);
        datosDeBusqueda.add(descripcion);
        datosDeBusqueda.add(remitente.getNombre());
        datosDeBusqueda.add(remitente.getApellido());
        datosDeBusqueda.add(destinatario.getNombre() + " " + destinatario.getApellido());
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
        atributoValor = new String[]{"Mensaje", mensaje};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Remitente", remitente.getNombre() + " " + remitente.getApellido()};
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[]{"Destinatario", destinatario.getNombre() + " " + destinatario.getApellido()};
        listaAtributoValor.add(atributoValor);
        return listaAtributoValor;
    }
}
