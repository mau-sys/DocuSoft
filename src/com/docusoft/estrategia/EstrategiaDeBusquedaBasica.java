package com.docusoft.estrategia;

import com.docusoft.entidad.Documento;

public class EstrategiaDeBusquedaBasica implements IEstrategiaDeBusqueda{

    @Override
    public boolean buscarCoincidencia(Documento documento, String texto) {
        boolean esDocumento = false;
        
        String titulo = documento.getTitulo().toLowerCase();
        
        String descripcion = documento.getDescripcion().toLowerCase();
        
        String[] palabras = texto.split(" ");
        
        for(String palabra : palabras){
            if(titulo.contains(palabra.toLowerCase())){
                esDocumento = true;
                break;
            }
            
            if(descripcion.contains(palabra.toLowerCase())){
                esDocumento = true;
                break;
            }
        }
        
        return esDocumento;
    }
    
}
