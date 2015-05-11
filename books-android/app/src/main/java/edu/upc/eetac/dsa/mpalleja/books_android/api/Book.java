package edu.upc.eetac.dsa.mpalleja.books_android.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marc on 09/05/2015.
 */
public class Book {
        private int id;
    private String titulo;
    private String lengua;
    private String edicion;
    private String editorial;
    private long fecha_edicion;
    private long fecha_impresion;
    private Map<String, Link> links = new HashMap<String, Link>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLengua() {
        return lengua;
    }

    public void setLengua(String lengua) {
        this.lengua = lengua;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public long getFecha_edicion() {
        return fecha_edicion;
    }

    public void setFecha_edicion(long fecha_edicion) {
        this.fecha_edicion = fecha_edicion;
    }

    public long getFecha_impresion() {
        return fecha_impresion;
    }

    public void setFecha_impresion(long fecha_impresion) {
        this.fecha_impresion = fecha_impresion;
    }
    public Map<String, Link> getLinks() {
        return links;
    }

}
