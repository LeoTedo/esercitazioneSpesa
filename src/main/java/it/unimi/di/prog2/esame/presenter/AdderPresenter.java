package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Observable;
import it.unimi.di.prog2.esame.model.Prodotto;
import it.unimi.di.prog2.esame.model.SpesaModel;
import it.unimi.di.prog2.esame.model.VuotoModel;
import it.unimi.di.prog2.esame.view.AdderView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdderPresenter implements Presenter {
  //TODO da completare
  private final AdderView view;
  private final SpesaModel m;
  private final VuotoModel v;

  public AdderPresenter(@NotNull final AdderView view, @NotNull SpesaModel m, @NotNull VuotoModel v) {
    this.view = view;
    this.m = m;
    this.v = v;
    view.addHandlers(this);
    m.addObserver(this);
  }


  public final void action(int i, String text) {
    //
    if(i<=50){
      m.addProdotto(i,text);
      v.addProdotto(0, text);
    } else {
      System.err.printf("Quantità troppo alta!");
    }
  }

  @Override
  public void update(@NotNull Observable<List<Prodotto>> subject, @NotNull List<Prodotto> state) {

  }
}
