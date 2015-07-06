package com.softserveinc.ita.commentstests.tools.controls;

import java.util.ArrayList;
import java.util.List;

import com.softserveinc.ita.commentstests.domain.repositories.
CategoriesRepository;
import com.softserveinc.ita.commentstests.tools.ContextVisible;
import com.softserveinc.ita.commentstests.tools.ControlLocation;
import com.softserveinc.ita.commentstests.tools.ControlWrapper;
import com.softserveinc.ita.commentstests.tools.ControlWrapperList;
import com.softserveinc.ita.commentstests.tools.SelectWrapper;
import com.softserveinc.ita.commentstests.tools.controls.interfaces.IDropdown;

/**
 * This class makes a wrapper for dropdown.
 *
 * @author Dp-076 ATQC
 */
public final class Dropdown implements IDropdown {
    /**
    * Object of SelectWrapper class.
    */
    private SelectWrapper select;
    /**
     * Object of IDropdown interface.
     */
    private IDropdown dropdown;
    /**
     * Constructor.
     *
     * @param theSelect
     *            - object of SelectWrapper class.
     */
    private Dropdown(final SelectWrapper theSelect) {
        select = theSelect;
    }

    @Override
    public void selectByIndex(final int index) {
        select.selectByIndex(index);

    }

    @Override
    public void selectByValue(final String value) {
        select.selectByValue(value);

    }

    @Override
    public void selectByVisibleText(final String text) {
        select.selectByVisibleText(text);

    }

    @Override
    public void diselect() {
        select.deselectAll();

    }
    /**
     * This method get all dropdown categories in a list.
     * @return list of categories
     */
    public List<String> getValuesList() {
        List<String> dropdownValuesList = new ArrayList<String>();
        for (ControlWrapper item : ControlWrapperList.getList(select
                .getOptions())) {
            dropdownValuesList.add(item.getText());
        }
        return dropdownValuesList;

    }
    /**
     * This method get all selected dropdown categories in a list.
     * @return list of selected categories
     */
    public List<String> getSelectedValuesList() {
        List<String> dropdownSelectedValuesList = new ArrayList<String>();
        for (ControlWrapper item : ControlWrapperList.getList(select
                .getAllSelectedOptions())) {
            dropdownSelectedValuesList.add(item.getText());
        }
        return dropdownSelectedValuesList;

    }
    /**
     * This method check all categories in dropdown.
     * @return true, if categories on their places and false if not
     */
    public boolean isAllCategoriesOnTheirPlaces() {
        boolean result = false;
        for (int i = 0; i < dropdown.getValuesList().size(); i++) {
            if (dropdown
                    .getValuesList()
                    .get(i)
                    .equals(CategoriesRepository.getAllDropBoxCategories()[i]
                            .getCategoryText())) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;

    }
    /**
     * Method finds dropdown by id.
     * @param id locator
     * @return get dropdown by id
     */
    public static IDropdown getById(final String id) {
        return get(ControlLocation.getById(id));
    }
    /**
     * Method finds dropdown by name.
     * @param searchedName locator
     * @return get dropdown by name
     */
    public static IDropdown getByName(final String searchedName) {
        return get(ControlLocation.getByName(searchedName));
    }
    /**
     * Method finds dropdown by xpath.
     * @param xpathExpression locator
     * @return get dropdown by xpath
     */
    public static IDropdown getByXpath(final String xpathExpression) {
        return get(ControlLocation.getByXPath(xpathExpression));
    }
    /**
     * Method returns dropdown as WebElement.
     * @param controlLocation locator
     * @return get dropdown as WebElement
     */
    public static IDropdown get(final ControlLocation controlLocation) {
        return new Dropdown(new SelectWrapper(ContextVisible.get().get(
                controlLocation)));
    }

}
