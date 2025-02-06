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

package uk.co.caprica.vlcj.test.event;

import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.media.TrackType;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.base.TitleDescription;

/**
 * Implementation of a {@link MediaPlayerEventListener} that logs all invocations.
 * <p>
 * Useful only for testing.
 */
public class LoggingMediaPlayerEventAdapter implements MediaPlayerEventListener {

    @Override
    public void mediaChanged(MediaPlayer mediaPlayer, MediaRef media) {
        System.out.printf("mediaChanged(mediaPlayer=%s,media=%s)%n", mediaPlayer, media);
    }

    @Override
    public void opening(MediaPlayer mediaPlayer) {
        System.out.printf("opening(mediaPlayer=%s)%n", mediaPlayer);
    }

    @Override
    public void buffering(MediaPlayer mediaPlayer, float newCache) {
        System.out.printf("buffering(mediaPlayer=%s,newCache=%f)%n", mediaPlayer, newCache);
    }

    @Override
    public void playing(MediaPlayer mediaPlayer) {
        System.out.printf("playing(mediaPlayer=%s)%n", mediaPlayer);
    }

    @Override
    public void paused(MediaPlayer mediaPlayer) {
        System.out.printf("paused(mediaPlayer=%s)%n", mediaPlayer);
    }

    @Override
    public void stopped(MediaPlayer mediaPlayer) {
        System.out.printf("stopped(mediaPlayer=%s)%n", mediaPlayer);
    }

    @Override
    public void forward(MediaPlayer mediaPlayer) {
        System.out.printf("forward(mediaPlayer=%s%n", mediaPlayer);
    }

    @Override
    public void backward(MediaPlayer mediaPlayer) {
        System.out.printf("backward(mediaPlayer=%s%n", mediaPlayer);
    }

    @Override
    public void stopping(MediaPlayer mediaPlayer) {
        System.out.printf("stopping(mediaPlayer=%s%n", mediaPlayer);
    }

    @Override
    public void finished(MediaPlayer mediaPlayer) {
        System.out.printf("finished(mediaPlayer=%s%n", mediaPlayer);
    }

    @Override
    public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
        System.out.printf("timeChanged(mediaPlayer=%s,newTime=%d)%n", mediaPlayer, newTime);
    }

    @Override
    public void positionChanged(MediaPlayer mediaPlayer, double newPosition) {
        System.out.printf("positionChanged(mediaPlayer=%s,newPosition=%f)%n", mediaPlayer, newPosition);
    }

    @Override
    public void seekableChanged(MediaPlayer mediaPlayer, int newSeekable) {
        System.out.printf("seekableChanged(mediaPlayer=%s,newSeekable=%d)%n", mediaPlayer, newSeekable);
    }

    @Override
    public void pausableChanged(MediaPlayer mediaPlayer, int newPausable) {
        System.out.printf("pausableChanged(mediaPlayer=%s,newPausable=%d)%n", mediaPlayer, newPausable);
    }

    @Override
    public void titleListChanged(MediaPlayer mediaPlayer) {
        System.out.printf("titleListChanged(mediaPlayer=%s)%n", mediaPlayer);
    }

    @Override
    public void titleSelectionChanged(MediaPlayer mediaPlayer, TitleDescription title, int index) {
        System.out.printf("titleSelectionChanged(mediaPlayer=%s,newTitle=%d)%n", mediaPlayer, index);
    }

    @Override
    public void snapshotTaken(MediaPlayer mediaPlayer, String filename) {
        System.out.printf("snapshotTaken(mediaPlayer=%s,filename=%s)%n", mediaPlayer, filename);
    }

    @Override
    public void lengthChanged(MediaPlayer mediaPlayer, long newLength) {
        System.out.printf("timeChanged(mediaPlayer=%s,newLength=%d)%n", mediaPlayer, newLength);
    }

    @Override
    public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
        System.out.printf("videoOutput(mediaPlayer=%s,newCount=%d)%n", mediaPlayer, newCount);
    }

    @Override
    public void elementaryStreamAdded(MediaPlayer mediaPlayer, TrackType type, int id, String streamId) {
        System.out.printf("elementaryStreamAdded(mediaPlayer=%s,type=%s,id=%d)%n", mediaPlayer, type, id);
    }

    @Override
    public void elementaryStreamDeleted(MediaPlayer mediaPlayer, TrackType type, int id, String streamId) {
        System.out.printf("elementaryStreamDeleted(mediaPlayer=%s,type=%s,id=%d)%n", mediaPlayer, type, id);
    }

    @Override
    public void elementaryStreamUpdated(MediaPlayer mediaPlayer, TrackType type, int id, String streamId) {
        System.out.printf("elementaryStreamUpdated(mediaPlayer=%s,type=%s,id=%d,streamId=%s)%n", mediaPlayer, type, id, streamId);
    }

    @Override
    public void elementaryStreamSelected(MediaPlayer mediaPlayer, TrackType type, String unselectedStreamId, String selectedStreamId) {
        System.out.printf("elementaryStreamSelected(mediaPlayer=%s,type=%s,unselectedStreamId=%s,selectedStreamId=%s)%n", mediaPlayer, type, unselectedStreamId, selectedStreamId);
    }

    @Override
    public void corked(MediaPlayer mediaPlayer, boolean corked) {
        System.out.printf("corked(mediaPlayer=%s,corked=%s)%n", mediaPlayer, corked);
    }

    @Override
    public void muted(MediaPlayer mediaPlayer, boolean muted) {
        System.out.printf("muted(mediaPlayer=%s,muted=%s)%n", mediaPlayer, muted);
    }

    @Override
    public void volumeChanged(MediaPlayer mediaPlayer, float volume) {
        System.out.printf("volumeChanged(mediaPlayer=%s,volume=%f)%n", mediaPlayer, volume);
    }

    @Override
    public void audioDeviceChanged(MediaPlayer mediaPlayer, String audioDevice) {
        System.out.printf("audioDeviceChanged(mediaPlayer=%s,audioDevice=%s)%n", mediaPlayer, audioDevice);
    }

    @Override
    public void chapterChanged(MediaPlayer mediaPlayer, int newChapter) {
        System.out.printf("chapterChanged(mediaPlayer=%s,newChapter=%d)%n", mediaPlayer, newChapter);
    }

    @Override
    public void recordChanged(MediaPlayer mediaPlayer, boolean recording, String recordedFilePath) {
        System.out.printf("recordChanged(mediaPlayer=%s,recording=%s,recordedFilePath=%s)%n", mediaPlayer, recording, recordedFilePath);
    }

    @Override
    public void programAdded(MediaPlayer mediaPlayer, int id) {
        System.out.printf("programAdded(mediaPlayer=%s,id=%d)%n", mediaPlayer, id);
    }

    @Override
    public void programDeleted(MediaPlayer mediaPlayer, int id) {
        System.out.printf("programDeleted(mediaPlayer=%s,id=%d)%n", mediaPlayer, id);
    }

    @Override
    public void programUpdated(MediaPlayer mediaPlayer, int id) {
        System.out.printf("programUpdated(mediaPlayer=%s,id=%d)%n", mediaPlayer, id);
    }

    @Override
    public void programSelected(MediaPlayer mediaPlayer, int unselectedId, int selectedId) {
        System.out.printf("programSelected(mediaPlayer=%s,unselectedId=%d,selectedId=%d)%n", mediaPlayer, unselectedId, selectedId);
    }

    @Override
    public void error(MediaPlayer mediaPlayer) {
        System.out.printf("error(mediaPlayer=%s)%n", mediaPlayer);
    }

    @Override
    public void mediaPlayerReady(MediaPlayer mediaPlayer) {
        System.out.printf("ready(mediaPlayer=%s)%n", mediaPlayer);
    }

}
