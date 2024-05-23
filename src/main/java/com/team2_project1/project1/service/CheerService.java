package com.team2_project1.project1.service;

import com.team2_project1.project1.Mapper.CheerMapper;
import com.team2_project1.project1.model.Cheer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheerService {
    @Autowired
    private final CheerMapper cheerMapper;

    public CheerService(CheerMapper cheerMapper) {

        this.cheerMapper = cheerMapper;
    }

    public List<Cheer> getAllCheer() {

        return cheerMapper.getAllCheer();
    }

    public  void insertCheer(Cheer cheer){
        cheerMapper.insertCheer(cheer);
    }

}
