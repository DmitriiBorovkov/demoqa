package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxText {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/text-box/");
        $("[id=userName]").setValue("Dmitry").pressEnter();
        $("[id=userEmail]").setValue("dmitry@dmitry.com").pressEnter();
        $("[id=currentAddress]").setValue("Moscow").pressEnter();
        $("[id=permanentAddress]").setValue("Not Moscow").pressEnter();
        $("[id=submit]").click();

        $("#output #name").shouldHave(text("Dmitry"));
        $("#output #email").shouldHave(text("dmitry@dmitry.com"));
        $("#output #currentAddress").shouldHave(text("Moscow"));
        $("#output #permanentAddress").shouldHave(text("Not Moscow"));
    }
}
