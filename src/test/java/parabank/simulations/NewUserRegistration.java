package parabank.simulations;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;
import parabank.pageObjects.ActiveUserPages;
import parabank.pageObjects.NewUserRegPages;
import parabank.scenarios.NewUserRegScenarios;
import parabank.utils.CreateProtocol;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class NewUserRegistration extends Simulation {

  {
    setUp(NewUserRegScenarios.defaultNewUserReg
        .injectOpen(atOnceUsers(1))).protocols(CreateProtocol.HTTP_PROTOCOL);
  }
}
