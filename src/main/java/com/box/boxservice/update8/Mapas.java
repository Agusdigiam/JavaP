package com.box.boxservice.update8;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapas {

    private Map<Integer,String> map;

    private void llenar(){
        map = new HashMap<Integer,String>();
        map.put(1,"Santa");
        map.put(2,"Esteban");
        map.put(3,"Santamarn");
    }

    private void imprimir_v7(){
        for (Map.Entry<Integer,String> e: map.entrySet()){
            System.out.println(e.getKey()+"-"+e.getValue());
        }
    }
    private void imprimir_v8(){
        //map.forEach((k,v)-> System.out.println(k+"-----"+v));
        map.entrySet().stream().forEach(System.out::println);
    }

    private void recolectar(){

        Map<Integer,String> rec = map.entrySet()
                .stream()
                .filter(e -> e.getValue().contains("Es"))
                .collect(Collectors.toMap(p-> p.getKey(),p->p.getValue()));
        rec.entrySet().stream().forEach(System.out::println);
    }
    private void computer(){

        map.computeIfPresent(3,(k,v)-> k+"...."+v);
        System.out.println(map.get(3));
    }


    public static void main(String[] args) {
        Mapas m = new Mapas();
        m.llenar();
        //m.recolectar();
        //m.imprimir_v8();
        //m.computer();
        m.recolectar();

    }
}
