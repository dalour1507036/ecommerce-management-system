package com.dalourhossan.ecommerce.service;

import java.util.List;

public interface WishListService {
    List<Long> getWishList(Long customerId);
}
