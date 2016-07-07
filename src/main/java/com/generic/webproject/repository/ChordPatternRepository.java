package com.generic.webproject.repository;

import com.generic.webproject.entity.ChordPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ChordPatternRepository extends JpaRepository<ChordPattern, Integer>{
}
