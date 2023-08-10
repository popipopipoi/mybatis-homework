package com.ohgiraffers.section01.model.service;

import com.ohgiraffers.section01.common.SearchCriteria;
import com.ohgiraffers.section01.model.dto.LocationDTO;
import com.ohgiraffers.section01.model.mapper.DynamicSqlMapper;
import com.ohgiraffers.section01.model.mapper.LocationMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.common.Template.getSqlSession;

public class LocationService {
    private DynamicSqlMapper mapper;
    private LocationMapper locationMapper;

    public List<LocationDTO> selectAllLocation() {

        SqlSession sqlSession = getSqlSession();

        locationMapper = sqlSession.getMapper(LocationMapper.class);
        List<LocationDTO> locationList = locationMapper.selectAllLocation();

        sqlSession.close();

        return locationList;
    }

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

    public void searchLocationByRandomLocationCode(List<Integer> randomLocationCodeList) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> criteria = new HashMap<>();
        criteria.put("randomLocationCodeList", randomLocationCodeList);
        List<LocationDTO> locationList = mapper.searchLocationByRandomLocationCode(criteria);

        if(locationList != null && locationList.size() > 0) {
            locationList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public boolean registLocation(LocationDTO location) {

        SqlSession sqlSession = getSqlSession();
        locationMapper = sqlSession.getMapper(LocationMapper.class);

        int result = locationMapper.insertLocation(location);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public boolean modifyLocation(LocationDTO location) {

        SqlSession sqlSession = getSqlSession();
        locationMapper = sqlSession.getMapper(LocationMapper.class);

        int result = locationMapper.updateLocation(location);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;

    }

    public boolean deleteLocation(LocationDTO location) {

        SqlSession sqlSession = getSqlSession();
        locationMapper = sqlSession.getMapper(LocationMapper.class);

        int result = locationMapper.deleteLocation(location);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
