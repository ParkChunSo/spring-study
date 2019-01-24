package com.example.springstudy.repository;

import com.example.springstudy.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DemoRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String name);
}
