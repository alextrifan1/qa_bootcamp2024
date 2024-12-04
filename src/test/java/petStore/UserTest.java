package petStore;

import com.google.gson.Gson;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import juiceShop.frameworkUtils.Utils;
import petStore.models.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UserTest extends BaseTest{

    @DataProvider(name = "userDp")
    public Iterator<Object[]> userDp () {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {Utils.generateRandomNumber(100) + "", "alex", "alex", "g", "alex@alex.com", "Alex987%", "07222222", "0"});
        return dp.iterator();
    }

    @DataProvider(name = "getUserDp")
    public Iterator<Object[]> getUserDp() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"taar"});
        dp.add(new String[] {"ds"});
        dp.add(new String[] {"pufi"});
        dp.add(new String[] {"nuExista"});
        return dp.iterator();
    }

    @Test(dataProvider = "userDp")
    public void createUser(String id, String username, String name, String surname, String email, String password, String phone, String status) {
        User u = new User(Integer.parseInt(id), username, name, surname, email, password, phone, Integer.parseInt(status));
        Gson gson = new Gson();
        System.out.println(gson.toJson(u));
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(gson.toJson(u));
        Response response = httpRequest.request(Method.POST, "/user");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
//        Utils.serializeToFile(u, "file.txt");
    }

    /************************************ GET ************************************/

    @Test(dataProvider = "getUserDp")
    public void getUserByUsername(String username) {
        Response response = httpRequest.request(Method.GET, "/user/" + username);

        JsonPath jsonPathEvaluator = response.jsonPath();
        if (response.getStatusCode() == 200) {
            Assert.assertEquals(jsonPathEvaluator.getString("username"), username);
        } else if (response.getStatusCode() == 404) {
            Assert.assertEquals(jsonPathEvaluator.getString("message"), "User not found");
        }
    }

    // Asta nu e implementat de ei(25.11.2024)
    // pune conditia ca pica oricum
   /* @Test(dataProvider = "UserLogin")
    public void getUserLogin(String username, String password, String status) {
        Response response = httpRequest.request(Method.GET, "/user/" + "login?username=" + username+ "&password=" + password);

        Assert.assertEquals(response.getStatusCode(), Integer.parseInt(status));

        JsonPath jsonPathEval = response.jsonPath();

//        if (response.getStatusCode() == 400) {
//            Assert.assertEquals(jsonPathEval.getString());
//        } else if (response.getStatusCode() == 200) {
//
//        }
    }*/


    /************************************ POST ************************************/
    @Test(dataProvider = "userDp")
    public void putUser(String id, String username, String firstName, String lastName, String email, String password, String phone, String userstatus) {
        User user = new User(Integer.parseInt(id), username, firstName, lastName, email, password, phone, Integer.parseInt(userstatus));
        Gson gson = new Gson();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(gson.toJson(user));
        Response response = httpRequest.request(Method.POST, "/user");

        Assert.assertEquals(200, response.getStatusCode());
    }

    /************************************ PUT ************************************/

    /************************************ DELETE ************************************/
}
