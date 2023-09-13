package com.box.boxservice.update8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class CollectionApp {
    List<String> lista;
    public static void main(String[] args) {
        CollectionApp app = new CollectionApp();
        app.llearList();
       // app.removeIf();
        app.sort();
        app.foreach();
    }
    private void foreach() {
        //Estoy pasando la implementacion de la funcional interface Consumer,
        //lista.forEach(x-> System.out.println(x)); // implementacion en lambda
        lista.forEach(System.out::println);// con referencia a metodos
    }
    public void removeIf(){
        Predicate pr = new Predicate() {
            @Override
            public boolean test(Object o) {
                return "C".equalsIgnoreCase((String)o);
            }
        };
        //lista.removeIf(x-> x.equalsIgnoreCase("C")); // con lamda
        lista.removeIf(pr);// con implementacion clase anonima
    }

    public void sort(){
        //lista.sort((x,y)-> x.compareTo(y)); // con lambda
        //lista.sort(String::compareTo); // con metodo de referencia
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        };
        lista.sort(c);
    }

    private void llearList() {
        lista = new ArrayList<>();
        lista.add("C");
        lista.add("B");
        lista.add("A");
    }
}
