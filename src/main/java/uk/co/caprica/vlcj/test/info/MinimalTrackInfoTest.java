package uk.co.caprica.vlcj.test.info;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.media.Media;
import uk.co.caprica.vlcj.media.MediaEventAdapter;
import uk.co.caprica.vlcj.media.MediaParsedStatus;
import uk.co.caprica.vlcj.player.base.AudioTrackList;
import uk.co.caprica.vlcj.player.base.TextTrackList;
import uk.co.caprica.vlcj.player.base.VideoTrackList;

import java.util.concurrent.CountDownLatch;

public class MinimalTrackInfoTest {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Specify an MRL");
            System.exit(1);
        }

        MediaPlayerFactory factory = new MediaPlayerFactory();

        Media media = factory.media().newMedia(args[0]);

        CountDownLatch latch = new CountDownLatch(1);

        media.events().addMediaEventListener(new MediaEventAdapter() {
            @Override
            public void mediaParsedChanged(Media media, MediaParsedStatus newStatus) {
                if (newStatus == MediaParsedStatus.DONE) {
                    AudioTrackList audioTracks = media.tracks().audioTracks();
                    VideoTrackList videoTracks = media.tracks().videoTracks();
                    TextTrackList textTracks = media.tracks().textTracks();

                    System.out.println("AUDIO");
                    System.out.println(audioTracks);

                    System.out.println("VIDEO");
                    System.out.println(videoTracks);

                    System.out.println("TEXT");
                    System.out.println(textTracks);

                    audioTracks.release();
                    videoTracks.release();
                    textTracks.release();

                    latch.countDown();
                } else if (newStatus != MediaParsedStatus.PENDING) {
                    System.out.println("Failed: " + newStatus);
                    latch.countDown();
                }
            }
        });

        media.parsing().parse();

        latch.await();

        media.release();
    }
}
