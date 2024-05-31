package com.team2_project1.project1.service;

import com.team2_project1.project1.Mapper.CheerMapper;
import com.team2_project1.project1.model.Cheer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheerService {
    private final CheerMapper cheerMapper;

    @Autowired
    public CheerService(CheerMapper cheerMapper) {
        this.cheerMapper = cheerMapper;
    }

    public List<Cheer> getAllCheer() {
        return cheerMapper.getAllCheer();
    }

    public void insertCheer(Cheer cheer) {
        cheerMapper.insertCheer(cheer);
    }

    public Cheer getCheerById(Long id) {
        return cheerMapper.getCheerById(id);
    }

    public Resource loadCheerImage(Cheer cheer) {
        byte[] imageBytes = null; // 이미지 바이트 배열을 Cheer 객체에서 가져오는 코드를 작성해야 합니다.
        // 예: cheer.getImageBytes();

        if (imageBytes != null) {
            return new ByteArrayResource(imageBytes);
        } else {
            return null; // 이미지가 없는 경우에 대한 처리를 추가해야 합니다.
        }
    }
}
