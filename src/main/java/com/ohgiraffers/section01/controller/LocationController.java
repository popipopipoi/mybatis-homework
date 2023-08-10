package com.ohgiraffers.section01.controller;

import com.ohgiraffers.section01.model.dto.LocationDTO;
import com.ohgiraffers.section01.model.service.LocationService;
import com.ohgiraffers.section01.view.PrintResult;

import java.util.List;
import java.util.Map;

public class LocationController {

    private final LocationService locationService;
    private final PrintResult printResult;

    public LocationController() {
        locationService = new LocationService();
        printResult = new PrintResult();
    }
    public void selectAllLocation() {

        List<LocationDTO> locationList = locationService.selectAllLocation();

        if(locationList != null) {
            printResult.printLocationList(locationList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void registLocation(Map<String, String> parameter) {

        String name = parameter.get("name");
        String menu = parameter.get("menu");
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
        String subway = parameter.get("subway");

        LocationDTO location = new LocationDTO();
        location.setName(name);
        location.setMenu(menu);
        location.setCategoryCode(categoryCode);
        location.setSubway(subway);

        if(locationService.registLocation(location)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyLocation(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        String menu = parameter.get("menu");
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
        String subway = parameter.get("subway");

        LocationDTO location = new LocationDTO();
        location.setCode(code);
        location.setName(name);
        location.setMenu(menu);
        location.setCategoryCode(categoryCode);
        location.setSubway(subway);

        if(locationService.modifyLocation(location)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteLocation(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        LocationDTO location = new LocationDTO();
        location.setCode(code);

        if(locationService.deleteLocation(location)){
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
