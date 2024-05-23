package com.team2_project1.project1.Controller;


import com.team2_project1.project1.model.Cheer;
import com.team2_project1.project1.service.CheerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CheerController {


    private final CheerService cheerService;

    public CheerController(CheerService cheerService) {
        this.cheerService = cheerService;
    }

    @GetMapping("/api/Cheer")
    public List<Cheer> getAllCheer() {
        return cheerService.getAllCheer();

    }
    @PostMapping("/api/Cheer")
    public void insertCheer(@RequestBody Cheer cheer){
        cheerService.insertCheer(cheer);
    }

}


