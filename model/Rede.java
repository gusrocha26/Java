package model;

import java.util.ArrayList;
import java.util.List;

public class Rede {
    private List<Amigo> amigoList = new ArrayList<>();

    public void adicionarAmigo(Amigo amigo) {
        amigoList.add(amigo);
    }

    public String timeline() {
        StringBuilder sb = new StringBuilder();
        for(Amigo amigo : amigoList){
            sb.append(amigo);
            sb.append("\n");
        }
        return sb.toString().replaceAll("\\[", "").replaceAll("\\]","").replaceAll(", ", "");
    }
}
