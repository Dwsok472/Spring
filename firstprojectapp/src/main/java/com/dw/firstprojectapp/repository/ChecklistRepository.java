package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist,Long> {
}
