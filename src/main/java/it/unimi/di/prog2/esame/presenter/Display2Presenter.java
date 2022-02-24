package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Observable;
import it.unimi.di.prog2.esame.model.Prodotto;
import it.unimi.di.prog2.esame.model.SpesaModel;
import it.unimi.di.prog2.esame.model.VuotoModel;
import it.unimi.di.prog2.esame.view.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Display2Presenter implements Presenter {
    private final DisplayView view;
    private final VuotoModel v;
    private final SpesaModel s;

    public Display2Presenter(@NotNull final DisplayView view, @NotNull VuotoModel v, SpesaModel s) {
        this.view = view;
        this.v = v;
        this.s = s;
        //view.addHandlers(this);
        v.addObserver(this);
    }

    @Override
    public void update(@NotNull Observable<List<Prodotto>> subject, @NotNull List<Prodotto> state) {
        int i =0;
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
