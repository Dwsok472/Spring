package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {
}
