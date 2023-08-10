package com.ohgiraffers.section01.model.mapper;

import com.ohgiraffers.section01.common.SearchCriteria;
import com.ohgiraffers.section01.model.dto.LocationDTO;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {
    List<LocationDTO> searchLocation(SearchCriteria searchCriteria);

    List<LocationDTO> searchLocationByRandomLocationCode(Map<String, List<Integer>> criteria);
}
