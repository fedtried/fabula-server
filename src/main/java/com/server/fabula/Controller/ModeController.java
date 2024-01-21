package com.server.fabula.Controller;

import com.server.fabula.Entity.Mode;
import com.server.fabula.Entity.User;
import com.server.fabula.Service.ModeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModeController {

    private final ModeService modeService;

    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }

    @GetMapping("/mode")
    public List<Mode> getAllModes(){
        return modeService.findAllModes();
    }

}
