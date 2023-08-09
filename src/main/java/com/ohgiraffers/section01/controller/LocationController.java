package com.ohgiraffers.section01.controller;

import com.ohgiraffers.section01.common.SearchCriteria;
import com.ohgiraffers.section01.model.service.LocationService;

import java.util.Scanner;

public class LocationController {
    public static void subLocation() {

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("======== 조회하기 ========");
            System.out.println("1. 지역별로 리스트 보기");
            System.out.println("2. 랜덤으로 추천받기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : ifSubMenu(); break;
                case 9 :
                    System.out.println("프로그램을 종료합니다. "); break;
            }
        }while (true);
    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        LocationService locationService = new LocationService();

        do{
            System.out.println("======== 지역별로 리스트 보기 ========");
            System.out.println("1. 메뉴 이름 혹은 지역별로 검색하여 장소 보여주기");
            System.out.println("9. 이전메뉴로");
            System.out.print("번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : locationService.searchLocation(inputSearchCriteria()); break;
                case 9 : return;
            }
        } while (true);
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);

        System.out.print("검색 기준을 입력해주세요 (name or category) : ");
        String condition = sc.nextLine();
        System.out.print("검색어를 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }


}
