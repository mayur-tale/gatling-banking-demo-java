package parabank.simulations;

import java.time.Duration;


import io.gatling.javaapi.core.*;


import static io.gatling.javaapi.core.CoreDsl.*;

import parabank.scenarios.MakeTransferScenarios;

import parabank.utils.CreateProtocol;


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
