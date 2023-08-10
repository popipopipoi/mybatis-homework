package com.ohgiraffers.section01.view;

import com.ohgiraffers.section01.model.dto.LocationDTO;

import java.util.List;

public class PrintResult {

    public void printLocationList(List<LocationDTO> locationList) {locationList.forEach(System.out::println);}
    public void printLocation(LocationDTO location) {
        System.out.print(location);
    }

    public void printErrorMessage(String errorCode){
        String errorMessage = "";
        switch (errorCode){
            case "selectList" : errorMessage = "장소 목록 조회에 실패하였습니다."; break;
            case "insert" : errorMessage = "장소 등록에 실패하였습니다."; break;
            case "update" : errorMessage = "장소 수정에 실패하였습니다."; break;
            case  "delete" : errorMessage = "장소 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }
    public void printSuccessMessage(String successCode){
        String successMessage = "";
        switch (successCode) {
            case "insert" : successMessage = "신규 장소 등록이 완료 되었습니다."; break;
            case "update" : successMessage = "장소 수정이 완료 되었습니다."; break;
            case "delete" : successMessage = "장소 삭제가 완료 되었습니다."; break;

        }
        System.out.println(successMessage);
    }
}
