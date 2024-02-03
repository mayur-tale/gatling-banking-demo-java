package parabank.simulations;

import java.time.Duration;
import io.gatling.javaapi.core.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import parabank.scenarios.BillPayScenarios;
import parabank.scenarios.MakeTransferScenarios;
import parabank.utils.CreateProtocol;

public class SequentialBillPayAndMakeTransfer extends Simulation {

    {
        setUp(
                BillPayScenarios.defaultBillPay.injectOpen(rampUsers(3).during(Duration.ofSeconds(15)))
                        .andThen(MakeTransferScenarios.defaultMakeTransfer
                                .injectOpen(rampUsers(3).during(Duration.ofSeconds(15))))
                        .protocols((CreateProtocol.HTTP_PROTOCOL))

        );
    }
}
