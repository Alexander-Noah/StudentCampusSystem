package com.hniu.fgg.vo;

import com.hniu.fgg.base.FingerType;
import com.hniu.fgg.base.Player;

import java.util.Random;

public class Computer extends Player {
    public Computer() {
        super("电脑");
    }

    @Override
    public FingerType play() {
        Random random = new Random();
        int id = random.nextInt(3) + 1;
        return createFinger(id);
    }
}