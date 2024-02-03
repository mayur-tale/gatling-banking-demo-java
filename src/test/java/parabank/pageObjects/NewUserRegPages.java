package parabank.pageObjects;


import java.util.*;

import io.gatling.javaapi.core.*;

import parabank.utils.Feeders;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;


public final class NewUserRegPages {

    public static final ChainBuilder homePage = exec(
        http("Load Home Page")
          .get(Feeders.BASE_URL+"/parabank/index.htm")
          .check(css("[value=\"Log In\"]").exists()));

    public static final ChainBuilder registrationPage = exec(
        http("Load Registration Page")
          .get(Feeders.BASE_URL+"/parabank/register.htm")
          .check(substring("Signing up is easy!"))
    );

    private static final Random random = new Random();
    private static final int randomInt = random.nextInt(1000);

    private static final String randomUserName = "testmt"+String.valueOf(randomInt) ; 
    public static final ChainBuilder submitRegistrationReq = exec(
        http("Submit Registration Request")
          .post(Feeders.BASE_URL+"/parabank/register.htm")
          .formParam("customer.firstName", "test")
          .formParam("customer.lastName", "doe")
          .formParam("customer.address.street", "129 test road")
          .formParam("customer.address.city", "doetest")
          .formParam("customer.address.state", "south yorkshire")
          .formParam("customer.address.zipCode", "xbf447")
          .formParam("customer.phoneNumber", "")
          .formParam("customer.ssn", "55674329")
          .formParam("customer.username", randomUserName)
          .formParam("customer.password", "testmt")
          .formParam("repeatedPassword", "testmt")
          
          .check(substring("Your account was created successfully. You are now logged in."))
          )
        .exec(session -> {
          System.out.println("User created - " + randomUserName);
          return session;
          }
  );

    // private static final ChainBuilder logoutPage = exec(
    //     http("Logout")
    //       .get("/parabank/logout.htm")
    //       .check(substring("Latest News"))
    // );
  }
