package com.example.springboot_webflux_video_streaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class StreamingService {

    @Autowired
    public ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> {
            return resourceLoader.getResource("classpath:videos/" + title + ".mp4");
        });
    }
    
}
