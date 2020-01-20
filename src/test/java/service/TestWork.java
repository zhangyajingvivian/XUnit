package service;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
/**
 * 描述:
 *
 * @author 张雅静
 * @create 2020-01-19 6:43 PM
 */
public class TestWork {
    static String token = "sHiMBEAiKBzVFozU8hyoPIbU2g2jbCEsl7_RFoBhTZgIrEyw6PmhzkkNZ_j0_r1K_eGfSTycQdGiOkgz-5GqLBTHJSZV4CjBpMfEw3uGYGUbQQTQdlclbjcMc4jhMJmBJVV1pi9jLYQU0ogvlICfFoyjxkIYJyIIl8iE5A2oDAfons3gAi2AYLp-eVMkbrlK6x0GkLgORtoshxjZxkplPA";
    static int parentId = 1;

    @BeforeAll
    public static void getToken() {
        token = given().param("corpid", "wwb59b30f640fbfe87").
                param("corpsecret", "jk9tW4ZflqXzA7eEjjGoZbuf60xUndcYFkFD0frVK4M").
        when().
                log().all().
                get("https://qyapi.weixin.qq.com/cgi-bin/gettoken").
        then().
                log().all().
                body("errcode", equalTo(0)).
        extract().
                body().path("access_token");
        System.out.println(token);
    }

    @Test
    public void departCreate() {
        int secondParentId = createDepart("定向班第二期", parentId);
        createDepart("张雅静", secondParentId);
        // TODO: 2020/1/19 需要用list接口校验，但是如果编写list的请求，会导致代码冗余带来维护问题，所以引入po思想
    }

    @Test
    public void departList() {
        given().
                queryParam("access_token", token).
                queryParam("id", parentId).
        when().
                get("https://qyapi.weixin.qq.com/cgi-bin/department/list").
        then().
                body("errcode", equalTo(0));
    }

    private int createDepart(String departName, int parentId) {
        Map<String, Object> body = new HashMap<>();
        body.put("name", departName);
        body.put("parentid", parentId);

        int departId =
                given().
                        queryParam("access_token", token).
                        contentType(ContentType.JSON).
                        body(body).
                when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/department/create").
                then().
                        log().all().
                        body("errcode", equalTo(0)).
                        body("errmsg", equalTo("created")).
                extract().
                        path("id");
        return departId;
    }
}
