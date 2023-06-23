package com.example.onlinerent.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.example.onlinerent.model.Residence;
import com.example.onlinerent.service.ResidenceService;

import java.util.ArrayList;
import java.util.List;

public class ResidenceReadListener implements ReadListener<Residence> {
    private List<Residence> residences = new ArrayList<>();

    private ResidenceService residenceService;

    public ResidenceReadListener(ResidenceService residenceService) {
        this.residenceService = residenceService;
    }

    @Override
    public void invoke(Residence residence, AnalysisContext analysisContext) {
        residences.add(residence);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        residenceService.addResidences(residences);
    }
}
