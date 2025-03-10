package com.dw.firstapp.repository.iface;

import com.dw.firstapp.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
    List<Customer> getCustomersWithHighMileageThanAvg();
    List<Customer> getCustomersByMileageGrade(String grade);
}
