package com.amadeus.mongo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MongoBaseService<T, ID> {
    //查询所有
    List<T> findAll();

    //查询所有，根据条件
    List<T> findAll(T example);

    //根据ID查询
    Optional<T> findById(ID id);

    //根据ID集合查询
    Iterable<T> findAllById(Iterable<ID> ids);

    //保存
    T save(T entity);

    //批量保存
    <S extends T> List<S> saveAll(Iterable<S> entities);

    //根据ID删除
    void deleteById(ID id);

    //根据ID批量删除
    void deleteAllById(Iterable<? extends ID> ids);

    //分页信息查询，可以自定义分页对象，也可以使用Mybatis plus分页对象
    Page<T> findByPage(T entity, Pageable pageable);
}
