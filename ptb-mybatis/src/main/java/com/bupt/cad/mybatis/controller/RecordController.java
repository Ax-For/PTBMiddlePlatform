package com.bupt.cad.mybatis.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.cad.mybatis.domain.Record;
import com.bupt.cad.mybatis.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 奏折信息 前端控制器
 * </p>
 *
 * @author cad
 * @since 2023-02-06
 */
@RestController
@RequestMapping("/mybatis/record")
public class RecordController {

    @Autowired
    private IRecordService recordService;

    @GetMapping("/list")
    public IPage<Record> getList(Page page, Record record){
        System.out.println("record = " + record);
        return recordService.page(page);
    }

    @GetMapping("/recordList")
    public Record getListByCondition(Record record){
        System.out.println("record = " + record);
        return record;
    }

    @PostMapping()
    public Record printRecord(Record record){
        System.out.println("record = " + record);
        return record;
    }

}
