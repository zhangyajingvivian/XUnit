package service.department.testcase;

import org.junit.Test;
import service.department.api.Department;
import service.department.api.User;

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
    public void list() {
        user.list(department.parentDepartId, 1).then().log().all();
    }
}
