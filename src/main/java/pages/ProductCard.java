package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class ProductCard {

    private SelenideElement addProductContainer;
    private SelenideElement addProductName;
    private SelenideElement addImage;
    private SelenideElement addAmountProduct;
    private SelenideElement addStar;
    private SelenideElement addRating;
    private SelenideElement addReviews;
    private SelenideElement addSalePrise;
    private SelenideElement addPriseWithoutSale;
    private SelenideElement addIconMBonus;
    private SelenideElement addTextMBonus;
    private SelenideElement addToCartButton;
    private SelenideElement addFavoritesButton;
    private SelenideElement addComparison;
    private SelenideElement addContainerProduct;


    /**
     * Нужный контейнер определим по имени, далее поднимаемся к началу контейнера нужного товара
     */

    private final String XPATH_CONTAINER_NAME = "//a[contains(text(), '";
    private final String XPATH_CONTAINER = "')]/../../../..//";

    ProductCard(String productName) {

        //Имя продукта
        addProductName = Selenide.$x("//a[contains(@class, 'product-title__text') and contains(text(), '" + productName + "')]");

        //Контейнер
        addContainerProduct = Selenide.$x("//div[contains(@class, 'product-cards-layout__item')]");

        String containerPath = String.format(XPATH_CONTAINER_NAME + productName + XPATH_CONTAINER);

        //Контейнер продукта
        addProductContainer = Selenide.$x(containerPath);

        //Изображение продукта
        addImage = Selenide.$x(containerPath + "a[contains(@class, 'product-picture-link')]");

        //Количество продукта (не видима, если количество товара более 1, если 1, то высвечивается "осталась 1 штука"
        addAmountProduct = Selenide.$x(containerPath + "div[contains(@class, 'product-notification')]");

        //Иконка со звездой
        addStar = Selenide.$x(containerPath + "span[contains(@class, 'stars-container')]/mvid-icon");

        //Рейтинг товара
        addRating = Selenide.$x(containerPath + "span[contains(@class, 'stars-container')]/span");

        //Отзывы покупателей
        addReviews = Selenide.$x(containerPath + "div[contains(@class, 'product-rating ')]/span");

        //Цена со скидкой (имеется не у каждого товара)
        addSalePrise = Selenide.$x(containerPath + "div[contains(@class, 'price price--list ng-star-inserted')]/span[contains(@class, 'main-value')]");

        //Цена без скидки
        addPriseWithoutSale = Selenide.$x(containerPath + "div[contains(@class, 'price price--list ng-star-inserted')]/span[contains(@class, 'sale-value')]");

        //Иконка Мбонуса
        addIconMBonus = Selenide.$x(containerPath + "mvid-icon[contains(@type, 'm-bonus')]");

        //Количество Мбонусов
        addTextMBonus = Selenide.$x(containerPath + "span[contains(@class, 'mbonus-block__value')]");

        //Кнопка "Добавить в корзину"
        addToCartButton = Selenide.$x(containerPath + "button[contains(@class, 'button ng-star-inserted')]");

        //Кнопка "Добавить в избранное"
        addFavoritesButton = Selenide.$x(containerPath + "mvid-icon[contains(@type, 'love')]");

        //Кнопка "Сравнение"
        addComparison = Selenide.$x(containerPath + "mvid-icon[contains(@type, 'histogram')]");

    }


    public ProductCard(){
    }

    static ProductCard getProductCard(String productName) {
        return new ProductCard(productName);
    }

    public SelenideElement getProductName() {
        return addProductName;
    }

    public SelenideElement getProductContainer(){return addProductContainer;}

    public SelenideElement getImage() {return addImage;}

    public SelenideElement getAmountProduct() {return addAmountProduct;}

    public SelenideElement getStar() {return addStar;}

    public SelenideElement getRating() {return addRating;}

    public SelenideElement getReviews() {return addReviews;}

    public SelenideElement getSalePrise() {return addSalePrise;}

    public SelenideElement getPriseWithoutSale() {return addPriseWithoutSale;}

    public SelenideElement getIconMBonus() {return addIconMBonus;}

    public SelenideElement getTextMBonus() {return addTextMBonus;}

    public SelenideElement getToCartButton() {return addToCartButton;}

    public SelenideElement getFavoritesButton() { return addFavoritesButton;}

    public SelenideElement getComparison() {return addComparison;}

    public SelenideElement getContainerProduct() {return addContainerProduct;}

}









