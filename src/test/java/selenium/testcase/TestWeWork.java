package selenium.testcase;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import selenium.page.ContactPage;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-25 9:48 PM
 */
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestWeWork extends DefaultSuiteTest{

    @Test
    public void test_01_add() throws InterruptedException {
        Thread.sleep(1000);
        String phone = "17721174566";
        app.toContact().toEditDepartment("研发部").toMemberAdd().add(phone, phone, phone);
    }
    @Test
    public void test_02_delete() throws InterruptedException {
        Thread.sleep(1000);
        String phone = "17721174564";
        app.toMemberAdd().delete(phone);
    }

    @Test
    public void test_03_deleteCurrentPage() throws InterruptedException {
        Thread.sleep(1000);
        app.toContact().deleteCurrentPage();
    }

    @Test
    public void test_04_importFormFile() throws InterruptedException {
        Thread.sleep(1000);
        app.toContact().importFromFile("/Users/zhangyajing/Downloads/通讯录批量导入模板.xlsx");
    }

    @Test
    public void test_05_addDepartment() throws InterruptedException {
        String fatherDepartment = "研发部";
        String departmentName = "测试部";
        app.toContact().toEditDepartment(fatherDepartment)
                .addDepartment(departmentName);
    }

    @Test
    public void test_06_deleteDepartment() throws InterruptedException {
        String fatherDepartment = "腾讯公司";
        String departmentName = "摄影部";
        app.toContact().toEditDepartment(fatherDepartment, departmentName)
                .deleteDepartment(departmentName);
    }

    @Test
    public void test_07_moveUpDepartment() throws InterruptedException {
        app.toContact().toEditDepartment("财务部").moveUpDepartment();
    }

    @Test
    public void test_08_moveDownDepartment() throws InterruptedException {
        app.toContact().toEditDepartment("财务部").moveDownDepartment();
    }
}
