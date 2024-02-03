package parabank.scenarios;

import io.gatling.javaapi.core.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.CoreDsl.pause;


import parabank.pageObjects.ActiveUserPages;
import parabank.pageObjects.NewUserRegPages;
import parabank.utils.Pauses;

public class NewUserRegScenarios {
    public static final ScenarioBuilder defaultNewUserReg = scenario("NewUserRegistration")
      .exec(NewUserRegPages.homePage,
          pause(Pauses.Pause_2s),
          NewUserRegPages.registrationPage,
          pause(Pauses.Pause_2s),
          NewUserRegPages.submitRegistrationReq,
          pause(Pauses.Pause_2s),
          ActiveUserPages.logout
      );

}
