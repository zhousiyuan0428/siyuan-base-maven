package com.siyuan.base.biz.service;

import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.ThingRecordForm;

import java.util.List;

public interface ThingRecordService {

    WebResponse save(ThingRecordForm thingRecordForm);

    List<ThingRecordForm> getThingRecordByStatus(int thingStatus);

    WebResponse dealRecordInfo(ThingRecordForm thingRecordForm);
}
