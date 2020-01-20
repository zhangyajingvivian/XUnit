package service.tag.api;

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
 * @create 2020-01-20 11:48 AM
 */
public class Tag {
    public int tagId = 2;

    public Response create(String tagName) {
        Map<String, Object> body = new HashMap<>();
        body.put("tagname", tagName);

        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).
                        body(body).
                when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/tag/create").
                then().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }

    public Response update(int tagId, String tagName) {
        Map<String, Object> body = new HashMap<>();
        body.put("tagid", tagId);
        body.put("tagname", tagName);

        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).
                        body(body).
                        when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/tag/update").
                        then().
                        body("errcode", equalTo(0)).
                        extract().
                        response();
    }

    public Response delete(int tagId) {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        queryParam("tagid", tagId).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/tag/delete").
                then().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }

    public Response get(int tagId) {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        queryParam("tagid", tagId).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/tag/get").
                then().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }

    public Response addtagusers(int tagId, String[] userlist, int[] partylist) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("tagid", tagId);
        body.put("userlist", userlist);
        body.put("partylist", partylist);

        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).body(body).
                when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers").
                then().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }

    public Response deltagusers(int tagId, int[] userlist, int[] partylist) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("tagid", tagId);
        body.put("userlist", userlist);
        body.put("partylist", partylist);

        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).body(body).
                when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers").
                then().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }

    public Response list() {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/tag/list").
                then().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }
}
