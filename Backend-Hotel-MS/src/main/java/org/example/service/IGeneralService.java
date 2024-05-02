package org.example.service;

import java.util.List;

public interface IGeneralService<T, K> {

  List<T> showAll();

  T showOne(K k);

  T save(T t);

  T update(T t);

  void delete(K k);
}
