package com.docusoft.entidad;

import java.time.LocalDate;
import java.util.List;
import com.docusoft.estrategia.IEstrategiaDeBusqueda;
import com.docusoft.estrategia.EstrategiaDeBusquedaBasica;
import com.docusoft.estrategia.EstrategiaDeBusquedaAvanzada;

public abstract class Documento {
    protected String codigo;
    protected String titulo;
    protected String descripcion;
    protected LocalDate fecha;
    private IEstrategiaDeBusqueda estrategiaDeBusqueda;

    public Documento() {
        /*  Si esta en estrategia basica y luego se quiere cambiar a avanzada
        solamente se quita la estrategia de busqueda basica y se reemplaza por
        estrategia de busqueda avanzada */
        
        /*estrategiaDeBusqueda = new EstrategiaDeBusquedaBasica();*/
        
        estrategiaDeBusqueda = new EstrategiaDeBusquedaAvanzada();
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public Object[] obtenerVectorDatos(){
        Object[] vectorDatos = {codigo, titulo, descripcion, fecha};
        return vectorDatos;
    }
    
    public boolean buscarCoincidencia(String texto){
        return estrategiaDeBusqueda.buscarCoincidencia(this, texto);
    }
    
    public abstract List<String> obtenerDatosDeBusqueda();
    
    public abstract List<String[]> obtenerListaAtributoValor();
}
