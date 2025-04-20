package com.MYTllc.lavalink.instagram; // <-- Updated Package

import dev.arbjerg.lavalink.api.AudioSourceManager;
import dev.arbjerg.lavalink.api.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InstagramPlugin implements Plugin {

    private static final Logger log = LoggerFactory.getLogger(InstagramPlugin.class);
    private final InstagramAudioSourceManager instagramAudioSourceManager;

    public InstagramPlugin(InstagramAudioSourceManager instagramAudioSourceManager) {
        log.info("Loading MYTllc Enhanced Instagram Lavalink Plugin v1.2.0..."); // Updated Log Message
        this.instagramAudioSourceManager = instagramAudioSourceManager;
    }

    @Override
    public String getName() {
        return "EnhancedInstagramSource"; // Keep generic or change if desired: "MYTllcInstagramSource"
    }

    @Override
    public List<AudioSourceManager> getSources() {
        log.info("Providing InstagramAudioSourceManager instance (MYTllc)."); // Updated Log Message
        return Collections.singletonList(this.instagramAudioSourceManager);
    }
}
