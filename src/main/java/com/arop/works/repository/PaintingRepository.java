package com.arop.works.repository;

import com.arop.works.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bo.fan
 * @date 2019-04-09
 */
@Repository
public interface PaintingRepository extends JpaRepository<Painting,Long> {
}
