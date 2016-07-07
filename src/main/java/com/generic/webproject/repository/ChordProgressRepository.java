package com.generic.webproject.repository;

import com.generic.webproject.entity.ChordDifficulty;
import com.generic.webproject.entity.ChordProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ChordProgressRepository extends JpaRepository<ChordProgress, Integer>{
    ChordDifficulty findByChordId(Integer id);
}
