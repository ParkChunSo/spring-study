package com.example.springstudy.repository;

import com.example.springstudy.model.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    Page<Board> findByBnoGreaterThan(Long bno, Pageable pageable);

}
