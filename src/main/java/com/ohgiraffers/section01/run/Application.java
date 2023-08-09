package com.ohgiraffers.section01.run;

import com.ohgiraffers.section01.controller.LocationController;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LocationController locationController = new LocationController();

        do{
            System.out.println("======== 안주맛집 관리 ========");
            System.out.println("1. 장소 조회");
            System.out.println("2. 신규 장소 추가");
            System.out.println("3. 장소 수정");
            System.out.println("4. 장소 삭제");
            System.out.println("9. 종료하기");
            System.out.print("장소 관리 번호 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : LocationController.subLocation(); break;
                case 9 : return;
            }
        } while (true);
    }


}
