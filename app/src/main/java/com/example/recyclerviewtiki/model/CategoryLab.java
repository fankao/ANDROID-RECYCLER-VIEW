package com.example.recyclerviewtiki.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryLab {
    private static CategoryLab INSTANCE = null;
    private Context mContext;
    private List<Category> categories;

    private CategoryLab(Context context) {
        mContext = context.getApplicationContext();
        categories = new ArrayList<>();
    }


    public static CategoryLab getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CategoryLab(context);
        }
        return INSTANCE;
    }

    public List<Category> getCategories() {
        Category c1= new Category(1,"Category 1",
                Arrays.asList(new Product(1,"Product 1"),
                        new Product(2,"Product 2"),
                        new Product(3,"Product 3")));
        Category c2= new Category(1,"Category 2",
                Arrays.asList(new Product(4,"Product 4"),
                        new Product(5,"Product 5"),
                        new Product(6,"Product 6")));

        Category c3= new Category(1,"Category 3",
                Arrays.asList(new Product(7,"Product 7"),
                        new Product(8,"Product 8"),
                        new Product(9,"Product 9")));

        categories.add(c1);
        categories.add(c2);
        categories.add(c3);

        return categories;
    }

    public Category getCategory(int id){
        for (Category category : categories) {
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
