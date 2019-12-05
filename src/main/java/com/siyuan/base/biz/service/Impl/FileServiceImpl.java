package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.FileService;
import com.siyuan.base.dao.entity.FileEntity;
import com.siyuan.base.dao.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void addFileInfo(FileEntity fileEntity) {
        fileRepository.save(fileEntity);
    }
}
