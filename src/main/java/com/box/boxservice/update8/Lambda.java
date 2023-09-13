package com.box.boxservice.update8;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda implements Operacion{
    private static double attr1=1;
    private double attr2=2;


    public static void main(String[] args) {
       Lambda l = new Lambda();
       l.ambito();
       l.hablar();
       l.imprimirStatic();
       Lambda l2 = new Lambda();
       l2.imprimirStatic();
       Lambda l3 = new Lambda();
       l3.imprimirStatic();
    }
    private void imprimirStatic(){
        System.out.println("attr1---->"+attr1);
        System.out.println("attr2---->"+attr2);
    }

    private void ambito(){
      attr1=15;
      attr2=16;
    }

    private static void sintaxis(){
        Operacion op = (x,y)-> {
            double a= 5;
            System.out.println(a);
            return (x+y)/2 +a;
        };
        System.out.println(op.avg(1,2));
    }

    private static void operacion(){
        /*Operacion operacion = new Operacion() {
            @Override
            public double avg(double n1, double n2) {
                return (n1+n2)/2;
            }
        };
        System.out.println(operacion.avg(1,2));
        */
        Operacion op = (x,y) -> (x+y)/2;
        //op.hablar();
        System.out.println(op.avg(1,2));
    }

    private static void ordenar() {
        System.out.println("ordenar sin Lambda");
        List<String> lista = new ArrayList<>();
        lista.add("C");
        lista.add("B");
        lista.add("A");


        Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String s : lista) {
            System.out.println(s);

        }
    }
    private static void ordenarConLambda() {
        System.out.println("Ordenar con Lambda");
        List<String> lista = new ArrayList<>();
        lista.add("C");
        lista.add("B");
        lista.add("A");
        lista.add("D");
        Collections.sort(lista,((o1, o2) -> o1.compareTo(o2)));
        //lista.forEach(s -> System.out.println(s));
        lista.forEach(s -> {
            System.out.println(s.toLowerCase());
        });
        lista.forEach(s -> System.out.println(s));
    }

    @Override
    public double avg(double n1, double n2) {
        return 0;
    }
    public void hablar (){
        System.out.println("hablarS");
    }

}