package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;


public class FilterElem {

    //Путь до кнопки чекбокса
    public SelenideElement selectCheckBoxFilter(String filterName, String checkBoxName) {
        SelenideElement checkBox = $x("//*[contains(text(), '" + filterName + "')]/../..//a[contains(text(), '" + checkBoxName + "')]/../..//mvid-icon[contains(@type, 'checkbox')]");
        return checkBox;
    }
    //Путь до кнопки "Свернуть/развернуть" контейнер чекбокса
    public SelenideElement getOpenCheckBox(String filterName){
        SelenideElement openCheckBox = $x("//*[contains(text(), '" + filterName + "')]/..");
        return openCheckBox;
    }

    //Путь до контейнера с чекбоксами. Нужен для проверки.
    public SelenideElement getContainerCheckBox(String filterName){
        SelenideElement container = $x("//*[contains(text(), '" + filterName + "')]/../../div");
        return container;
    }

    //Путь до кнопки "Показать еще" в чекбоксе
    public SelenideElement getOpenAllElements(String filterName){
        SelenideElement openAllElements = $x("//*[contains(text(), '" + filterName + "')]/../..//p[contains(@class, 'show-all')]");
        return openAllElements;
    }

    //Путь до кнопки-слайдера
    public SelenideElement getToggleButton(String filterName) {
        SelenideElement toggleButton = $x("//*[contains(text(), '" + filterName + "')]/../../../div[contains(@class, 'slider')]");
        return toggleButton;
    }

    //Нажатие на кнопку "Показать еще", если она присутствует в требуемом контейнере
    public void selectOpenAll(String filterName){
        if(getOpenAllElements(filterName).isDisplayed()){
            getOpenAllElements(filterName).shouldBe(Condition.visible).scrollIntoView("{block: \"center\"}").click();
        }
    }

    //Если контейнер с чекбоксами не открыт, то нажате на кнопку "Развернуть"
    public void selectOpenCheckBox(String filterName){
        if (!getContainerCheckBox(filterName).isDisplayed()){
            getOpenCheckBox(filterName).shouldBe(Condition.visible).scrollIntoView("{block: \"center\"}").click();
        }

    }

}





