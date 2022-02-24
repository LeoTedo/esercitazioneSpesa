package it.unimi.di.prog2.esame.model;


import it.unimi.di.prog2.esame.presenter.Observer;
import org.jetbrains.annotations.NotNull;

public interface Observable<T> {

    public void notifyObservers();

    void addObserver(@NotNull Observer<T> observer);

    @NotNull T getState();

}
