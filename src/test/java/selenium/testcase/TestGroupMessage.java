package selenium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import selenium.page.App;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-27 9:32 PM
 */
public class TestGroupMessage {
    public static App app;

    @BeforeClass
    public static void beforeAll() {
        app = new App();
        app.loginWithCookie();
    }

    @Test
    public void send() {
        String title = "快递到件通知";
        List<String> sendeMsg = app.toBroadCastPage()
                .send("张雅静", title, "您的快递已到，请到前台领取", "取件通知", "小板凳")
                .getSendeMsg();
        assertThat(sendeMsg, hasItem(title));
    }

}
