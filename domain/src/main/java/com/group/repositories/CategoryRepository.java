package com.group.repositories;

import com.group.entities.Category;

import java.util.List;

/**
 * Clase
 *
 * @author Scoowy
 * @version 2022.01.21.1923
 */
public interface CategoryRepository {
    public List<Category> getCategories();
}
