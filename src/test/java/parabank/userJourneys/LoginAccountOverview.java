package parabank.userJourneys;

import static io.gatling.javaapi.core.CoreDsl.*;

import static io.gatling.javaapi.http.HttpDsl.*;
import io.gatling.javaapi.core.*;

import parabank.pageObjects.ActiveUserPages;
import parabank.pageObjects.NewUserRegPages;
import parabank.utils.Pauses;

public class LoginAccountOverview {
                public static final ChainBuilder startSession = exec(flushCookieJar())
                        .exec(session -> session.set("customerLoggedIn", false));

                public static final ChainBuilder viewAccountBalance = exec(startSession)
                                .exec(NewUserRegPages.homePage,
                                                pause(Pauses.Pause_1s),
                                                ActiveUserPages.login,
                                                pause(Pauses.Pause_500ms),
                                                ActiveUserPages.getCustomerId,
                                                pause(Pauses.Pause_500ms),
                                                ActiveUserPages.getAccountNumber,
                                                pause(Pauses.Pause_500ms),
                                                ActiveUserPages.getAccountOverview,
                                                pause(Pauses.Pause_2s),
                                                ActiveUserPages.logout);
}
