package model;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String description;

    private int numeroCurtidas = 0;

    private List<Amigo> amigos = new ArrayList<>();

    public Post(String description) {
        this.description = description;
    }

    public void incrementarCurtidas(){
        numeroCurtidas++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumeroCurtidas() {
        return numeroCurtidas;
    }

    public void setNumeroCurtidas(int numeroCurtidas) {
        this.numeroCurtidas = numeroCurtidas;
    }

    @Override
    public String toString() {
        return (description + ": " + numeroCurtidas + " curtidas\n");
    }

    public String retornaNomesQueCurtiram() {
        StringBuilder sb = new StringBuilder();
        if (!amigos.isEmpty()){
            for(Amigo a : amigos){
                sb.append(a.getNome());
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void quemCurtiu(Amigo amigo) {
        amigos.add(amigo);
    }
}
