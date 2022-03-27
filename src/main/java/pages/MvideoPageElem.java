package pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;


public class MvideoPageElem {


    public static ProductCard getProductCard(String productName) {
        return ProductCard.getProductCard(productName);
    }

    private ElementsCollection paginationButton = $$x("//li[contains(@class, 'page-item')]");

    @FindBy(xpath = "//mvid-button[contains(@class, 'button--list')]/button")
    private SelenideElement switchButton;

    @FindBy(xpath = "//mvid-button[contains(@class, 'button--list')]//mvid-icon[contains(@class, 'button-icon--selected')]")
    private SelenideElement listButton;

    //Проверка на то, что если в кнопке переключения на список будет отсутстовать "selected",
    // то будет нажата кнопка переключения отображения продуктов
    public void getSwitchButton() {
        if (!listButton.exists()) {
            switchButton.shouldBe(visible).scrollIntoView("{block: \"center\"}").click();
        }
    }

    //Кнопка пагинации переключения вправо будет нажиматься, если она активна.
    // Не активна она становится, когда мы находимся на последней странице
     public void clickPaginationButton() {
        if (paginationButton.last().exists()) {
            paginationButton.last().scrollIntoView("{block: \"center\"}").click();
        }
    }

    //Поиск товара на странице. Если товар не найден на страние,
    // то происходит перелистывание страницы до тех пор, пока не дойдем до последней страницы
    public void searchProduct(String productName) {
        ElementsCollection productsCards = $$(By.className("product-cards-layout__item"));
        while (paginationButton.last().exists()) {
            getProductCard(productName).getContainerProduct().shouldBe(visible);

            for (int i = 0; i < productsCards.size(); i++) {
                productsCards.get(i).scrollIntoView("{block: \"center\"}");
            }
            //
            if (getProductCard(productName).getProductName().isDisplayed()) {
                getProductCard(productName).getProductName().scrollIntoView("{block: \"center\"}");
                Selenide.sleep(4000);
                break;
            } else {
                clickPaginationButton();

                }

            }

        }
    }











