package com.camdot.expensetracker.controller;

import com.camdot.expensetracker.model.Invoice;
import com.camdot.expensetracker.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    @Operation(summary = "Get all invoices")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of invoices")})
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.status(HttpStatus.OK).body(invoices);
    }

    @PostMapping
    @Operation(summary = "Create a new invoice")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Invoice created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice createdInvoice = invoiceService.createInvoice(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modify an existing invoice")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Invoice modified successfully"),
            @ApiResponse(responseCode = "404", description = "Invoice not found")})
    public ResponseEntity<Invoice> modifyInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        invoice.setId(id);
        Invoice modifiedInvoice = invoiceService.modifyInvoice(invoice);
        return ResponseEntity.ok(modifiedInvoice);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an invoice")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Invoice deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Invoice not found")})
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}