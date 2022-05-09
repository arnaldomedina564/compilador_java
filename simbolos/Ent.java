package simbolos; // Archivo Ent.java

import java.util.*;
import analizadorLexico.*;
import inter.*;

public class Ent {
    public Map tabla;
    public Ent ant;

    public Ent(Ent n) {
        tabla = new HashMap();
        ant = n;
    }

    public void put(Token w, Id i) {
        tabla.put(w, i);
    }

    public Id get(Token w) {
        for (Ent e = this; e != null; e = e.ant) {
            Id encontro = (Id) (e.tabla.get(w));
            if (encontro != null)
                return encontro;
        }
        return null;
    }
}