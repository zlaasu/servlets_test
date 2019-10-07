package pl.coderslab.dao;

import java.util.List;

public interface DaoInterface<T> {
    List<T> findAll();
    T findById(Long id);
    T update(T t);
    T create(T t);
    boolean remove(T t);
}
