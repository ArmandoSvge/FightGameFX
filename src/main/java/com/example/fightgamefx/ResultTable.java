package com.example.fightgamefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ResultTable {
    private static ObservableList<Personaje> combatResult = FXCollections.observableArrayList();
    public  static ObservableList<Personaje> getCombatResults() {
        return combatResult;
    }
    public static void addCombatResult(Personaje personajes){
        combatResult.add(personajes);
    }

}
