package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepository extends JpaRepository<Traveler , String> {
}
