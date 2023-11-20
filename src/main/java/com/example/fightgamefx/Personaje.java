package com.example.fightgamefx;

public class Personaje {
    private int vida;
    private String nombre;

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonaje2() {
        return personaje2;
    }

    public void setPersonaje2(String personaje2) {
        this.personaje2 = personaje2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    static String image1Path;
   static String image2Path;
   String personaje2;
   String winner;
    String image1realPath;
    String image2realPath;
    String pathAttack;
    String pathSpecial;
    String pathDefense;




    public Personaje(String nombre) {
        this.vida = 100;
        this.nombre = nombre;



    }

    public Personaje(String nombre, String personaje2, String winner) {
        this.nombre = nombre;
        this.personaje2 = personaje2;
        this.winner = winner;
    }

    public Personaje(int vida, String nombre, String pathAttack, String pathSpecial, String pathDefense) {
        this.vida = vida;
        this.nombre = nombre;
        this.pathAttack = pathAttack;
        this.pathSpecial = pathSpecial;
        this.pathDefense = pathDefense;
    }



}
