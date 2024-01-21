package com.server.fabula.Config;

import com.server.fabula.Repository.ModeRepository;
import com.server.fabula.Service.Impl.ModeServiceImpl;
import com.server.fabula.Service.ModeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModeServiceConfig {

    @Bean
    public ModeService modeService(ModeRepository modeRepository){
        return new ModeServiceImpl(modeRepository);
    }

}
