package com.ohgiraffers.section01.model.mapper;

import com.ohgiraffers.section01.common.SearchCriteria;
import com.ohgiraffers.section01.model.dto.LocationDTO;

import java.util.List;

public interface DynamicSqlMapper {
    List<LocationDTO> searchLocation(SearchCriteria searchCriteria);
}
