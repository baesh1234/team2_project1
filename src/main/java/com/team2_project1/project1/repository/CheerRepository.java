package com.team2_project1.project1.repository;

import com.team2_project1.project1.domain.CheerComments;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CheerRepository  {

    CheerComments saveComment (CheerComments cheerComments);
    List<CheerComments> findAllComment();
}
