package com.ohgiraffers.section01.controller;

import com.ohgiraffers.section01.common.SearchCriteria;
import com.ohgiraffers.section01.model.dto.LocationDTO;
import com.ohgiraffers.section01.model.service.LocationService;
import com.ohgiraffers.section01.view.PrintResult;

import java.util.*;

public class LocationSelectController {


    public static void subLocation() {

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("======== 조회하기 ========");
            System.out.println("1. 지역별로 리스트 보기");
            System.out.println("2. 랜덤으로 추천받기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴를 선택하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : ifSubMenu(); break;
                case 2 : randomLocation(); break;
                case 9 :
                    System.out.println("프로그램을 종료합니다. "); return;
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
        System.out.print("검색어를 입력해주세요(노원구, 강북구, 중구, 동대문구, 종로구, 용산구, 강남구, 마포구) : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static void randomLocation() {

        Scanner sc = new Scanner(System.in);
        LocationService locationService = new LocationService();


        do{
            System.out.println("1. 랜덤한 장소 5개 추천받기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : locationService.searchLocationByRandomLocationCode(crateRandomMenuCodeList());
                case 9 : return;
            }
        } while (true);
    }

    private static List<Integer> crateRandomMenuCodeList() {

        Set<Integer> set = new HashSet<>();
        while (set.size() < 5 ) {
            int temp = ((int) (Math.random() * 21)) + 1;
            set.add(temp);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }


}
