package com.example.onlinerent.mapper;

import com.example.onlinerent.model.Residence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author HelloWorld
* @description 针对表【residence(小区)】的数据库操作Mapper
* @createDate 2023-06-20 15:22:43
* @Entity com.example.onlinerent.model.Residence
*/
@Mapper
public interface ResidenceMapper {
    int addResidence(Residence residence);
    Integer getTotal(@Param("name") String name, @Param("province") String province, @Param("city") String city, @Param("area") String area);
    List<Residence> getResidenceByPage(@Param("offset") int offset,
                                       @Param("size") Integer size,
                                       @Param("name") String name, @Param("province") String province, @Param("city") String city, @Param("area") String area);
    Residence getResidenceById(Integer rid);
    int deleteResidenceById(Integer rid);

    int updateResidence(Residence residence);

    void addResidences(@Param("residences") List<Residence> residences);
}




