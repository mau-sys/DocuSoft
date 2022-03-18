package com.docusoft.entidad;

import java.util.ArrayList;
import java.util.List;

public class Libro extends Documento{
    private String especialidad;
    private String editorial;
    private String idioma;
    private String isbn;
    private int paginas;
    private List<Persona> autores;
    private List<Capitulo> capitulos;

    public Libro() {
        autores = new ArrayList();
        capitulos = new ArrayList();
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    public void agregarCapitulo(Capitulo capitulo){
        capitulos.add(capitulo);
    }
    
    public void agregarAutor(Persona autor){
        autores.add(autor);
    }
    
    @Override
    public List<String> obtenerDatosDeBusqueda() {
        List<String> datosDeBusqueda = new ArrayList();
        datosDeBusqueda.add(titulo);
        datosDeBusqueda.add(descripcion);
        datosDeBusqueda.add(especialidad);
        for(Persona autor : autores) {
            datosDeBusqueda.add(autor.getNombre() + " " + autor.getApellido());
        }
        for(Capitulo capitulo : capitulos) {
            datosDeBusqueda.add(capitulo.getTitulo());
            datosDeBusqueda.add(capitulo.getObjetivo());
        }
        return datosDeBusqueda;
    }

    @Override
    public List<String[]> obtenerListaAtributoValor() {
        List<String[]> listaAtributoValor = new ArrayList();
        String[] atributoValor;
        atributoValor = new String[2];
        atributoValor[0] = "Código";
        atributoValor[1] = codigo;
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[2];
        atributoValor[0] = "Título";
        atributoValor[1] = titulo;
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[2];
        atributoValor[0] = "Descripción";
        atributoValor[1] = descripcion;
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[2];
        atributoValor[0] = "Fecha";
        atributoValor[1] = fecha.toString();
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[2];
        atributoValor[0] = "Especialidad";
        atributoValor[1] = especialidad;
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[2];
        atributoValor[0] = "Editorial";
        atributoValor[1] = editorial;
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[2];
        atributoValor[0] = "Idioma";
        atributoValor[1] = idioma;
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[2];
        atributoValor[0] = "Páginas";
        atributoValor[1] = Integer.toString(paginas);
        listaAtributoValor.add(atributoValor);
        atributoValor = new String[2];
        atributoValor[0] = "ISBN";
        atributoValor[1] = isbn;
        listaAtributoValor.add(atributoValor);
        String cadenaDeAutores = "";
        Persona autor;
        for (int i = 0; i < autores.size(); i++) {
            autor = autores.get(i);
            cadenaDeAutores += autor.getNombre() + " " + autor.getApellido();
            if (i < (autores.size() - 1)) {
                cadenaDeAutores += "; ";
            }
        }
        atributoValor = new String[2];
        atributoValor[0] = "Autores";
        atributoValor[1] = cadenaDeAutores;
        listaAtributoValor.add(atributoValor);
        for (Capitulo capitulo : capitulos) {
            atributoValor = new String[2];
            atributoValor[0] = "Capítulo";
            atributoValor[1] = capitulo.getTitulo();
            listaAtributoValor.add(atributoValor);
            atributoValor = new String[2];
            atributoValor[0] = "Objetivo";
            atributoValor[1] = capitulo.getObjetivo();
            listaAtributoValor.add(atributoValor);
        }
        return listaAtributoValor;
    }
}
