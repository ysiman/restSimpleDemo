package ru.home.restSimpleDemo;

import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping("/demo")
    public String demo() {

        addRqUidToMdc("#mdcTest");
//        log.info("hello from demo!");
        log.info("hello from demo_info!");
        log.debug("hello from demo_debug!");
        return "hello from demo!!";
    }

    @RequestMapping("/minikubedemo")
    public String sendRequestToMinikube() {
        MinikubeRq request = new MinikubeRq("uidDemo123");
        MinikubeRs response = minikubeIntegrationService.getInfoFromMinikube(request);
//        log.info("minikubedemo run");
        return "Minikube response: " + response.getMessage();
    }

}
