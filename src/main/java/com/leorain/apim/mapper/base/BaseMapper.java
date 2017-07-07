package com.leorain.apim.mapper.base;

import com.leorain.apim.entity.UserEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public interface BaseMapper<T> {
    List<T> getAll();

    T getOne(Long id);

    void insert(T t);

    void update(T t);

    void delete(Long id);
}
