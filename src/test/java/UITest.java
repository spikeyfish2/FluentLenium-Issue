import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import pages.FirstPage;

public class UITest extends FluentTest {


    @Page
    FirstPage firstPage;

    @Test
    public void testUsingAwait() {
        goTo("http://fluent.blundell.io/");

        firstPage.isAt();

        firstPage.makeAnAlert();

        firstPage.waitForSecondAlertUsingAwait();
    }

    @Test
    public void testUsingSleep() throws Exception {
        goTo("http://fluent.blundell.io/");

        firstPage.isAt();

        firstPage.makeAnAlert();

        firstPage.waitForSecondAlertUsingSleep();
    }


}
