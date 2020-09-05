/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2009-2020 Caprica Software Limited.
 */

package uk.co.caprica.vlcj.test.info;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.media.TrackType;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.base.Track;
import uk.co.caprica.vlcj.player.base.TrackList;
import uk.co.caprica.vlcj.test.VlcjTest;

/**
 * A test for the various media information functions.
 * <p>
 * For regular media files (like ".mpg" or ".avi") the track information is available after the
 * media has been parsed (or played).
 * <p>
 * For DVD media files (like ".iso" files) the track information is not available after the media
 * has been parsed, a video output must have been created, and even then the video track
 * width/height might not be available until a short time later.
 * <p>
 * In all cases, the other functions for title, video, audio and chapter descriptions require that a
 * video output has been created before they return valid information.
 * <p>
 * For the new (LibVLC 4.0.0) track information it appears that the track information is available
 * when an elementary stream added event has been received.
 */
public class MediaInfoTest extends VlcjTest {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Specify an MRL");
            System.exit(1);
        }

        MediaPlayerFactory factory = new MediaPlayerFactory("--no-dvdnav-menu");
        final MediaPlayer mediaPlayer = factory.mediaPlayers().newMediaPlayer();

        mediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void elementaryStreamAdded(MediaPlayer mediaPlayer, TrackType type, int id, String streamId) {
                TrackList<? extends Track> tracks;
                switch (type) {
                    case AUDIO:
                        tracks = mediaPlayer.tracks().audioTracks();
                        break;
                    case VIDEO:
                        tracks = mediaPlayer.tracks().videoTracks();
                        break;
                    case TEXT:
                        tracks = mediaPlayer.tracks().textTracks();
                        break;
                    default:
                        System.out.println("no tracks for " + type);
                        return;
                }
                System.out.printf("%s: %s%n", type, tracks);
            }
        });

        mediaPlayer.media().prepare(args[0]);
        mediaPlayer.controls().start();

        Thread.sleep(3000);

        mediaPlayer.controls().stop();

        mediaPlayer.release();
        factory.release();
    }
}
