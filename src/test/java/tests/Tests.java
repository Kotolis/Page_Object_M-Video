package tests;

import steps.Steps;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class Tests {


    @Test
    public void test(){
        Selenide.open("https://www.mvideo.ru/smartfony-i-svyaz-10/smartfony-205");
        //Selenide.sleep(3000);
        Steps steps = new Steps();
        steps.clickSwitchButton();
        steps.clickOpenCheckBox("Бренд");
        steps.clickOpenAllElements("Бренд");
        steps.clickCheckBoxFilter("Бренд", "Samsung");
        steps.clickToggleButton("Только в наличии");
        steps.searchProductOnListing("Смартфон Samsung Galaxy A22 128GB White (SM-A225F)");
    }

}
