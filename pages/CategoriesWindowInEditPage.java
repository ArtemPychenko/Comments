package com.softserveinc.ita.commentstests.pages;


import com.softserveinc.ita.commentstests.domain.models.Category;
import com.softserveinc.ita.commentstests.tools.controls.Checkbox;
import com.softserveinc.ita.commentstests.tools.controls.Label;
import com.softserveinc.ita.commentstests.tools.controls.Grid;
import com.softserveinc.ita.commentstests.tools.controls.Link;

/**
 * @author Dp-076 ATQC
 *This class allows to create the window with categories on the edit page.
 */
public class CategoriesWindowInEditPage {
    /**
     *The string address of the element.
     */
    private String location;
    /**
     *The grid with the list of categories.
     */
    private Grid categoryList;
    /**
     *An array of available categories.
     */
    private Category[] categoryInstanceArray;

    /**
     * @param theLocation - location of the object elements.
     * The constructor of the class.
     */
    public CategoriesWindowInEditPage(final String theLocation) {
        this.location = theLocation;
        if (Link.getByXpath(location).getText().equals(new String())) {
            categoryInstanceArray = new Category[0];
        } else {
            location = location + "/div";
            this.categoryList = Grid.getByXpath(location);
            categoryInstanceArray = new Category[categoryList.getSize()];
            for (int i = 0; i < categoryList.getSize(); i++) {
                byte categotyId =
                        Byte.parseByte(Checkbox
                                .getById(categoryList, i, "Categories")
                        .getAttribute("value"));
                String categoryName =
                        Label.getByTagName(categoryList, i, "span").getText();
                categoryInstanceArray[i] = new Category()
                .setCategoryID(categotyId)
                .setCategoryText(categoryName);
            }
        }
    }

    /**
     * @param category the category
     */
    public final void clickCheckBox(final Category[] category) {
        for (Category name : category) {
            for (int i = 0; i < categoryList.getSize(); i++) {
                if ((name.getCategoryText())
                        .equals(Label.getByTagName(categoryList, i, "span")
                                .getText())) {
                    Checkbox.getById(categoryList, i, "Categories").click();
                }
            }
        }
    }

    /**
     * @return the array of available categories.
     */
    public final Category[] getCategoryNameList() {
        return this.categoryInstanceArray;
    }

    /**
     * @return an object of this class.
     */
    public final CategoriesWindowInEditPage updateCategoryWindow() {
        return new CategoriesWindowInEditPage(location);
    }

}
