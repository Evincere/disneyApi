
package com.disneyApi.Alkemy.repository;

import com.disneyApi.Alkemy.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long>{
    
}
