package com.dalourhossan.ecommerce.controller;

import com.dalourhossan.ecommerce.controller.api.v1.V1SaleController;
import com.dalourhossan.ecommerce.service.SaleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class V1SaleControllerTest {
    @InjectMocks
    private V1SaleController v1SaleController;
    @Mock
    private SaleService saleService;

    @Test
    public void testGetTotalSaleAmountOfCurrentDay() {
        LocalDate today = LocalDate.now();
        double expectedTotalSale = 1234.56;
        when(saleService.getTotalSaleAmountOfCurrentDay()).thenReturn(expectedTotalSale);

        ResponseEntity<Double> actualTotalSale = v1SaleController.getTotalSaleAmountOfCurrentDay();

        assertEquals(expectedTotalSale, Objects.requireNonNull(actualTotalSale.getBody()), 0.001);
    }
}
