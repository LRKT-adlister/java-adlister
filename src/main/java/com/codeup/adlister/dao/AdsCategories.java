package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCategory;

import java.util.List;

public interface AdsCategories {
    List<AdCategory> all();

 void insert(long adID, long catID);

}


