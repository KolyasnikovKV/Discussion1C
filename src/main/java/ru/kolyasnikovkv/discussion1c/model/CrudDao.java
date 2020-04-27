package ru.kolyasnikovkv.discussion1c.model;

public interface CrudDao<T> {

    T findById(Integer id);

    T save(T object);

    boolean delete(Integer id);
}