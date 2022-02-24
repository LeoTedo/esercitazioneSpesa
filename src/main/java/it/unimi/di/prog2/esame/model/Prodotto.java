package it.unimi.di.prog2.esame.model;

public class Prodotto {

    private String nome;
    private int quantity;

    public Prodotto(String nome, int quantity) {
        assert quantity >0;
        this.nome = nome;
        this.quantity = quantity;
    }

    public Prodotto acquista(){
        if (quantity > 0){
            return new Prodotto(nome, quantity-1);
        } else {
            return new Prodotto(nome, 0);
        }
    }

    public Prodotto comprato(){
        if (quantity<50){
            return new Prodotto(nome,quantity+1);
        } else {
            return new Prodotto(nome, quantity);
        }

    }
    public String getNome() {
        return nome;
    }

    public int getQuantity() {
        return quantity;
    }

}
