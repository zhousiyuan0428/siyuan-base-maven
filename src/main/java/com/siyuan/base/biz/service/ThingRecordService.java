package com.siyuan.base.biz.service;

import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.ThingRecordForm;

public interface ThingRecordService {

    WebResponse save(ThingRecordForm thingRecordForm);

    ThingRecordForm getOneQuestion();
}
