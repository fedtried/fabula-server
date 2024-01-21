package com.server.fabula.Service.Impl;

import com.server.fabula.Entity.Mode;
import com.server.fabula.Entity.User;
import com.server.fabula.Repository.ModeRepository;
import com.server.fabula.Service.ModeService;

import java.util.List;

public class ModeServiceImpl implements ModeService {

    private final ModeRepository modeRepository;

    public ModeServiceImpl(ModeRepository modeRepository) {
        this.modeRepository = modeRepository;
    }

    @Override
    public List<Mode> findAllModes() {
        return modeRepository.findAll();
    }
}
