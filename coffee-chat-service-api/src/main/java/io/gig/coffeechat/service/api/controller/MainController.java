package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.util.InitUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
@RestController
@RequiredArgsConstructor
public class MainController {

    private final InitUtils initUtils;

    @GetMapping("health-check")
    public String healthCheck() {
        return "Status is ok";
    }

    @GetMapping("init-data")
    public String initData() {
        initUtils.initData();
        return "init Data Set OK";
    }
}
