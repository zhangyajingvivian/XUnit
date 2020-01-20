package service.department.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Work;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2020-01-19 8:51 PM
 */
public class Department {
    public int parentDepartId = 7;

    public Response list(int id) {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        queryParam("id", id).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/department/list").
                then().
                        log().all().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }

    public Response createDepart(String departName, int parentId) {
        Map<String, Object> body = new HashMap<>();
        body.put("name", departName);
        body.put("parentid", parentId);

        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).
                        body(body).
                when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/department/create").
                then().
                        body("errcode", equalTo(0)).
                        body("errmsg", equalTo("created")).
                extract().
                        response();
    }

    public Response createDepart(String departName) {
        return createDepart(departName, parentDepartId);
    }

    public Response delete(int id) {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        queryParam("id", id).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/department/delete").
                then().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }
}
