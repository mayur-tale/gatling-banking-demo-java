package parabank.pageObjects;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;
import parabank.utils.Feeders;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public final class ActiveUserPages {

    
    public static final ChainBuilder login = feed(Feeders.loginsFeeder)
                    .exec(session -> {
                            System.out.println("customerLoggedIn value is : "
                                            + session.get("customerLoggedIn"));
                            return session;
                    })
                    .exec(
                                    http("Login")
                                                    .post(Feeders.BASE_URL+"/parabank/login.htm")
                                                    .formParam("username", "#{username}")
                                                    .formParam("password", "#{password}"))
                    .exec(session -> session.set("customerLoggedIn", true))
                    .exec(session -> {
                            System.out.println("customerLoggedIn value is : "
                                            + session.get("customerLoggedIn"));
                            return session;
                    });

    public static final ChainBuilder getAccountOverview = exec(
                    http("Get Account Overview")
                                    .get(Feeders.BASE_URL+"/parabank/overview.htm")
                                    .check(substring("Accounts Overview")));

    public static final ChainBuilder getCustomerId = feed(Feeders.loginsFeeder)
                    .exec(
                                    http("Get Customer ID")
                                                    .get("https://parabank.parasoft.com/parabank/services/bank/login/#{username}/#{password}")
                                                    .check(xpath("customer/id").saveAs("customerId")));

    public static final ChainBuilder getAccountNumber = exec(
                    http("Get Account Number")
                                    .get("https://parabank.parasoft.com/parabank/services/bank/customers/#{customerId}/accounts")
                                    .check(xpath("accounts/account/id").saveAs("accNumber")));

    public static final ChainBuilder goToTransfersPage = exec(
                    http("Go To Transfers Page")
                                    .get(Feeders.BASE_URL+"/parabank/transfer.htm")
                                    .check(substring("From account")));

    public static final ChainBuilder transferAmountBetweenAccounts = feed(Feeders.amountFeeder)
                    .feed(Feeders.loginsFeeder)
                    .exec(
                                    http("Transfer given amount between given accounts")// #{accNumber}
                                                    .post(Feeders.BASE_URL+"/parabank/services_proxy/bank/transfer?fromAccountId=#{accNumber}&toAccountId=#{accNumber}&amount=#{transferAmounts}")
                                                    .check(substring("Successfully transferred")));

    public static final ChainBuilder logout = exec(
                    http("Log Out")
                                    .get(Feeders.BASE_URL+"/parabank/logout.htm")
                                    .check(substring("Customer Login")));

    public static final ChainBuilder goToBillPay = exec(
                    http("Go To Bill Pay Page")
                                    .get(Feeders.BASE_URL+"/parabank/billpay.htm")
                                    .check(substring("Enter payee information")));

}
