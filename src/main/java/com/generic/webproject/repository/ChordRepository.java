package com.generic.webproject.repository;

import com.generic.webproject.entity.Chord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ChordRepository extends JpaRepository<Chord, Integer>{
}
