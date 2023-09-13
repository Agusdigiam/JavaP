package com.box.boxservice.update8;

public class RefApp {

    public void crearPersona(){
        IPersona p = Persona::new;
        Persona persona = p.crear("santa");
        System.out.println(persona.getNombre());

        IPersona pl = (x) -> (new Persona(x));
        Persona ppp = pl.crear("Santa 2");
        System.out.println(ppp.getNombre());

        Persona p3 = ppp.crear("santa 3");
        System.out.println(p3.getNombre());
    }
    public static void main(String[] args) {
        RefApp app = new RefApp();
        app.crearPersona();
    }
}
