package com.dw.firstprojectapp.repository;

import com.dw.firstprojectapp.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
