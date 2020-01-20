package service.department.api;

import io.restassured.response.Response;
import service.Work;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2020-01-20 3:49 PM
 */
public class User {

    public void create(String userId) {
//        HashMap<String, Object> body = new HashMap<>();
//        body.put()
//        return given().post().then().extract().response();
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
}
