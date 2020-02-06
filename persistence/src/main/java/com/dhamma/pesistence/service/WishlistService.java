package com.dhamma.pesistence.service;

import com.dhamma.pesistence.entity.repo.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishlistService {

    @Autowired
    WishlistRepo wishlistRepo;

//
//    private List<String> getAllWishlistAsList(String username){
//
//        Iterable<Wishlist> itr = wishlistRepo.findAll(QWishlist.wishlist.userid.eq(username));
//
//    }

}
