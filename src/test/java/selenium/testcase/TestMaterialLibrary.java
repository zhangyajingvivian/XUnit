package selenium.testcase;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-12-09 10:54 PM
 */
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestMaterialLibrary extends DefaultSuiteTest{

    @Test
    public void test_01_addText() {
        app.toMaterilLibraryPage().addText("test for qqq");
    }

    @Test
    public void test_02_addMpNews() throws InterruptedException {
        app.toMaterilLibraryPage().addMpNews("test title", "test body");
    }

    @Test
    public void test_03_addPic() throws InterruptedException {
        app.toMaterilLibraryPage().addPic();
    }

    @Test
    public void test_04_addVoice() throws InterruptedException {
        app.toMaterilLibraryPage().addVoice();
    }

    @Test
    public void test_05_addMedia() throws InterruptedException {
        app.toMaterilLibraryPage().addMedia();
    }
}
