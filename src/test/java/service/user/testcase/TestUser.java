package service.user.testcase;

import org.junit.jupiter.api.Test;
import service.department.api.Department;
import service.user.api.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2020-01-20 4:00 PM
 */
public class TestUser {
    static User user = new User();
    static Department department = new Department();

    @Test
    public void get() {
        String userId = "ZhangYaJing";
        user.get(userId).then().body("name", equalTo("张雅静"));
    }

    @Test
    public void update() {
        // TODO: 2020/1/20 add more testcase
        String userId = "ZhangYaJing";
        String nameNew = "name for testing";
        Map<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("address", "address for testing");
        user.update(userId, data);
        user.get(userId).then().body("name", equalTo(nameNew));
    }

    @Test
    public void create() {
        String name = "name for create";
        String userId = "zhangyajing_" + System.currentTimeMillis();

        HashMap<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("department", new int[]{1, 2});
        body.put("email", System.currentTimeMillis() + "@163.com");
        body.put("address", "address for create");

        user.create(userId, body).then().body("errcode", equalTo(0));

        user.get(userId).then().body("name", equalTo(name));
    }

    @Test
    public void createFromTemplate() {
        String name = "name for create";
        String userId = "zhangyajing_" + System.currentTimeMillis();

        HashMap<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("department", new int[]{1, 2});
        body.put("email", System.currentTimeMillis() + "@163.com");

        user.create(userId, body).then().body("errcode", equalTo(0));

        user.get(userId).then().body("name", equalTo(name));
    }

    @Test
    public void cloneUser() throws IOException {
        String name = "name for create";
        String userId = "zhangyajing_" + System.currentTimeMillis();

        HashMap<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("email", System.currentTimeMillis() + "@163.com");

        user.create(userId, body).then().body("errcode", equalTo(0));

        user.get(userId).then().log().all().body("name", equalTo(name));
    }

    @Test
    public void delete() {
        String name = "name for create";
        String userId = "zhangyajing_" + System.currentTimeMillis();

        HashMap<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("email", System.currentTimeMillis() + "@163.com");

        user.create(userId, body).then().body("errcode", equalTo(0));

        user.delete(userId).then().body("errcode", equalTo(0));
        user.get(userId).then().body("errcode", not(equalTo(0)));
    }

    @Test
    public void batchDelete() {
        for (int i = 0; i < 10; i++) {
            String name = "name for create" + i;
            String userId = "zhangyajing_" + System.currentTimeMillis();

            HashMap<String, Object> body = new HashMap<>();
            body.put("name", name);
            body.put("department", new int[]{1});
            body.put("email", System.currentTimeMillis() + "@163.com");

            user.create(userId, body).then().body("errcode", equalTo(0));
        }
        List userIds = user.simplelist(department.parentDepartId).then().extract().body().path("userlist.userid");
        user.batchdelete(userIds).then().body("errcode", equalTo(0));
        user.simplelist(department.parentDepartId).then().body("userlist", hasSize(0));
    }

    @Test
    public void getlist() {
        int departmentId = 1;
        user.simplelist(departmentId).then().body("errcode", equalTo(0));
    }

    @Test
    public void list() {
        user.list(department.parentDepartId, 1).then().log().all();
    }
}
