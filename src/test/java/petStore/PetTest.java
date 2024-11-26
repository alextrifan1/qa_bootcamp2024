package petStore;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import juiceShop.frameworkUtils.Utils;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import petStore.models.Category;
import petStore.models.Pet;
import petStore.models.Tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;

public class PetTest extends BaseTest {

    @DataProvider(name = "PetData")
    public Iterator<Object[]> petDp() {
        Collection<Object[]> dp = new ArrayList<>();
        //                   id,    category: (id, name), name, photUrls,               tags:(id, tagName),                 status
        dp.add(new String[] {"767", "231", "Dog", "Goldie", "http://myurl.com", "567", "why are you reading this?", "sold"});
        dp.add(new String[] {"999", "111", "Cat", "MiauMiau", "http://myurl.com", "267", "keep reading, it's cool", "available"});
        dp.add(new String[] {"1", "333", "Dog", "GoodDogMaadCity", "http://myurl.com", "222", "genericTag", "pending"});
        dp.add(new String[] {"217", "231", "Fish", "Nemo", "http://myurl.com", "567", "anotherGenericTag", "pending"});
        dp.add(new String[] {"888", "231", "Cat", "CoolCat", "http://myurl.com", "567", "just a cool cat", "sold"});
        return dp.iterator();
    }

    @DataProvider(name = "FindPetById")
    public Iterator<Object[]> findPetDp() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"222", "200", "Beagle_Eagle"});
        dp.add(new String[] {"767", "200", "Goldie"});
        //dp.add(new String[] {"322", "200", "Rubye"});
        dp.add(new String[] {"10", "200", "doggie"});
        return dp.iterator();
    }
    @DataProvider(name= "FindPetByStatus")
    public Iterator<Object[]> findPetStatusDp() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"available"});
        dp.add(new String[] {"pending"});
        dp.add(new String[] {"sold"});
        return dp.iterator();
    }

    @DataProvider(name = "DeletePet")
    public Iterator<Object[]> deletePetDp() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"9912321", "404"});
        dp.add(new String[] {"767", "200"});
        return dp.iterator();
    }

    /************************************ GET ************************************/

    @Test(dataProvider = "FindPetById", priority = 4)
    public void findPetById(String petId, String responseCode, String name) {
        Response response = httpRequest.request(Method.GET, "/pet/" + petId);
        Assert.assertEquals(response.getStatusCode(), Integer.parseInt(responseCode));

        JsonPath jsonPathEvaluator = response.jsonPath();

        if (response.getStatusCode() == 404) {
            Assert.assertEquals(jsonPathEvaluator.getString("message"), "Pet not found");
        }
        else if (response.getStatusCode() == 200) {
            Assert.assertEquals(jsonPathEvaluator.getString("name"), name);
        }
    }

    @Test(dataProvider = "FindPetByStatus", priority = 3)
    public void findPetByStatus(String status) {
        Response response = httpRequest.request(Method.GET, "/pet/findByStatus?status=" + status);

        Assert.assertEquals(200, response.getStatusCode());

        // pt JSON ai nevoi mereu de un string, foloseste asString, nu toString !!
        String responseBody = response.getBody().asString();
        JSONArray pets = new JSONArray(responseBody);

        for (int i = 0; i < pets.length(); i++) {
            JSONObject pet = pets.getJSONObject(i);
            String petStatus = pet.getString("status");
            Assert.assertEquals(status, petStatus);
        }

    }

    /************************************ POST ************************************/

    @Test(dataProvider = "PetData", priority = 0)
    public void createPet(String id, String cId, String cNane, String name, String photo, String tId, String tName, String status) {
        Category cat = new Category(Integer.parseInt(cId), cNane);
        Tag tag = new Tag(Integer.parseInt(tId), tName);
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photo);
        Pet pet = new Pet(Integer.parseInt(id), cat, name, photoUrls, tags, status);

        Gson gson = new Gson();
        String jsonOutput = gson.toJson(pet);
        //System.out.println(jsonOutput);

        // fara asta iti da cod eroare 415
        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(jsonOutput);
        Response response = httpRequest.request(Method.POST, "/pet");

        Assert.assertEquals(200, response.getStatusCode());

    }

    @Test(priority = 1)
    public void createPetOtherVersion() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "233");
        requestParams.put("name", "doggie");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toString());
        Response response = httpRequest.request(Method.POST, "/pet");
    }

    /************************************ PUT ************************************/

    @Test(priority = 2)
    public void updatePet() {
        String id = "999";

        Response response = httpRequest.request(Method.GET, "/pet/" + id);
        Assert.assertEquals(response.getStatusCode(), 200);

        // vezi daca nu e o metoda mai scurta
        Category cat = new Category(231, "myName");
        Tag tag = new Tag(567, "tagName");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("http://myurl.com");
        Pet pet = new Pet(Integer.parseInt(id), cat, "MiauMiauForever", photoUrls, tags, "pending");

        Gson gson = new Gson();
        String jsonOutput = gson.toJson(pet);

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(jsonOutput);
        response = httpRequest.request(Method.PUT, "/pet");

        Assert.assertEquals(200, response.getStatusCode());

    }

    /************************************ DELETE ************************************/

    @Test(dataProvider = "DeletePet", priority = 5)
    public void deletePet(String id, String status) {
        Response response = httpRequest.request(Method.DELETE, "/pet/" + id);
        Assert.assertEquals(Integer.parseInt(status), response.getStatusCode());
    }
}
