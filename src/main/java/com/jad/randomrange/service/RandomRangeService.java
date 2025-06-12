package com.jad.randomrange.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomRangeService {
    final static private Random RANDOM = new Random();

    public int getRandomInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Min must be less than Max");
        }
        return RandomRangeService.RANDOM.nextInt((max - min) + 1) + min;
    }
}
