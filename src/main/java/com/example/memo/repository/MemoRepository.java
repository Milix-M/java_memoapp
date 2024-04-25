package com.example.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.memo.entities.memo.MemoEntity;

@Repository
public interface MemoRepository extends JpaRepository<MemoEntity, Integer> {

}