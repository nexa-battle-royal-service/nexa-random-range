package com.jad.randomrange.controller;

import com.jad.randomrange.service.RandomRangeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomRangeController {
    private final RandomRangeService randomRangeService;

    public RandomRangeController(final RandomRangeService randomRangeService) {
        this.randomRangeService = randomRangeService;
    }

    @GetMapping("/random-range")
    public Integer getRandomRange(@RequestParam(value = "min", defaultValue = "0") Integer min,
                                  @RequestParam(value = "max", defaultValue = "100") Integer max) {
        final int result = this.randomRangeService.getRandomInRange(min, max);
        if (result == -1) throw new BadRangeException();
        return this.randomRangeService.getRandomInRange(min, max);
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Bad min and/or max values")  // 404
    private static class BadRangeException extends RuntimeException {
    }
}
