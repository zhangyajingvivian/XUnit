package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-25 10:15 PM
 */
public class App extends BasePage{

    public App loginWithCookie() {
        String url = "https://work.weixin.qq.com/";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("pageLoadStrategy", "none");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        findElement(By.linkText("企业登录")).click();

        driver.manage().addCookie(new Cookie("wwrtx.sid", "BrrtaUJaOA-VbycDsOu1bWMXIsmyL4gNufiLzlpRxABjb29g_EYcf5moCXDmv7Zz"));
        driver.navigate().refresh();
        return this;
    }

    public ContactPage toContact() throws InterruptedException {
        Thread.sleep(1000);
        waitClickable(By.id("menu_contacts"), 20);
        findElement(By.id("menu_contacts")).click();
        return new ContactPage();
    }

    public ContactPage toMemberAdd() {
        waitClickable(By.linkText("添加成员"), 10);
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }

    public BroadCastPage toBroadCastPage() {
        findElement(By.id("menu_manageTools")).click();
        findElement(By.cssSelector(".ww_icon_AppGroupMessageBig")).click();
        return new BroadCastPage();
    }

    public MaterialLibraryPage toMaterilLibraryPage() {
        findElement(By.id("menu_manageTools")).click();
        findElement(By.cssSelector(".ww_icon_AppMaterialBig")).click();
        return new MaterialLibraryPage();
    }
}
