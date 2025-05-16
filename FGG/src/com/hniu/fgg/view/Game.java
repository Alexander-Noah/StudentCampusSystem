package com.hniu.fgg.view;

import com.hniu.fgg.base.Config;
import com.hniu.fgg.base.FingerType;
import com.hniu.fgg.vo.Computer;
import com.hniu.fgg.vo.Customer;

public class Game {
    private Computer computer;
    private Customer customer;

    public void init() {
        computer = new Computer();
        System.out.print("请输入客户昵称:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String name = scanner.nextLine();
        customer = new Customer(name);
        System.out.println("==游戏开始==");
    }

    public void startGame() {
        int currentRound = 1;
        while (currentRound <= Config.MAX_ROUNDS) {
            System.out.println("--- 第" + currentRound + "局 ---");
            FingerType computerFinger = computer.play();
            FingerType customerFinger = customer.play();

            System.out.print("电脑出拳为: ");
            computerFinger.show();
            System.out.println();
            System.out.print(customer.getNickName() + "出拳为: ");
            customerFinger.show();
            System.out.println();

            int result = determineWinner(computerFinger, customerFinger);
            if (result == 1) {
                computer.incrementWinCount();
                System.out.println("第" + currentRound + "局 电脑获胜");
            } else if (result == -1) {
                customer.incrementWinCount();
                System.out.println("第" + currentRound + "局 " + customer.getNickName() + "获胜");
            } else {
                System.out.println("第" + currentRound + "局 平局");
            }

            if (computer.getWinCount() >= Config.WIN_THRESHOLD || customer.getWinCount() >= Config.WIN_THRESHOLD) {
                break;
            }
            currentRound++;
        }

        System.out.println("===游戏结束===");
        if (computer.getWinCount() > customer.getWinCount()) {
            System.out.println("五局三胜，最终电脑获胜");
        } else if (customer.getWinCount() > computer.getWinCount()) {
            System.out.println("五局三胜，最终" + customer.getNickName() + "获胜");
        } else {
            System.out.println("平局！");
        }
    }

    private int determineWinner(FingerType computerFinger, FingerType customerFinger) {
        int cId = computerFinger.getId();
        int cuId = customerFinger.getId();

        if (cId == cuId) {
            return 0;
        }

        if ((cId == 1 && cuId == 2) || (cId == 2 && cuId == 3) || (cId == 3 && cuId == 1)) {
            return 1; // 电脑赢
        } else {
            return -1; // 客户赢
        }
    }
}