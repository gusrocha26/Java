package model;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Amigo {
    private String nome;
    List<Post> postList;

    public Amigo(String nome) {
        this.nome = nome;
        postList = new ArrayList<>();
    }

    public void postar(Post post) {
        postList.add(post);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public void curtir(Post post) {
        post.incrementarCurtidas();
        post.quemCurtiu(this);
    }

    @Override
    public String toString() {
        if (postList.isEmpty())
            return nome;
        return nome + "\n" + postList;
    }

    public Post retornaPostMaisCurtido() {
        Post postMaisCurtido = postList.get(0);
        for (Post p : postList){
            if(p.getNumeroCurtidas() > postMaisCurtido.getNumeroCurtidas()){
                postMaisCurtido = p;
            }
        }
        return postMaisCurtido;
    }
}
