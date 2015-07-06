package com.softserveinc.ita.commentstests.domain.models;
/**This class describe one category.
 * This class consist category name and id.
 * @author DP-076ATQC
 *
 */
public class Category {
    /**variable hold category ID.*/
    private byte categoryID;
    /**variable hold category text.*/
    private String categoryText;
    /**Default constructor of class.*/
    public Category() {
    };
    /**Parametric constructor.
     * @param categoryIDIn - category ID
     * @param categoryTextIn - category text*/
    public Category(final byte categoryIDIn, final String categoryTextIn) {
        this.categoryID = categoryIDIn;
        this.categoryText = categoryTextIn;
    }
    /**Getter for ID field.
     * @return byte category ID*/
    public final  byte getCategoryID() {
        return categoryID;
    }
    /**Getter for category name field.
     * @return string category name*/
    public final String getCategoryText() {
        return categoryText;
    }
    /**Setter for categoryId field.
     * @param categoryIDIn - category Id
     * @return this instance
     */
    public final Category setCategoryID(final byte categoryIDIn) {
        final byte allCat = -1;
        final byte firstCat = 0;
        final byte lastCat = 6;
        if (categoryIDIn <= allCat
                || categoryIDIn == firstCat
                || categoryIDIn > lastCat) {
            throw new NumberFormatException("Invalid category number");
        } else {
            this.categoryID = categoryIDIn;
            return this;
        }
    }
    /**Setter for category name field.
     * @param categoryTextIn - String name of category
     * @return this instance
     */
    public final Category setCategoryText(final String categoryTextIn) {
        this.categoryText = categoryTextIn;
        return this;
    }

    @Override
    public final boolean equals(final Object category) {
        if (this == category) {
            return true;
        }
        if (category == null) {
            return false;
        }
        if (getClass() != category.getClass()) {
            return false;
        }
        Category other = (Category) category;
        if (this.categoryID != other.getCategoryID()) {
            return false;
        }
        if (!this.categoryText.equals(other.getCategoryText())) {
            return false;
        }
        return true;
    }
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + categoryID;
        result = prime * result
                + ((categoryText == null) ? 0 : categoryText.hashCode());
        return result;
    }
}
