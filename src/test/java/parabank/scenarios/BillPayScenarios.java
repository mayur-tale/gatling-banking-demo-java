package parabank.scenarios;

import io.gatling.javaapi.core.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.scenario;

import java.time.Duration;

import parabank.userJourneys.BillPay;
import parabank.userJourneys.LoginAccountOverview;

public class BillPayScenarios {
    public static final ScenarioBuilder defaultBillPay = scenario("Default Bill Pay Load Test")
            .during(Duration.ofSeconds(30))
            .on(
                    randomSwitch()
                            .on(
                                    new Choice.WithWeight(75.0, exec(
                                            LoginAccountOverview.viewAccountBalance)),
                                    new Choice.WithWeight(25.0, exec(
                                            BillPay.completeBillPay))));
}
