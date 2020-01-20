package service.department.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.department.api.Department;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2020-01-19 8:48 PM
 */
public class TestDepartment {

    static Department department = new Department();

    @BeforeAll
    public static void beforeAll() {
        ArrayList<Integer> ids = department.list(department.parentDepartId).
                then().extract().body().path("department.findAll { d -> d.parentid == " + department.parentDepartId + "}.id");
        ids.forEach(id -> department.delete(id));
    }

    @Test
    public void list() {
        department.list(department.parentDepartId).
                then().body("errmsg", equalTo("ok"));
    }

    @Test
    public void create() {
        String name = "研发部";
        department.createDepart("研发部").
                then().body("errmsg", equalTo("created"));
        department.list(department.parentDepartId).
                then().body("department.findAll { d -> d.name == '" + name + "'}", hasSize(1));
    }

    @Test
    public void delete() {
        int id = department.createDepart("部门3").path("id");
        department.delete(id).then().body("errmsg", equalTo("deleted"));
    }
}
