package service.user.api;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Work;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2020-01-20 3:49 PM
 */
public class User {

    public Response get(String userId) {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        queryParam("userid", userId).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/user/get").
                then().
                extract().
                        response();
    }

    public Response update(String userId, Map<String, Object> data) {
        data.put("userid", userId);
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).
                        body(data).
                when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/user/update").
                then().
                        log().all().
                        extract().response();
    }

    public Response create(String userId, Map<String, Object> data) {
        data.put("userid", userId);

        String body = template("service/user/api/user.json", data);

        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).
                        body(body).
                        when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/user/create").
                        then().
                        log().all().
                        extract().response();
    }

    public Response clone(String userId, Map<String, Object> data) {
        data.put("userid", userId);

        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).
                        body(data).
                        when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/user/create").
                        then().
                        log().all().
                        extract().response();
    }

    public Response list(int departmentId, int fetchChild) {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        queryParam("department_id", departmentId).
                        queryParam("fetch_child", fetchChild).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist").
                then().
                        body("errcode", equalTo(0)).
                extract().
                        response();
    }

    public Response delete(String userId) {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        queryParam("userid", userId).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/user/delete").
                then().
                extract().
                        response();
    }

    public Response simplelist(int departmentId) {
        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        queryParam("department_id", departmentId).
                        queryParam("fetch_child", 1).
                when().
                        get("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist").
                then().
                        log().all().
                        extract().response();
    }

    public Response batchdelete(List<String> userIds) {
        Map<String, Object> data = new HashMap<>();
        data.put("useridlist", userIds);

        return
                given().
                        queryParam("access_token", Work.getInstance().getToken()).
                        contentType(ContentType.JSON).
                        body(data).
                when().
                        post("https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete").
                then().
                        log().all().
                        extract().response();
    }

    public String template(String templatePath, Map<String, Object> data) {
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(templatePath);
        mustache.execute(writer, data);
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
