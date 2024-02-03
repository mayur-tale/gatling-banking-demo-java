package parabank.utils;

import static io.gatling.javaapi.core.CoreDsl.csv;

import io.gatling.javaapi.core.FeederBuilder;

public final class Feeders {
    public static final FeederBuilder<String> amountFeeder = csv("parabank/testdata/transferAmounts.csv").circular();
    public static final FeederBuilder<String> loginsFeeder = csv("parabank/testdata/logins.csv").random();
    public static final String BASE_URL = "https://parabank.parasoft.com";
}
