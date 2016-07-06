package com.generic.webproject.repository;

import com.generic.webproject.entity.ChordDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ChordDifficultyRepository extends JpaRepository<ChordDifficulty, Integer>{
}
