package uk.co.caprica.vlcj.test.youtube;

import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.component.AudioPlayerComponent;
import uk.co.caprica.vlcj.test.VlcjTest;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class YouTubeItems extends VlcjTest {

    public static void main(String[] args) throws Exception {
        String mrl = "https://www.youtube.com/watch?v=vw2FOYjCz38";

        AudioPlayerComponent playerComponent = new AudioPlayerComponent();

        CountDownLatch latch = new CountDownLatch(1);

        MediaPlayerEventListener l1 = new MediaPlayerEventAdapter() {
            @Override
            public void opening(MediaPlayer mediaPlayer) {
                System.out.println("opening");
            }

            @Override
            public void playing(MediaPlayer mediaPlayer) {
                System.out.println("playing");
            }

            @Override
            public void stopped(MediaPlayer mediaPlayer) {
                System.out.println("stopped");
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {
                System.out.println("finished");
                latch.countDown();
            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
                System.out.println("error");
                latch.countDown();
            }
        };

        playerComponent.mediaPlayer().events().addMediaPlayerEventListener(l1);

        playerComponent.mediaPlayer().media().play(mrl);

        latch.await();

        playerComponent.mediaPlayer().events().removeMediaPlayerEventListener(l1);

        MediaList list = playerComponent.mediaPlayer().subitems().list().newMediaList();
        if (list != null) {
            List<String> mrls = list.media().mrls();
            for (int i = 0; i < mrls.size(); i++) {
                System.out.printf("%3d %s%n", i, mrls.get(i));
            }

            list.release();
        }

        playerComponent.release();
    }

}
