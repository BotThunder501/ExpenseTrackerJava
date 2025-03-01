package com.camdot.expensetracker.repository;

import com.camdot.expensetracker.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByEmailContainingIgnoreCase(String email);
    List<Invoice> findByNameContainingIgnoreCase(String name);
}
