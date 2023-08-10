package com.ohgiraffers.section01.model.mapper;

import com.ohgiraffers.section01.model.dto.LocationDTO;

import java.util.List;

public interface LocationMapper {
    List<LocationDTO> selectAllLocation();

    int insertLocation(LocationDTO location);

    int updateLocation(LocationDTO location);

    int deleteLocation(LocationDTO location);
}
