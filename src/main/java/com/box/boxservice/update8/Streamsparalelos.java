package com.box.boxservice.update8;

import java.util.ArrayList;
import java.util.List;

public class Streamsparalelos {
    private List lista;

    private void llenar(){
        lista = new ArrayList();
        for (int i = 0; i <10; i++) {
            lista.add(i);
        }
    }

    private void stream (){
        lista.stream().forEach(System.out::println);
    }

    private void sp (){
        lista.parallelStream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Streamsparalelos s = new Streamsparalelos();
        s.llenar();
        s.sp();

    }

}