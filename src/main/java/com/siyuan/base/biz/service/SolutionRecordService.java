package com.siyuan.base.biz.service;

import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.SolutionRecordForm;

public interface SolutionRecordService {

    WebResponse saveSolution(SolutionRecordForm form);
}
