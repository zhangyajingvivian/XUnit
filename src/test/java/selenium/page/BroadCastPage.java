package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-27 8:55 PM
 */
public class BroadCastPage extends BasePage{

    public BroadCastPage send(String ranage, String title,
                              String body, String summary, String author) {
        findElement(By.linkText("选择需要发消息的应用")).click();
        findElement(By.cssSelector(".ww_icon_AppNotice")).click();
        findElement(By.linkText("确定")).click();
        findElement(By.linkText("选择发送范围")).click();
        findElement(By.id("memberSearchInput")).sendKeys(ranage);
        findElement(By.cssSelector(".js_search_item")).click();
        findElement(By.linkText("确认")).click();

        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        driver.switchTo().frame(0);
        findElement(By.cssSelector(".msg_noticeEditor_frameBody")).sendKeys(body);
        driver.switchTo().parentFrame();

        ((JavascriptExecutor)(driver)).executeScript("window.scroll(0, 800)");

        findElement(By.cssSelector(".msg_edit_infoItem_textWord")).click();
        findElement(By.cssSelector(".qui_textarea"), 0).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_sendName"), 0).sendKeys(author);
        ((JavascriptExecutor)(driver)).executeScript("window.scroll(0, 800)");
        findElement(By.linkText("发送")).click();
        findElement(By.linkText("确定")).click();
        return this;
    }

    public List<String> getSendeMsg() {
        findElement(By.linkText("已发送")).click();
        List<String> msg = new ArrayList<>();
        driver.findElements(By.cssSelector(".msg_history_msgList_td")).forEach(element -> {
            msg.add(element.getText());
        });
        return msg;
    }

}
