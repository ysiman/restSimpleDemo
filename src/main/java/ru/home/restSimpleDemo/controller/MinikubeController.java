package ru.home.restSimpleDemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.restSimpleDemo.Service.MiniKubeService;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.exception.MinikubeServiceException;

import static ru.home.restSimpleDemo.util.LoggingMDC.addRqUidToMdc;

@RestController
@Slf4j
public class MinikubeController {

//    private static final Logger logger = LogManager.getLogger("Vehicle");
    private final MiniKubeService miniKubeService;

    public MinikubeController(MiniKubeService miniKubeService) {
        this.miniKubeService = miniKubeService;
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

//    @RequestMapping("/minikubedemo")
//    public String sendRequestToMinikube() {
//        MinikubeRq request = new MinikubeRq("uidDemo123");
//        MinikubeRs response = miniKubeService.getInfoFromMinikube(request);
////        log.info("minikubedemo run");
//        return "Minikube response: " + response.getMessage();
//    }

    @PostMapping(path ="/postdemo",  consumes = "application/json")
    public String  postdemo(@RequestBody GetCashierRq request) {
        System.out.println("sdsdsdsd");
        return "sdsdsdsd";
    }

    @GetMapping("/err")
    public ResponseEntity<String> err() throws MinikubeServiceException {
        return new ResponseEntity<>(miniKubeService.getErrFromMinikube(), HttpStatus.OK);
    }

    @GetMapping("/timeout")
    public ResponseEntity<String> timout()  {

        try {
            return new ResponseEntity<>(miniKubeService.getTimeOutFromMinikube(), HttpStatus.OK);
        } catch (MinikubeServiceException e) {
            return new ResponseEntity<>("Defaul rs", HttpStatus.OK);
        }
    }

}
