package io.gig.coffeechat.service.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
@RestController
public class MainController {

    @GetMapping("health-check")
    public String healthCheck() {
        return "Status is ok";
    }
}
