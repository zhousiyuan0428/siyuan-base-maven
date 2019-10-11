package com.siyuan.base.domain.service;

import com.siyuan.base.dao.entity.Familytree;
import com.siyuan.base.dao.repository.FamilyTreeRepository;
import com.siyuan.base.domain.model.FamilyTreeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyTreeService {

    @Autowired
    private FamilyTreeRepository familyTreeRepository;

    public FamilyTreeModel getTreeInfo(){
        FamilyTreeModel familyTreeModel = new FamilyTreeModel();
        Iterable<Familytree> familyTrees = familyTreeRepository.findAll();
        //Step 1.找出顶级节点向下轮询
        familyTrees.forEach( familyTree -> {
            System.out.println(familyTree);
            BeanUtils.copyProperties(familyTree,familyTreeModel);
        });
        return familyTreeModel;
    }
}
