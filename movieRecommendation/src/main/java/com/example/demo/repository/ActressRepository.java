package com.example.demo.repository;

import com.example.demo.model.Actress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActressRepository extends JpaRepository<Actress, Long> {
}
