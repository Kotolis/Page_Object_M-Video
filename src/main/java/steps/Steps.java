package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import pages.FilterElem;
import pages.MvideoPageElem;


public class Steps {


    private FilterElem filterElem = Selenide.page(new FilterElem());
    private MvideoPageElem mvideoPageElem = Selenide.page(new MvideoPageElem());

    public void clickCheckBoxFilter(String filterName, String checkBoxName) {
        filterElem.selectCheckBoxFilter(filterName, checkBoxName).shouldBe(Condition.visible).scrollIntoView("{block: \"center\"}").click();

    }

    public void clickToggleButton(String filterName) {
        filterElem.getToggleButton(filterName).shouldBe(Condition.visible).scrollIntoView("{block: \"center\"}").click();
    }

    public void clickSwitchButton(){mvideoPageElem.getSwitchButton();
    }

    public void searchProductOnListing(String productName){
        mvideoPageElem.searchProduct(productName);
    }

    public void clickOpenAllElements(String filterName) {filterElem.selectOpenAll(filterName);}

    public void clickOpenCheckBox(String filterName) {filterElem.selectOpenCheckBox(filterName);}

}