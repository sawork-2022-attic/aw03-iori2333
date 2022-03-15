package com.example.webpos.db;

import com.example.webpos.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PosRepository extends CrudRepository<Product, String> {
    @Override
    Iterable<Product> findAll();

    @Override
    Optional<Product> findById(String id);

    @Override
    <S extends Product> S save(S entity);

    @Override
    void deleteById(String s);
}
