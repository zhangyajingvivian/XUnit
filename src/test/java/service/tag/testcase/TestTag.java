package service.tag.testcase;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import service.tag.api.Tag;
import service.user.api.User;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2020-01-20 2:14 PM
 */
public class TestTag {
    static Tag tag = new Tag();
    static User user = new User();

    @BeforeAll
    public static void init() {

    }

    @Test
    public void create() {
        String tagName = "测试";
        ArrayList<Integer> ids = tag.list().then().log().all().extract().path("taglist.findAll {tag -> tag.tagname == '"+tagName+"'}.tagid");
        ids.forEach(id -> tag.delete(id));

        tag.create(tagName).then().log().all().body("errmsg", equalTo("created"));
    }

    @Test
    public void update() {
        String tagName = "dev";
        tag.update(tag.tagId, tagName + "-update").then().body("errmsg", equalTo("updated"));
        tag.update(tag.tagId, tagName).then().body("errmsg", equalTo("updated"));
    }

    @Test
    public void delete() {
        int tagId = tag.create("for-delete").then().extract().path("tagid");
        tag.delete(tagId).then().body("errmsg", equalTo("deleted"));
    }

    @Test
    public void get() {
        String userId = "dalian";
        user.create(userId, new HashMap<>());
        tag.addtagusers(tag.tagId, new String[]{userId}, new int[]{});

        tag.get(tag.tagId).then().body("errmsg", equalTo("ok")).body("userlist.userid", hasItem(userId));
    }

    @Test
    public void list() {
        tag.list().then().body("errmsg", equalTo("ok"));
    }
}
