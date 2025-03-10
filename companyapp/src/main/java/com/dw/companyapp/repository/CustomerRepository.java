package com.dw.companyapp.repository;

import com.dw.companyapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer , String> {
    @Query("SELECT c FROM Customer c WHERE c.mileage > (SELECT AVG(c2.mileage) FROM Customer c2)")
    List<Customer> getCustomersWithHighMileThanAvg();

    @Query("SELECT c FROM Customer c JOIN MileageGrade m ON c.mileage BETWEEN m.lowerMileage " +
            "AND m.upperMileage WHERE m.gradeName = :grade")
    List<Customer> getCustomersByMileageGrade(String grade);

}
