package parabank.simulations;



import io.gatling.javaapi.core.*;

import parabank.scenarios.NewUserRegScenarios;
import parabank.utils.CreateProtocol;

import static io.gatling.javaapi.core.CoreDsl.*;


public class NewUserRegistration extends Simulation {

  {
    setUp(NewUserRegScenarios.defaultNewUserReg
        .injectOpen(atOnceUsers(1))).protocols(CreateProtocol.HTTP_PROTOCOL);
  }
}
