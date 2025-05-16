package com.hniu.fgg.vo;

import com.hniu.fgg.base.FingerType;
import com.hniu.fgg.base.Player;

import java.util.Scanner;

public class Customer extends Player {
    public Customer(String nickName) {
        super(nickName);
    }

    @Override
    public FingerType play() {
        Scanner scanner = new Scanner(System.in);
        int id;
        do {
            System.out.print("请客户输入出拳的编号: 1:锤子 2:剪刀 3:布\n");
            while (!scanner.hasNextInt()) {
                System.out.println("输入无效，请输入数字！");
                scanner.next();
                System.out.print("请客户输入出拳的编号: 1:锤子 2:剪刀 3:布\n");
            }
            id = scanner.nextInt();
            if (id < 1 || id > 3) {
                System.out.println("输入错误，请输入1-3之间的数字！");
            }
        } while (id < 1 || id > 3);
        return createFinger(id);
    }
}