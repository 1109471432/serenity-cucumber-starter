package starter.search;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class LookForInformation {
    public static Performable about(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
                Enter.theValue(searchTerm)
                        .into(SearchForm.SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }

    public static Performable apiTest() {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T t) {
                Response response = SerenityRest.given().get("https://zephyrsquad.docs.apiary.io/");
                assert response.statusCode() == 201;
            }
        };
    }
}
