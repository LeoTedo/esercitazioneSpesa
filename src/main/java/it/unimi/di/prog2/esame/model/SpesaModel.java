package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.presenter.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpesaModel implements Observable<List<Prodotto>>{
    private final List<Observer<List<Prodotto>>> observers = new ArrayList<>();
    private final Map<Integer, Prodotto> prodotti = new HashMap<>();
    @Override
    public void notifyObservers() {
        for (Observer<List<Prodotto>> observer : observers) {
            observer.update(this, new ArrayList<>(prodotti.values()));
        }
    }

    @Override
    public void addObserver(@NotNull Observer<List<Prodotto>> observer) {
        observers.add(observer);
    }

    @Override
    public @NotNull List<Prodotto> getState() {
        ArrayList<Prodotto> spesa = new ArrayList<>();
        for (Prodotto prod: prodotti.values()){
            spesa.add(prod);
        }
        return spesa;
    }

    public boolean prodottoIsPresent(String s) {
        for (Prodotto prod : prodotti.values()) {
            if ( s.equalsIgnoreCase(prod.getNome())) {
                return true;
            }
        }
        return false;
    }

    public void acquista(int i) {
        assert i > 0 && i < 8;
        prodotti.put(i, prodotti.get(i).acquista());
        notifyObservers();
    }

    public void addProdotto(@NotNull int i, @NotNull String s) {
        assert !s.trim().isEmpty();
        assert s.trim().length() >= 3;


        if (prodottoIsPresent(s.trim())) {
            System.err.println("Il candidato è già registrato!");
        }else{
            prodotti.put(prodotti.size(), new Prodotto(s.trim(),i) );
            notifyObservers();
        }
    }

}
