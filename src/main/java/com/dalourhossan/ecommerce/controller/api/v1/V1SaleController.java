package com.dalourhossan.ecommerce.controller.api.v1;

import com.dalourhossan.ecommerce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sales")
public class V1SaleController {
    private final SaleService saleService;

    @Autowired
    public V1SaleController(SaleService saleService) {
        this.saleService = saleService;

    }

    @GetMapping("/total-amount")
    public ResponseEntity<Double> getTotalSaleAmountOfCurrentDay() {
        double totalSaleAmount = saleService.getTotalSaleAmountOfCurrentDay();
        return ResponseEntity.status(HttpStatus.OK).body(totalSaleAmount);
    }
}
