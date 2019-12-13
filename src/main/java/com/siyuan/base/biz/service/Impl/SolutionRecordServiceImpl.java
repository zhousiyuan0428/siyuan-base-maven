package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.SolutionRecordService;
import com.siyuan.base.dao.entity.SolutionRecordEntity;
import com.siyuan.base.dao.repository.SolutionRecordRepository;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.SolutionRecordForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Service
public class SolutionRecordServiceImpl implements SolutionRecordService {

    @Autowired
    private SolutionRecordRepository repository;

    @Override
    public WebResponse saveSolution(SolutionRecordForm form) {
        SolutionRecordEntity entity = new SolutionRecordEntity();
        BeanUtils.copyProperties(form,entity);
        entity.setCreateBy("周思远");
        entity.setCreateData(new Date());
        repository.save(entity);
        return new WebResponse("success","0000");
    }
}
