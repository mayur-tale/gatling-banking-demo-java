package parabank.pageObjects;



import io.gatling.javaapi.core.*;

import parabank.utils.Feeders;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;


public final class BillPayPages {

    public static final ChainBuilder goToBillPay = exec(
        http("Go To Bill Pay Page")
            .get(Feeders.BASE_URL+"/parabank/billpay.htm")
            .check(substring("Enter payee information")));

    public static final ChainBuilder submitBillPay = feed(Feeders.amountFeeder)
        .exec(
            http("Submit BillPay Request")
                .post(Feeders.BASE_URL+"/parabank/services_proxy/bank/billpay?accountId=#{accNumber}&amount=21")
                .header("accept", "application/xml, text/xml, application/json")
                
                .body(RawFileBody("parabank/postrequestbodies/BillPayRequestBody.json")).asJson()
                );
  }
