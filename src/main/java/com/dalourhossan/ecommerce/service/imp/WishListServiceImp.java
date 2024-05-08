package com.dalourhossan.ecommerce.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImp {
    @Autowired
    private WishListRepository wishListRepository;
    public List<Product> getWishList(Long customerId) {
        return wishListRepository.findByCustomerId(customerId);
    }
}
