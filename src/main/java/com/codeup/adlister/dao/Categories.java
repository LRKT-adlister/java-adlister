package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import java.util.List;

public interface Categories {
    // get a list of all the category
    List<Category> all();

    //We're not needing this if we have predefined categories correct?
    // insert a new category and return the new categories' id
//    Long insert(Category category);

}
