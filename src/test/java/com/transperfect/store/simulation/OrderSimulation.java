package com.transperfect.store.simulation;

import com.transperfect.store.TransPerfectStoreApplication;
import com.transperfect.store.consts.ApiPath;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import org.springframework.boot.SpringApplication;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class OrderSimulation extends Simulation {

    @Override
    public void before() {
        SpringApplication springApp = new SpringApplication(TransPerfectStoreApplication.class);
        springApp.setAdditionalProfiles("test");
        springApp.run();
        springApp.setRegisterShutdownHook(true);
    }

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:8088")
                    .acceptHeader("application/json")
                    .acceptLanguageHeader("en-US,en;q=0.5")
                    .acceptEncodingHeader("gzip, deflate")
                    .userAgentHeader(
                            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
                    );

    private ScenarioBuilder updatedOrder = scenario("Update order").exec(
            http("Create a new User")
                    .put(ApiPath.ORDERS + ApiPath.ORDER_STATUS.replace("{orderId}", "2")).header("content-type","application/json")
                    .asJson()
                    .body(StringBody("{\"status\": \"DELIVERED\"}")).asJson()
                    .check(status().is(200)));

    {
        int usersCount = 100;
        setUp(updatedOrder.injectOpen(atOnceUsers(usersCount))).protocols(httpProtocol);
    }
}
