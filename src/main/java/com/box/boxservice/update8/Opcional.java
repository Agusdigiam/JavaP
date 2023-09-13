package com.box.boxservice.update8;

import java.util.Optional;

public class Opcional {

    public void probar (String valor ) {
        try {
            java.util.Optional op = java.util.Optional.empty();
            op.get();

        }catch(Exception e) {
            System.out.println("nio hay elemento");
        }
    }

    public void orElse(String valor){
        Optional<String> op = Optional.ofNullable(valor);
        String x = op.orElse("predeterminado");
        System.out.println(x);
    }

    public void orElseThrow(String valor){
        Optional<String> op = Optional.ofNullable(valor);
        String x = op.orElseThrow(NumberFormatException::new);
        System.out.println(x);
    }

    public void isPresent(String valor){
        Optional<String> op = Optional.ofNullable(valor);
        String val = op.orElseThrow(NumberFormatException::new);
        System.out.println(val);
    }
    public static void main(String[] args) {
        Opcional op = new Opcional();
        op.isPresent(null);
    }
}
