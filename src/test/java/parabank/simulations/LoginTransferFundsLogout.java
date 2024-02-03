package parabank.simulations;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

import parabank.pageObjects.ActiveUserPages;
import parabank.pageObjects.BillPayPages;
import parabank.pageObjects.NewUserRegPages;
import parabank.scenarios.BillPayScenarios;
import parabank.scenarios.MakeTransferScenarios;
import parabank.userJourneys.BillPay;
import parabank.userJourneys.LoginAccountOverview;
import parabank.userJourneys.Transfer;
import parabank.utils.CreateProtocol;
import parabank.utils.Pauses;;

public class LoginTransferFundsLogout extends Simulation {

        {
                setUp(MakeTransferScenarios.defaultMakeTransfer.injectOpen(
                                atOnceUsers(3),
                                nothingFor(Duration.ofSeconds(5)),
                                rampUsers(12).during(Duration.ofSeconds(25)),
                                nothingFor(Duration.ofSeconds(10)),
                                constantUsersPerSec(1).during(Duration.ofSeconds(10))))
                                .protocols(CreateProtocol.HTTP_PROTOCOL);
        }

}
