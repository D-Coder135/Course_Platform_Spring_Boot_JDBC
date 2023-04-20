package com.decoder135.springbootjdbcdemo.dao;

import java.util.List;

public interface DAO<T> {

    List<T> list();

    void create(T t);

}
