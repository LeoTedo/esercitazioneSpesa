package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Observable;
import it.unimi.di.prog2.esame.model.Prodotto;
import it.unimi.di.prog2.esame.model.SpesaModel;
import it.unimi.di.prog2.esame.model.VuotoModel;
import it.unimi.di.prog2.esame.view.BuyerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BuyerPresenter implements Presenter{
    private final BuyerView view;
    private final SpesaModel m;
    private final VuotoModel v;

    public BuyerPresenter(@NotNull BuyerView view, @NotNull SpesaModel m, VuotoModel v) {
        this.view = view;
        this.m = m;
        this.v = v;
        m.addObserver(this);
        view.addHandlers(this);
    }

    @Override
    public void update(@NotNull Observable<List<Prodotto>> subject, @NotNull List<Prodotto> state) {
        int i =0;
        for (Prodotto prod : state) {
            view.set(i, prod.getNome());
            i++;
        }
    }

    @Override
    public void action(int id, String text) {
        try {
            if (m.getState().get(id).getQuantity() >0){
                m.acquista(id);
                v.acquista(id);
            }
        } catch (Exception e){
            System.out.println("Non c'è niente");
        }


    }
}
