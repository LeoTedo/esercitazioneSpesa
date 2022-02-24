package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.presenter.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VuotoModel implements Observable<List<Prodotto>>{
    private final List<Observer<List<Prodotto>>> observers = new ArrayList<>();
    private final Map<Integer, Prodotto> prodottiComprati = new HashMap<>();
    private SpesaModel m;
    @Override
    public void notifyObservers() {
        for (Observer<List<Prodotto>> observer : observers) {
            observer.update(this, new ArrayList<>(prodottiComprati.values()));
        }
    }

    @Override
    public void addObserver(@NotNull Observer<List<Prodotto>> observer) {
        observers.add(observer);
    }

    @NotNull
    @Override
    public List<Prodotto> getState() {
        return new ArrayList<Prodotto>();
    }

    public boolean prodottoIsPresent(String s) {
        for (Prodotto prod : prodottiComprati.values()) {
            if ( s.equalsIgnoreCase(prod.getNome())) {
                return true;
            }
        }
        return false;
    }

    public void acquista(int i) {
        prodottiComprati.put(i, prodottiComprati.get(i).comprato());
        notifyObservers();
    }

    public void addProdotto(@NotNull int i, @NotNull String s) {
        assert !s.trim().isEmpty();
        assert s.trim().length() >= 3;


        if (prodottoIsPresent(s.trim())) {
            System.err.println("Il candidato è già registrato!");
        }else{
            prodottiComprati.put(prodottiComprati.size(), new Prodotto(s.trim(),0) );
            notifyObservers();
        }
    }

}
