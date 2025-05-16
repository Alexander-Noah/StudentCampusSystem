package com.hniu.fgg.base;

import com.hniu.fgg.vo.Hammer;
import com.hniu.fgg.vo.Scissors;
import com.hniu.fgg.vo.Cloth;
public abstract class Player implements FingerPlay {
    protected String nickName;
    protected int winCount;

    public Player(String nickName) {
        this.nickName = nickName;
        this.winCount = 0;
    }

    public String getNickName() {
        return nickName;
    }

    public int getWinCount() {
        return winCount;
    }

    public void incrementWinCount() {
        winCount++;
    }

    protected FingerType createFinger(int id) {
        switch (id) {
            case 1:
                return new Hammer();
            case 2:
                return new Scissors();
            case 3:
                return new Cloth();
            default:
                throw new IllegalArgumentException("无效的出拳编号");
        }
    }
}