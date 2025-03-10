package com.dw.firstapp.service;

import com.dw.firstapp.model.MileGrade;
import com.dw.firstapp.repository.iface.MileageRepository;
import com.dw.firstapp.repository.jdbc.MileageJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageService {
    @Autowired
    @Qualifier("mileageTemplateRepository")
    MileageRepository mileageRepository;

    public List<MileGrade> getAllmileage() {
        return mileageRepository.getAllmileage();
    }
}
