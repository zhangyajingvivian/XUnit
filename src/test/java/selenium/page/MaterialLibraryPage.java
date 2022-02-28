package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-12-09 10:31 PM
 */
public class MaterialLibraryPage extends BasePage{

    public MaterialLibraryPage addText(String text) {
        findElement(By.linkText("文字")).click();
        findElement(By.linkText("添加文字")).click();
        findElement(By.cssSelector(".qui_textarea")).sendKeys(text);
        findElement(By.linkText("保存")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MaterialLibraryPage addMpNews(String title, String body) throws InterruptedException {
        findElement(By.linkText("图文")).click();
        findElement(By.linkText("添加图文")).click();
        Thread.sleep(1000);
        findElement(By.cssSelector(".js_amrd_title")).sendKeys(title);
        driver.switchTo().frame(0);
        findElement(By.cssSelector(".msg_mpNewsEditor_frameBody")).sendKeys(body);
        driver.switchTo().parentFrame();

        ((JavascriptExecutor)(driver)).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@class='js_showAppSelect']")));
        findElement(By.cssSelector(".msg_infoItem_coverPlaceHolder")).click();
        findElements(By.xpath("//input[@class='ww_fileInput js_file']"), 0).get(0).sendKeys("/Users/zhangyajing/Desktop/pic/1.png");
        findElement(By.linkText("确定")).click();
        Thread.sleep(1000);
        findElement(By.linkText("完成")).click();
        return this;
    }

    public MaterialLibraryPage addPic() throws InterruptedException {
        findElement(By.linkText("图片")).click();
        findElement(By.linkText("添加图片")).click();
        driver.findElement(By.id("js_upload_input")).sendKeys("/Users/zhangyajing/Desktop/pic/22.jpg");
        Thread.sleep(1000);
        findElement(By.linkText("完成")).click();
        return this;
    }

    public MaterialLibraryPage addVoice() throws InterruptedException {
        findElement(By.linkText("语音")).click();
        findElement(By.linkText("添加语音")).click();
        driver.findElement(By.id("js_upload_input")).sendKeys("/Users/zhangyajing/Desktop/pic/msg.mp3");
        Thread.sleep(1000);
        findElement(By.linkText("完成")).click();
        return this;
    }

    public MaterialLibraryPage addMedia() throws InterruptedException {
        findElement(By.linkText("视频")).click();
        findElement(By.linkText("添加视频")).click();
        findElement(By.cssSelector(".js_amrd_title")).sendKeys("media title");
        driver.findElement(By.cssSelector(".ww_fileInput")).sendKeys("/Users/zhangyajing/Desktop/pic/4.mov");
        Thread.sleep(1000);
        findElement(By.linkText("完成")).click();
        return this;
    }
}
