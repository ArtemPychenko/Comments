package com.softserveinc.ita.commentstests.domain.repositories;

import com.softserveinc.ita.commentstests.domain.models.Category;
/**This class contain information about calories.
 * Utility class
 * @author DP-076ATQC
 *
 */
public final class CategoriesRepository {
    /**Private constructor.*/
    private CategoriesRepository() { }
    /***Static method for create valid category array.
     * @return category array.
     */
    public static Category[] getAllValidCategories() {
        final byte maxcategoryNumber = 6;
        Category[] validCategories = new Category[maxcategoryNumber];
        validCategories[0] = new Category((byte) 1, "Cat0");
        validCategories[1] = new Category((byte) 2, "Cat1");
        validCategories[2] = new Category((byte) 3, "Cat2");
        validCategories[3] = new Category((byte) 4, "Cat3");
        validCategories[4] = new Category((byte) 5, "Cat4");
        validCategories[5] = new Category((byte) 6, "Cat5");
        return validCategories;
    }
    /**Static method contain all categories in drop box.
     * @return category array
     */
    public static Category[] getAllDropBoxCategories() {
        final byte categoriesArraySize = 7;
        final byte lastCategory = 6;
        Category[] dropDownCategories = new Category[categoriesArraySize];
        for (int i = 0; i < getAllValidCategories().length; i++) {
            dropDownCategories[i] = getAllValidCategories()[i];
        }
        dropDownCategories[lastCategory] = new Category((byte) -1, "All");
        return dropDownCategories;
    }
    /**Static method contain all valid and one invalid categories.
     * @return category array
     */
    public static Category[] getAllValidOneInvalidcategories() {
        final byte categoriesArraySize = 7;
        final byte lastCategory = 6;
        Category[] dropDownCategories = new Category[categoriesArraySize];
        for (int i = 0; i < getAllValidCategories().length; i++) {
            dropDownCategories[i] = getAllValidCategories()[i];
        }
        dropDownCategories[lastCategory] = new Category((byte) 0, "Invalid");
        return dropDownCategories;
    }

}
