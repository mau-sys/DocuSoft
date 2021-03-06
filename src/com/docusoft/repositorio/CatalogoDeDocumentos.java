package com.docusoft.repositorio;

import com.docusoft.entidad.Capitulo;
import com.docusoft.entidad.Carta;
import com.docusoft.entidad.Documento;
import com.docusoft.entidad.Guia;
import com.docusoft.entidad.Libro;
import com.docusoft.entidad.Pagina;
import com.docusoft.entidad.Persona;
import com.docusoft.entidad.Presentacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CatalogoDeDocumentos {

    private List<Documento> documentos;
    private static CatalogoDeDocumentos catalogoDeDocumentos;

    private CatalogoDeDocumentos() {
        cargarDocumentos();
    }

    public static CatalogoDeDocumentos obtenerInstancia() {
        if (catalogoDeDocumentos == null) {
            catalogoDeDocumentos = new CatalogoDeDocumentos();
        }
        return catalogoDeDocumentos;
    }

    public Object[][] obtenerDocumentos() {
        return obtenerMatrizDeDocumentos(documentos);
    }

    private Object[][] obtenerMatrizDeDocumentos(List<Documento> listaDocumentos) {
        Documento documento;
        int filas = listaDocumentos.size();
        Object matrizDeDocumentos[][] = new Object[filas][4];
        for (int i = 0; i < filas; i++) {
            documento = listaDocumentos.get(i);
            matrizDeDocumentos[i] = documento.obtenerVectorDatos();
        }
        return matrizDeDocumentos;
    }

    public Object[][] buscarDocumentos(String texto) {
        List<Documento> documentosBuscados = new ArrayList();
        for (Documento documento : documentos) {
            if (documento.buscarCoincidencia(texto)) {
                documentosBuscados.add(documento);
            }
        }
        return obtenerMatrizDeDocumentos(documentosBuscados);
    }

    public Documento buscar(String codigo) {
        Documento documentoBuscado = null;
        for (Documento documento : documentos) {
            if (documento.getCodigo().equals(codigo)) {
                documentoBuscado = documento;
                break;
            }
        }
        return documentoBuscado;
    }

    public void cargarDocumentos() {
        documentos = new ArrayList();
        // creaando personas
        Persona persona1 = new Persona(1, "Marcelino", "T??rrez");
        Persona persona2 = new Persona(2, "Victor", "Davila");
        Persona persona3 = new Persona(3, "Fernando", "Luque");
        Persona persona4 = new Persona(4, "Oscar", "Alcantara");
        Persona persona5 = new Persona(5, "Edwin", "Mendoza");
        Persona persona6 = new Persona(6, "Juan", "Garz??n");
        Persona persona7 = new Persona(7, "Francisco", "Pacheco");
        Persona persona8 = new Persona(8, "Ricardo", "Mendoza");
        Persona persona9 = new Persona(9, "Oscar", "Davila");

        // creando documentos tipo Pagina
        Pagina pagina;
        pagina = new Pagina();
        pagina.setCodigo("doc001");
        pagina.setTitulo("L??gica de Programaci??n");
        pagina.setDescripcion("Trata sobre algor??tmos y diagramas de flujo");
        pagina.setFecha(LocalDate.of(2022, 1, 20));
        pagina.setUrl("http://www.logicaprogramacion.com");
        pagina.setPropietario(persona1);
        documentos.add(pagina);

        pagina = new Pagina();
        pagina.setCodigo("doc002");
        pagina.setTitulo("Programaci??n de c??lculos matem??ticos con Java");
        pagina.setDescripcion("Trata sobre algor??tmos y formulas matem??ticas con funciones en lenguaje Java");
        pagina.setFecha(LocalDate.of(2022, 2, 15));
        pagina.setUrl("http://www.programacionmate.com");
        pagina.setPropietario(persona2);
        documentos.add(pagina);

        // creando documentos tipo Carta
        Carta carta;
        carta = new Carta();
        carta.setCodigo("doc003");
        carta.setTitulo("Carta de presentaci??n personal");
        carta.setDescripcion("Describe las habilidades y buenas pr??cticas en programaci??n");
        carta.setFecha(LocalDate.of(2022, 2, 10));
        carta.setMensaje("Mis habilidades en programaci??n son en Java nivel avanzado."
                + " Tambi??n domino base de datos y trabajo efectivamente con equipos ??giles.");
        carta.setRemitente(persona2);
        carta.setDestinatario(persona3);
        documentos.add(carta);

        carta = new Carta();
        carta.setCodigo("doc004");
        carta.setTitulo("Carta de felicitaciones");
        carta.setDescripcion("Felicitaci??n por los buenos resultados en los proyectos");
        carta.setFecha(LocalDate.of(2022, 2, 28));
        carta.setMensaje("Felicitaciones por los logros en el proyecto empresarial sobre Gesti??n de Ventas."
                + " El buen trabajo realizado le ha permitido ocupar el cargo de l??der t??cnico.");
        carta.setRemitente(persona4);
        carta.setDestinatario(persona5);
        documentos.add(carta);

        // creando documentos tipo Presentacion
        Presentacion presentacion;
        presentacion = new Presentacion();
        presentacion.setCodigo("doc005");
        presentacion.setTitulo("Introducci??n a UML");
        presentacion.setDescripcion("Revisi??n de los principales diagramas UML");
        presentacion.setFecha(LocalDate.of(2022, 1, 18));
        presentacion.setTema("Dise??o Orientado a Objetos");
        presentacion.setPresentador(persona6);
        documentos.add(presentacion);

        presentacion = new Presentacion();
        presentacion.setCodigo("doc006");
        presentacion.setTitulo("Introducci??n a la Programaci??n con C#");
        presentacion.setDescripcion("Revisi??n de los principales tipos de datos y estructuras de control");
        presentacion.setFecha(LocalDate.of(2022, 1, 18));
        presentacion.setTema("Programaci??n con C#");
        presentacion.setPresentador(persona6);
        documentos.add(presentacion);

        // creando documentos tipo Gu??a
        Guia guia;
        guia = new Guia();
        guia.setCodigo("doc007");
        guia.setTitulo("C??mo elaborar diagramas de clases con UML");
        guia.setDescripcion("Explicaci??n de las partes de una clase y sus tipos de relaciones");
        guia.setFecha(LocalDate.of(2021, 12, 10));
        guia.setSubtitulo("Modelo de dise??o est??tico");
        guia.setObjetivo("Comprender las caracter??sticas principales de un diagrama de clases");
        guia.setAutor(persona9);
        documentos.add(guia);

        guia = new Guia();
        guia.setCodigo("doc008");
        guia.setTitulo("C??mo elaborar diagramas de secuencia con UML");
        guia.setDescripcion("Explicaci??n de las partes de un diagrama de secuencia");
        guia.setFecha(LocalDate.of(2021, 10, 20));
        guia.setSubtitulo("Modelo de dise??o din??mico");
        guia.setObjetivo("Comprender las caracter??sticas principales de un diagrama de secuencia");
        guia.setAutor(persona8);
        documentos.add(guia);

        // creando documentos tipo Libro
        Capitulo capitulo;
        Libro libro;
        libro = new Libro();
        libro.setCodigo("doc009");
        libro.setTitulo("Introducci??n al dise??o de base de datos");
        libro.setDescripcion("Explica sobre el Modelo Entidad Relaci??n y el Modelo Relacional");
        libro.setFecha(LocalDate.of(2019, 8, 15));
        libro.setEspecialidad("Base de Datos");
        libro.setEditorial("McGraw-Hill");
        libro.setIdioma("Espa??ol");
        libro.setPaginas(200);
        libro.setIsbn("84-481-2021-0");
        libro.agregarAutor(persona7);
        capitulo = new Capitulo();
        capitulo.setTitulo("??Qu?? es base de datos?");
        capitulo.setObjetivo("Comprender el significado de base de datos y sus aplicaciones");
        libro.agregarCapitulo(capitulo);
        capitulo = new Capitulo();
        capitulo.setTitulo("El Modelo Conceptual");
        capitulo.setObjetivo("Elaborar diagramas Entidad Relaci??n");
        libro.agregarCapitulo(capitulo);
        capitulo = new Capitulo();
        capitulo.setTitulo("El Modelo Relacional");
        capitulo.setObjetivo("Elaborar el dise??o l??gico con Tablas");
        libro.agregarCapitulo(capitulo);
        documentos.add(libro);

        libro = new Libro();
        libro.setCodigo("doc010");
        libro.setTitulo("Arquitectura de Software");
        libro.setDescripcion("Explica sobre atributos de calidad y patrones de arquitectura");
        libro.setFecha(LocalDate.of(2018, 10, 20));
        libro.setEspecialidad("Ingenier??a de Software");
        libro.setEditorial("Pearson");
        libro.setIdioma("Espa??ol");
        libro.setPaginas(150);
        libro.setIsbn("70-500-2018-5");
        libro.agregarAutor(persona6);
        libro.agregarAutor(persona8);
        capitulo = new Capitulo();
        capitulo.setTitulo("??Qu?? es Arquitectura de Software?");
        capitulo.setObjetivo("Comprender el significado de Arquitectura de Software");
        libro.agregarCapitulo(capitulo);
        capitulo = new Capitulo();
        capitulo.setTitulo("Atributos de Calidad");
        capitulo.setObjetivo("Comprender los escenarios de calidad y t??cticas");
        libro.agregarCapitulo(capitulo);
        capitulo = new Capitulo();
        capitulo.setTitulo("Patrones de Arquitectura");
        capitulo.setObjetivo("Comprender patrones en capas y multi niveles");
        libro.agregarCapitulo(capitulo);
        capitulo = new Capitulo();
        capitulo.setTitulo("Documentaci??n de la Arquitectura de Software");
        capitulo.setObjetivo("Describir vistas arquitect??nicas y memor??ndums t??cnicos");
        libro.agregarCapitulo(capitulo);
        documentos.add(libro);
    }
}//end CatalogoDeDocumentos
