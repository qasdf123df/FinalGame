package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import io.github.some_example_name.GameResources;
import io.github.some_example_name.MemoryManager;

public class AudioManager {

    public boolean isMusicOn;

    public Music backgroundMusic;
    public AudioManager() {
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal(GameResources.BACKGROUND_MUSIC_PATH));

        backgroundMusic.setVolume(0.2f);
        backgroundMusic.setLooping(true);

        updateMusicFlag();
    }
    public void updateMusicFlag() {
        isMusicOn = MemoryManager.loadIsMusicOn();

        if (isMusicOn) backgroundMusic.play();
        else backgroundMusic.stop();
    }



}
