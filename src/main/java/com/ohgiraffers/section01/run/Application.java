package com.ohgiraffers.section01.run;

import com.ohgiraffers.section01.controller.LocationController;
import com.ohgiraffers.section01.controller.LocationSelectController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LocationSelectController locationSelectController = new LocationSelectController();
        LocationController locationController = new LocationController();

        do{
            System.out.println("======== 안주맛집 관리 ========");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 장소 조회");
            System.out.println("3. 신규 장소 추가");
            System.out.println("4. 장소 수정");
            System.out.println("5. 장소 삭제");
            System.out.println("9. 종료하기");
            System.out.print("장소 관리 번호 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : locationController.selectAllLocation(); break;
                case 2 : locationSelectController.subLocation(); break;
                case 3 : locationController.registLocation(inputLocation()); break;
                case 4 : locationController.modifyLocation(inputModifyLocation()); break;
                case 5 : locationController.deleteLocation(inputCode()); break;
                case 9 : return;
            }
        } while (true);
    }


    private static Map<String, String> inputLocation() {

        Scanner sc = new Scanner(System.in);
        System.out.print("장소 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("추천 메뉴를 입력하세요 : ");
        String menu = sc.nextLine();
        System.out.print("카테고리 코드를 입력하세요(1.노원구 2.강북구 3.종로구 4.중구 5.용산구 6.강남구 7.마포구 8.동대문구) : ");
        String categoryCode = sc.nextLine();
        System.out.print("가까운 역을 입력해주세요 : ");
        String subway = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("menu", menu);
        parameter.put("categoryCode", categoryCode);
        parameter.put("subway", subway);

        return parameter;
    }

    private static Map<String, String> inputModifyLocation() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정하고 싶은 장소 코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.print("수정할 장소 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 추천 메뉴를 입력하세요 : ");
        String menu = sc.nextLine();
        System.out.print("수정할 카테고리 코드를 입력하세요(1.노원구 2.강북구 3.종로구 4.중구 5.용산구 6.강남구 7.마포구 8.동대문구) : ");
        String categoryCode = sc.nextLine();
        System.out.print("수정할 가까운 역을 입력해주세요 : ");
        String subway = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("menu", menu);
        parameter.put("categoryCode", categoryCode);
        parameter.put("subway", subway);

        return parameter;

    }
    private static Map<String, String> inputCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }


}
