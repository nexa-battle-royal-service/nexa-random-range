package com.jad.randomrange.controller;

import com.jad.randomrange.service.RandomRangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomRangeController {
    private final RandomRangeService randomRangeService;

    public RandomRangeController(final RandomRangeService randomRangeService) {
        this.randomRangeService = randomRangeService;
    }

    @GetMapping("/random-range")
    public Integer getRandomRange(@RequestParam(value = "min", defaultValue = "0") Integer min,
                                  @RequestParam(value = "max", defaultValue = "100") Integer max) {

        return this.randomRangeService.getRandomInRange(min, max);
    }
}
