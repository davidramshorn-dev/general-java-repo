package tiktaktoeExtended;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    private Clip clip;

    public void play(String dateipfad, boolean loop) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(dateipfad));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
            else clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) clip.stop();
    }
}
