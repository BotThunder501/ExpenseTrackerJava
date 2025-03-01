package com.camdot.expensetracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<Expense> expenses;

    public Invoice(String name, String email, List<Expense> expenses) {
        this.name = name;
        this.email = email;
        this.expenses = expenses;
    }
}