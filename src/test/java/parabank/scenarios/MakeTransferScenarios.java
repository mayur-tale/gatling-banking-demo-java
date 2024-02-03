package parabank.scenarios;

import io.gatling.javaapi.core.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.scenario;



import parabank.userJourneys.LoginAccountOverview;
import parabank.userJourneys.Transfer;

public class MakeTransferScenarios {
    public static final ScenarioBuilder defaultMakeTransfer = scenario("Default Make Transfer Load Test")
            // .during(Duration.ofSeconds(60))
            // .on(
                    .randomSwitch()
                            .on(
                                    new Choice.WithWeight(86.0, exec(
                                            LoginAccountOverview.viewAccountBalance)),
                                    new Choice.WithWeight(14.0, exec(
                                            Transfer.completeTransfer)))
                                            // )
                                            ;
}
