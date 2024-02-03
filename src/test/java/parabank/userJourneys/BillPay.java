package parabank.userJourneys;

import io.gatling.javaapi.core.*;
import static io.gatling.javaapi.core.CoreDsl.*;

import parabank.pageObjects.ActiveUserPages;
import parabank.pageObjects.BillPayPages;
import parabank.pageObjects.NewUserRegPages;
import parabank.utils.Pauses;

public class BillPay {
    public static final ChainBuilder completeBillPay = exec(LoginAccountOverview.startSession)
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
                    BillPayPages.goToBillPay,
                    pause(Pauses.Pause_2s),
                    BillPayPages.submitBillPay,
                    pause(Pauses.Pause_2s),
                    ActiveUserPages.logout);
}
