package ru.qnocks.trsis.lab2.dao;

import java.util.List;

public interface CrudDao<T, ID> {
    T save(T entity);
    void delete(ID id);
    T findById(ID id);
    List<T> findALl();
}
