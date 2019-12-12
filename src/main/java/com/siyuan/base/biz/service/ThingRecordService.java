package com.siyuan.base.biz.service;

import com.siyuan.base.web.form.ThingRecordForm;

import java.util.List;

public interface ThingRecordService {

    String save(ThingRecordForm thingRecordForm);

    List<ThingRecordForm> queryAll();
}
