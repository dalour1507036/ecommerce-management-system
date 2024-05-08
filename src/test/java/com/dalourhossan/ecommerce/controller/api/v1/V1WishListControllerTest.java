package com.dalourhossan.ecommerce.controller.api.v1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(V1WishListController.class)
public class V1WishListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishListService wishListService;

    @Test
    public void testGetWishList() throws Exception {
        List<Long> wishList = Arrays.asList(1L, 2L, 3L);
        when(wishListService.getWishList(1L)).thenReturn(wishList);

        mockMvc.perform(get("/api/v1/wishlist/{customerId}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect((ResultMatcher) jsonPath("$[0]", is(1)))
                .andExpect((ResultMatcher) jsonPath("$[1]", is(2)))
                .andExpect((ResultMatcher) jsonPath("$[2]", is(3)));
    }
}
