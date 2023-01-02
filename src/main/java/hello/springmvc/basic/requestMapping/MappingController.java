package hello.springmvc.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic")
    public String hello(){
        log.info("hellobasic");
        return "ok";
    }
    @RequestMapping(value = "/get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping("/get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("userId={}", userId);
        return "HO";
    }

    @GetMapping("/mapping/{userId}/orders/{orderId}")
    public String mappingMultiPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("userId={}", userId);
        log.info("orderId={}", orderId);
        return "HO";
    }

    /**
     * consume은 컨트롤러 입장에서 생각. Content-Type이 application/json이어야만 호출 가능
     * @return
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume(){
        log.info("mappingConsume");
        return "ok";
    }

    @PostMapping(value = "/mapping-produces", produces = MediaType.APPLICATION_JSON_VALUE)
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }
}
