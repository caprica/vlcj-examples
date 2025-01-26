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
 * Copyright 2009-2025 Caprica Software Limited.
 */

package uk.co.caprica.vlcj.test.streaming;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.AudioListPlayerComponent;
import uk.co.caprica.vlcj.player.list.PlaybackMode;

/**
 * This tiny demo application can be used to stream an entire audio collection.
 * <p>
 * Pass the top-level directory of your media collection in args.
 * <p>
 * Currently RTP is used, you can change the "sout" settings to whatever you need if you don't want to use RTP, and
 * tweak the transcoding options to whatever you want (or remove them entirely).
 */
public class StreamAllTheThings {
    private static final String[] factoryOptions = { "--no-sout-all", "--sout-shout-mp3", "--sout-keep" };
    private static final String mediaOptions = ":sout=#rtp{dst=localhost,port=8000,mux=ts}";
//    private static final String mediaOptions = ":sout=#transcode{vcodec=none,acodec=mp3,ab=192,channels=2,samplerate=44100,scodec=none}:rtp{dst=localhost,port=8000,mux=ts}";

    public static void main(String[] args) throws InterruptedException {
        AudioListPlayerComponent component = new AudioListPlayerComponent(new MediaPlayerFactory(factoryOptions));
        component.mediaListPlayer().list().media().add(args[0], mediaOptions);
        component.mediaListPlayer().controls().setMode(PlaybackMode.LOOP);
        component.mediaListPlayer().controls().play();
        Thread.currentThread().join();
    }
}
