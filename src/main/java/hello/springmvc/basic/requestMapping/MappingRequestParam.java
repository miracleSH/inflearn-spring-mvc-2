package hello.springmvc.basic.requestMapping;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mapping/param")
@RestController
@Slf4j
public class MappingRequestParam {

    @GetMapping("/v1")
    public String modelAttributeV1(@RequestParam String username, @RequestParam int age){
        HelloData helloData = new HelloData(username, age);
        log.info("username={}", helloData.getUsername());
        log.info("age={}", helloData.getAge());
        log.info("hellodata={}", helloData);
        return "ok";
    }

    @GetMapping("v2")
    public String modelAttributeV2(@ModelAttribute HelloData helloData){
        log.info("username={}", helloData.getUsername());
        log.info("age={}", helloData.getAge());
        log.info("hellodata={}", helloData);
        return "ok";
    }

    @GetMapping("v3")
    public String modelAttributeV3(HelloData helloData){
        log.info("username={}", helloData.getUsername());
        log.info("age={}", helloData.getAge());
        log.info("hellodata={}", helloData);
        return "ok";
    }
}
