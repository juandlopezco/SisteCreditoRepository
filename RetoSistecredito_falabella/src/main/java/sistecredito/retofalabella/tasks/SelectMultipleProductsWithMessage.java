package sistecredito.retofalabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import sistecredito.retofalabella.userinterfaces.HomePage;
import sistecredito.retofalabella.utils.Constants;
import sistecredito.retofalabella.utils.Wait;

public class SelectMultipleProductsWithMessage implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(HomePage.ADD_PRODUCT));
        actor.attemptsTo(Click.on(HomePage.BUTTON_ADD_BAG));

        while (HomePage.BUTTON_INCREMENT_PRODUCT.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(Click.on(HomePage.BUTTON_INCREMENT_PRODUCT));
            WaitUntil.the(HomePage.BUTTON_INCREMENT_PRODUCT, WebElementStateMatchers.isCurrentlyVisible());
        }
        actor.remember(Constants.TEXT_STOCK,HomePage.TEXT_STOCK.resolveFor(actor).getText());
    }
    public static SelectMultipleProductsWithMessage selectMultipleProducts(){
        return Tasks.instrumented(SelectMultipleProductsWithMessage.class);
    }
}
