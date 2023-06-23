package com.example.onlinerent.service;

import com.example.onlinerent.config.Constants;
import com.example.onlinerent.mapper.ResidenceMapper;
import com.example.onlinerent.model.Residence;
import com.example.onlinerent.model.RespBean;
import com.example.onlinerent.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResidenceService {

    @Autowired
    ResidenceMapper residenceMapper;

    public RespBean addResidence(Residence residence) {
        residence.setCreateTime(new Date());
        residence.setDeleteFlag(Constants.UN_DELETE_FLAG);
        int result = residenceMapper.addResidence(residence);
        return result == 1 ? RespBean.ok("添加成功") : RespBean.error("添加失败");
    }

    public RespPageBean getResidenceByPage(Integer page, Integer size, String name, String province, String city, String area) {
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal(residenceMapper.getTotal(name,province,city,area));
        respPageBean.setData(residenceMapper.getResidenceByPage((page-1)*size,size,name,province,city,area));
        return respPageBean;
    }

    public RespBean deleteResidenceById(Integer rid) {
        //根据 id 查询小区，如果查询不到，说明这个小区已经被删除了
        Residence r = residenceMapper.getResidenceById(rid);
        if (r == null) {
            //说明这个小区已经被删除了
            return RespBean.error("小区不存在，删除失败");
        }
        int result = residenceMapper.deleteResidenceById(rid);
        return result == 1 ? RespBean.ok("删除成功") : RespBean.error("删除失败");
    }

    public RespBean updateResidence(Residence residence) {
        residence.setUpdateTime(new Date());
        int result = residenceMapper.updateResidence(residence);
        return result==1?RespBean.ok("更新成功"):RespBean.error("更新失败");
    }

    public RespBean getResidenceById(Integer rid){
        Residence r = residenceMapper.getResidenceById(rid);
        if (r == null) {
            return RespBean.error("小区不存在");
        }
        return RespBean.ok("查询成功",r);
    }

    public void addResidences(List<Residence> residences) {
        residenceMapper.addResidences(residences);
    }
}
