package parabank.simulations;

import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import io.gatling.javaapi.core.*;
import java.time.Duration;

import parabank.scenarios.BillPayScenarios;
import parabank.scenarios.MakeTransferScenarios;
import parabank.utils.CreateProtocol;

public class ParallelBillPayAndMakeTransfer extends Simulation {
    {
        setUp(
                BillPayScenarios.defaultBillPay
                        .injectOpen(rampUsers(3).during(Duration.ofSeconds(15))),
                MakeTransferScenarios.defaultMakeTransfer
                        .injectOpen(rampUsers(3).during(Duration.ofSeconds(15)))
                        .protocols((CreateProtocol.HTTP_PROTOCOL)));
    }
}
