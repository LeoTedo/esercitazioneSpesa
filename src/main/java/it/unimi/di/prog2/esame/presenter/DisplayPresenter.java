package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Observable;
import it.unimi.di.prog2.esame.model.Prodotto;
import it.unimi.di.prog2.esame.model.SpesaModel;
import it.unimi.di.prog2.esame.view.AdderView;
import it.unimi.di.prog2.esame.view.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DisplayPresenter implements Presenter{
    private final DisplayView view;
    private final SpesaModel m;

    public DisplayPresenter(@NotNull final DisplayView view, @NotNull SpesaModel m) {
        this.view = view;
        this.m = m;
        //view.addHandlers(this);
        m.addObserver(this);
    }

    @Override
    public void update(@NotNull Observable<List<Prodotto>> subject, @NotNull List<Prodotto> state) {


        int i =0;
            //System.out.println(subject);
        for (Prodotto prod : state) {
                view.set(i, prod.getNome() + " : " + prod.getQuantity());
                i++;
        }
    }

    @Override
    public void action(int id, String text) {
        //NULLA
    }
}
