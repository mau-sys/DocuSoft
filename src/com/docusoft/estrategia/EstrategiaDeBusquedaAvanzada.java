package com.docusoft.estrategia;

import com.docusoft.entidad.Documento;
import java.util.List;

public class EstrategiaDeBusquedaAvanzada implements IEstrategiaDeBusqueda{

    @Override
    public boolean buscarCoincidencia(Documento documento, String texto) {
        boolean esDocumento = false;
        
        String datoDeBusqueda;
        
        List<String> datosDeBusqueda = documento.obtenerDatosDeBusqueda();
        
        int totalDatos = datosDeBusqueda.size();
        
        String[] palabras = texto.split(" ");
        
        for(String palabra : palabras){
            for(int i = 0; i < totalDatos && !esDocumento; i++){
                datoDeBusqueda = datosDeBusqueda.get(i).toLowerCase();
                if(datoDeBusqueda.contains(palabra.toLowerCase())){
                    esDocumento = true;
                }
            }
            if(esDocumento){
                break;
            }
        }
        
        return esDocumento;
    }
    
}
