package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Prodotto;

import java.util.List;

public interface Presenter extends Observer<List<Prodotto>>{
  //TODO da completare

  void action(int id, String text);
}
