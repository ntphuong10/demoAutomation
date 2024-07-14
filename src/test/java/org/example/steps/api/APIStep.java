package org.example.steps.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.java.en.And;
import org.example.base.BaseAPI;
import org.example.utils.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.example.utils.FilePath.*;
import static org.example.utils.ConstantComponent.*;

public class APIStep {
    BaseAPI baseAPI = new BaseAPI();
    Response response;
    String API_URL;
    Helper helper = new Helper();
    int userID;
    ObjectMapper mapper = new ObjectMapper();
    ArrayNode arrayData;

    @Given("^I have an user$")
    public void iHaveAnUser() {
        API_URL = EnvironmentConfig.URL_API;
    }

    @When("I call API to login into the user")
    public void iCallAPIToGetUser() {
        response = baseAPI.postAPI(API_URL, APIPath.LOGIN, helper.readFileAsJson(LoginBody, true));
    }

    @Then("The API should return status {int}")
    public void theAPIShouldReturnStatus(int statusCode) {
        Assert.assertEquals("Status code incorrect", statusCode, response.getStatusCode());
        token = "Bearer " + helper.readResponseAsJson(response, "token");
    }

    @And("I call API get list User")
    public void iCallAPIGetListUser() {
        response = baseAPI.getAPI(API_URL + APIPath.LIST_USERS, token, helper.readJsonAsMap(GetListUserParam));
        Assert.assertEquals(200, response.statusCode());
        JsonNode body = helper.readFileAsJson(response.getBody().asString(), false);
        arrayData = (ArrayNode) body.get("data");
    }

    @And("I call API to get a random user")
    public void iGetAUserRandom() {
        userID = arrayData.get(helper.randomInt(arrayData.size())).get("id").asInt();
        response = baseAPI.getAPI(API_URL + APIPath.LIST_USERS + "/" + userID, token);
        Assert.assertEquals(200, response.statusCode());
    }

    @And("I call API to update the user's name as {string} and job as {string}")
    public void iCallAPIUpdateNameUserIsAndJobIs(String name, String job) {
        ObjectNode body = helper.readFileAsJson(UpdateUserBody, true);
        body.put("name", name);
        body.put("job", job);
        response = baseAPI.putAPI(API_URL + APIPath.LIST_USERS + "/" + userID, token, body);
        Assert.assertEquals(201, response.statusCode());
        JsonNode bodyResponse = helper.readFileAsJson(response.getBody().asString(), false);
        Assert.assertEquals(bodyResponse.get("name").asText(), name);
        Assert.assertEquals(bodyResponse.get("job").asText(), job);
    }


    @And("I call API to login into the user with user {string} and password {string}")
    public void iCallAPILoginSuccessfulWithUserAndPassword(String user, String password) {
        ObjectNode body = helper.readFileAsJson(LoginBody, true);
        body.put("email", user);
        body.put("password", password);
        response = baseAPI.postAPI(API_URL, APIPath.LOGIN, body);
    }

    @Then("The API should return status {int} and error {string}")
    public void theAPIShouldReturnStatusStatusAndError(int statusCode, String error) {
        Assert.assertEquals("Status code incorrect", statusCode, response.getStatusCode());
        JsonNode bodyResponse = helper.readFileAsJson(response.getBody().asString(), false);
        if (!error.isEmpty()) {
            Assert.assertEquals(bodyResponse.get("error").asText(), error);
        }
    }

    @When("I call API to get list of users with page {string}")
    public void iCallAPIGetListUserWithPage(String page) {
        ObjectNode body = helper.readFileAsJson(GetListUserParam, true);
        body.put("page", page);
        response = baseAPI.getAPI(API_URL + APIPath.LIST_USERS+"checkPath", token, helper.readJsonAsMap(body.toString(), false));
    }

    @Then("^API should return status ([^\"]*) and have ([^\"]*) user$")
    public void apiShouldReturnHaveQuantityUserUser(int status, int quantity) {
        Assert.assertEquals(status, response.statusCode());
        JsonNode body = helper.readFileAsJson(response.getBody().asString(), false);
        arrayData = (ArrayNode) body.get("data");
        Assert.assertEquals(arrayData.size(), quantity);
    }

    @When("I call API to update the {string} user with {string} and {string}")
    public void iCallAPIToUpdateTheUserWithAnd(String numOfUser, String name, String job) {
        ObjectNode body = helper.readFileAsJson(UpdateUserBody, true);
        body.put("name", name);
        body.put("job", job);
        response = baseAPI.putAPI(API_URL + APIPath.LIST_USERS + "/" + numOfUser, token, helper.readJsonAsMap(body.toString(), false));
        Assert.assertEquals(201, response.statusCode());
        JsonNode bodyResponse = helper.readFileAsJson(response.getBody().asString(), false);
        Assert.assertEquals(bodyResponse.get("name").asText(), name);
        Assert.assertEquals(bodyResponse.get("job").asText(), job);
    }
}
