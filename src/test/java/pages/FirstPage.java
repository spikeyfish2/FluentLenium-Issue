package pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("/")
public class FirstPage extends FluentPage {

    @FindBy(tagName = "h1")
    FluentWebElement title;

    @FindBy(css = ".alert")
    List<FluentWebElement> alerts;

    @FindBy(id = "make-an-alert")
    FluentWebElement makeAlertButton;

    @Override
    public void isAt() {
        assertThat(title.text()).isEqualToIgnoringCase("Fluent Test");
    }

    public void makeAnAlert() {
        makeAlertButton.click();
    }

    public void waitForSecondAlertUsingAwait() {
        await().atMost(10, TimeUnit.SECONDS).until(alerts).size(2);
    }

    public void waitForSecondAlertUsingSleep() throws InterruptedException {
        Thread.sleep(6000);
        assertThat(alerts.size()).isEqualTo(2);
    }



}
