package com.docusoft.estrategia;

import com.docusoft.entidad.Documento;

public interface IEstrategiaDeBusqueda {

    public boolean buscarCoincidencia(Documento documento, String texto);
}
