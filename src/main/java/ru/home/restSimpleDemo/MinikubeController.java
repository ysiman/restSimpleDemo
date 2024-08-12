package ru.home.restSimpleDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.restSimpleDemo.Errors.DemoException;
import ru.home.restSimpleDemo.Integration.minikube.MinikubeIntegrationService;
import ru.home.restSimpleDemo.dto.MinikubeRq;
import ru.home.restSimpleDemo.dto.MinikubeRs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;

import static ru.home.restSimpleDemo.util.LoggingMDC.addRqUidToMdc;

@RestController
@Slf4j
public class MinikubeController {

//    private static final Logger logger = LogManager.getLogger("Vehicle");
    private final MinikubeIntegrationService minikubeIntegrationService;

    public MinikubeController(MinikubeIntegrationService minikubeIntegrationService) {
        this.minikubeIntegrationService = minikubeIntegrationService;
    }

    @RequestMapping( "/demo")
    public String demo() {

        addRqUidToMdc("777");
//        log.info("hello from demo!");
        log.info("hello from demo_info!");
        log.debug("hello from demo_debug!");
        System.out.println("demo!");
        return "hello from demo!!";
    }

    @RequestMapping( "/demo2")
    public String demo2(@RequestHeader(value = "rqUid", required = true) String rqUid) {

        addRqUidToMdc(rqUid);
//        log.info("hello from demo!");
        log.info("hello from demo_info!");
        log.debug("hello from demo_debug!");
        System.out.println("demo!");
        return "hello from demo!!";
    }

    @RequestMapping( "/demo3")
    public String demoMdc() {
        System.out.println("run into demo3");
        log.info("hello from demo_info!");
        log.debug("hello from demo_debug!");
        System.out.println("demo!");
        return "hello from demo!!";
    }

    @RequestMapping("/minikubedemo")
    public String sendRequestToMinikube() {
        MinikubeRq request = new MinikubeRq("uidDemo123");
        MinikubeRs response = minikubeIntegrationService.getInfoFromMinikube(request);
//        log.info("minikubedemo run");
        return "Minikube response: " + response.getMessage();
    }

    @PostMapping("/postdemo")
    public String  postdemo() {
        System.out.println("sdsdsdsd");
        return "sdsdsdsd";
    }

}
