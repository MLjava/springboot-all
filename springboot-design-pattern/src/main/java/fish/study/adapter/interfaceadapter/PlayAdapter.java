package fish.study.adapter.interfaceadapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayAdapter implements Play {

    private PlayMedia playMedia;

    @Override
    public void play(String media) {
        if ("mp3".equalsIgnoreCase(media)) {
            log.info("播放mp3");
            playMedia = new MP3PlayMedia();
            playMedia.playMP3();
        }
        if ("mp4".equalsIgnoreCase(media)) {
            log.info("播放mp3");
            playMedia = new MP4PlayMedia();
            playMedia.playMP4();
        }
    }
}
