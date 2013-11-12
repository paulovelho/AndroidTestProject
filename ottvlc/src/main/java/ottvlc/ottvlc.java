package ottvlc;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.direct.DirectMediaPlayer;
import uk.co.caprica.vlcj.player.direct.RenderCallback;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import java.awt.image.BufferedImage;


public class Ottvlc {

    public Ottvlc(){
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }

    public void SetPlayer(){
    }

    public void Play(String multicastUrl, String multicastPort){
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();

        String loadUrl = multicastUrl + multicastPort;

        DirectMediaPlayer mediaPlayer = mediaPlayerFactory.newDirectMediaPlayer(
                320, 240,
                new RenderCallback() {
                    @Override
                    public void display(Memory arg0) {
                        // Do nothing.
                    }
                });

        // Options setup.
        String[] options = new String[]{};
        String mrl = "v4l2:///dev/video0"; // Linux

        // Start processing.
        mediaPlayer.startMedia(mrl, options);

        BufferedImage bufImg;
        for (int i = 0; i < 1000; ++i) {
            bufImg = mediaPlayer.getSnapshot();

    }

}
