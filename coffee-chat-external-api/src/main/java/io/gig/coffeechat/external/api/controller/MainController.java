package io.gig.coffeechat.external.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : JAKE
 * @date : 2022/12/10
 */
@RestController
public class MainController {

    @GetMapping("health-check")
    public String healthCheck() {
        return "Status is ok";
    }

}
