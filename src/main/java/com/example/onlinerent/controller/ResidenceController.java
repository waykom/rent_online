package com.example.onlinerent.controller;


import com.alibaba.excel.EasyExcel;
import com.example.onlinerent.excel.ResidenceReadListener;
import com.example.onlinerent.model.Residence;
import com.example.onlinerent.model.RespBean;
import com.example.onlinerent.model.RespPageBean;
import com.example.onlinerent.service.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/residence")
public class ResidenceController {

    @Autowired
    ResidenceService residenceService;

    /**
     * @RequestBody 表示请求体中的参数是 JSON，不加这个注解表示请求体中的参数是 key-value
     *
     * @PostMapping 注解表示当前请求是一个 post 请求
     * @param residence
     * @return
     */
    @PostMapping
    public RespBean addResidence(@RequestBody Residence residence) {
        return residenceService.addResidence(residence);
    }

    @GetMapping
    public RespPageBean getResidencePages(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String name,String province,String city,String area
    ){
        return  residenceService.getResidenceByPage(page,size,name,province,city,area);
    }

    /**
     * 删除数据
     * http://localhost:8081/residence?rid=99
     * http://localhost:8081/residence/99
     * @param rid
     * @return
     */
    @DeleteMapping("/{rid}")
    public RespBean deleteResidenceById(@PathVariable Integer rid) {
        return residenceService.deleteResidenceById(rid);
    }

    @PutMapping
    public RespBean updateResidence(@RequestBody Residence residence){
        return residenceService.updateResidence(residence);
    }

    @GetMapping("/{rid}")
    public RespBean getResidenceById(@PathVariable Integer rid){
        return residenceService.getResidenceById(rid);
    }

    @GetMapping("/export")
    public void exportData(HttpServletResponse response) throws IOException {
        List<Residence> list = (List<Residence>) residenceService.getResidenceByPage(1,Integer.MAX_VALUE,
                null,null,null,null).getData();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("content-dispositioin","attachment;filename=" + new String("小区数据.xlsx".getBytes
                ("UTF-8"),"ISO-8859-1"));
        EasyExcel.write(response.getOutputStream(),Residence.class).sheet("小区数据").doWrite(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(),Residence.class,new ResidenceReadListener(residenceService)).sheet().doRead();
            return RespBean.ok("导入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RespBean.error("导入失败");
    }

}
