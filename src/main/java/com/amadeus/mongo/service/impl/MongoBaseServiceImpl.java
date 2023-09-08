package com.amadeus.mongo.service.impl;

import com.amadeus.mongo.service.MongoBaseService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public abstract class MongoBaseServiceImpl<T, ID> implements MongoBaseService<T, ID> {

    protected final MongoRepository<T, ID> mongoRepository;

    public MongoBaseServiceImpl(MongoRepository<T, ID> mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public List<T> findAll() {
        return mongoRepository.findAll();
    }

    @Override
    public List<T> findAll(T entity) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withNullHandler(ExampleMatcher.NullHandler.IGNORE)
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<T> query = Example.of(entity, matcher);
        return mongoRepository.findAll(query);
    }

    @Override
    public Optional<T> findById(ID id) {
        return this.mongoRepository.findById(id);
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        return this.mongoRepository.findAllById(ids);
    }

    @Override
    public T save(T entity) {
        return this.mongoRepository.save(entity);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return this.mongoRepository.saveAll(entities);
    }

    @Override
    public void deleteById(ID id) {
        this.mongoRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(Iterable<? extends ID> ids) {
        this.mongoRepository.deleteAllById(ids);
    }

    @Override
    public Page<T> findByPage(T entity, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withNullHandler(ExampleMatcher.NullHandler.IGNORE)
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<T> query = Example.of(entity, matcher);
        return this.mongoRepository.findAll(query, pageable);
    }
}
