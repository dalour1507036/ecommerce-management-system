package com.dalourhossan.ecommerce.controller.api.v1;

import com.dalourhossan.ecommerce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping("/max-sale-day")
    public ResponseEntity<LocalDate> getMaxSaleDay(@RequestParam("startDate") String startDateStr,
                                                   @RequestParam("endDate") String endDateStr) {
        startDateStr = startDateStr.trim();
        endDateStr = endDateStr.trim();
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        LocalDate maxSaleDay = saleService.getMaxSaleDay(startDate, endDate);
        return ResponseEntity.status(HttpStatus.OK).body(maxSaleDay);
    }
}
