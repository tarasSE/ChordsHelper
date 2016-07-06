package com.generic.webproject.repository;

import com.generic.webproject.entity.ChordVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ChordVariantRepository extends JpaRepository<ChordVariant, Integer>{
}
