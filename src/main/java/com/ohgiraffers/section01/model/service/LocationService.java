package com.ohgiraffers.section01.model.service;

import com.ohgiraffers.section01.common.SearchCriteria;
import com.ohgiraffers.section01.model.dto.LocationDTO;
import com.ohgiraffers.section01.model.mapper.DynamicSqlMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.common.Template.getSqlSession;

public class LocationService {
    private DynamicSqlMapper mapper;
    public void searchLocation(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<LocationDTO> locationList = mapper.searchLocation(searchCriteria);

        if(locationList != null && locationList.size() > 0 ) {
            locationList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다. ");
        }
        sqlSession.close();
    }
}
