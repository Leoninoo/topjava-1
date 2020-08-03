package ru.javawebinar.topjava.crud;

import java.util.List;

public interface CrudDao<T> {
    T find(Long id);
    void save(T model);
    void delete(Long id);

    List<T> findAll();
}
