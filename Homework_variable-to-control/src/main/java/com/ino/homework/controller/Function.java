package com.ino.homework.controller;

import java.util.Scanner;

public class Function {
    public void calculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 정수 : ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.print("연산자(+, -, x, /) : ");
        char mark = sc.nextLine().charAt(0);

        switch (mark) {
            case '+':
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case '-':
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case '*':
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println(num1 + " / " + num2 + " = " + 0);
                } else {
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                }
                break;
            case '%':
                System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
                break;
        }
    }

    public void totalCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 정수 : ");
        int num2 = sc.nextInt();
        int sum = 0;
        for (int i = Math.min(num1, num2); i <= Math.max(num1, num2); i++) {
            sum += i;
        }
        System.out.printf("%d부터 %d까지 정수들의 합 : %d\n", num1, num2, sum);
    }

    public void printProfile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("나이 : ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.print("성별 : ");
        String gender = sc.nextLine();
        System.out.print("성격 : ");
        String ps = sc.nextLine();
        System.out.print("이름 : " + name);
        System.out.print("나이 : " + num1);
        System.out.print("성별 : " + gender);
        System.out.print("성격 : " + ps);
    }

    public void printScore() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름 : ");
        String name = sc.nextLine();
        System.out.println("학년 : ");
        int num1 = sc.nextInt();
        System.out.println("반 : ");
        int num2 = sc.nextInt();
        System.out.println("번 : ");
        int num3 = sc.nextInt();
        sc.nextLine();
        System.out.println("성별 : ");
        char gender = sc.nextLine().charAt(0);
        System.out.println("성적 : ");
        double num4 = sc.nextDouble();
        int div = (int)num4 % 10;
        char c;
        switch (div) {
            case 9, 10: c = 'A';
            case 8: c = 'B';
            case 7: c = 'C';
            case 6: c = 'D';
            default: c = 'F';
        }

        System.out.printf("%d학년 %d반 %d번 %c학생 %s의 점수는 %.2f점이고 %c학점입니다.", num1, num2, num3, gender, name, num4, c);
    }

    public void printStarNumber() {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("정수: ");
            int num1 = sc.nextInt();
            if (num1 < 0 ) {
                System.out.println("양수가 아닙니다.");
                continue;
            }
            for(int i=0;i<num1;i++) {
                for(int j=0;j<num1;j++) {
                    if (i == j) {
                        System.out.println(i+1);
                        break;
                    }
                    System.out.print("*");
                }
            }
            break;
        }
    }

    public void sumRandom() {
        int randInt = (int)(Math.random() * 100 + 1);
        int sum = 0;
        for(int i=1; i<randInt;i++) {
            sum += i;
        }
        System.out.printf("1부터 %d까지의 합 : %d", randInt, sum);
    }

    public void exceptGugu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수: ");
        int num1 = sc.nextInt();
        for(int i=1; i<=9; i++) {
            System.out.println(num1 + " * " + i + " = " + num1*i);
        }
    }

    public void diceGame() {

        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        boolean keepPlaying = false;
        while(!keepPlaying) {
            int randInt = (int)(Math.random() * 12 + 2);
            System.out.println("주사위 두 개의 합을 맞춰보세요(2~12입력) : ");
            while (!flag) {
                int num1 = sc.nextInt();
                if (num1 == randInt) {
                    flag = true;
                    sc.nextLine();
                    System.out.println("정답입니다");
                    System.out.println("계속 하시겠습니까?(y/n) : ");
                    char c = sc.nextLine().charAt(0);
                    if (c == 'n') {
                        keepPlaying = true;
                    }
                }
            }
        }
    }
}
