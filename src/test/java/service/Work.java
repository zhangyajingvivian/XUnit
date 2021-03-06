package service;

import org.apache.commons.lang3.StringUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * 描述:
 *
 * @author 张雅静
 * @create 2020-01-19 8:53 PM
 */
public class Work {
    private static Work instance;
    private static String token;

    private Work(){

    }

    public static Work getInstance() {
        if (instance == null) {
            instance = new Work();
        }

        return instance;
    }

    public String getToken() {
        if (StringUtils.isEmpty(token)) {
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
        }
        return token;
    }
}
