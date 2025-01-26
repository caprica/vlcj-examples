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

package uk.co.caprica.vlcj.test.factory;

import uk.co.caprica.vlcj.factory.AudioOutput;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.AudioDevice;
import uk.co.caprica.vlcj.test.VlcjTest;

import java.util.List;

/**
 * Simple test to dump out audio output devices.
 */
public class AudioOutputsTest extends VlcjTest {

    private static final String FORMAT_PATTERN = "%3s %-12s %-40s\n";

    public static void main(String[] args) throws Exception {
        MediaPlayerFactory factory = new MediaPlayerFactory();

        List<AudioOutput> audioOutputs = factory.audio().audioOutputs();

        System.out.println("Audio Outputs:");
        System.out.println();

        System.out.printf(FORMAT_PATTERN, "#", "Name", "Description");
        System.out.printf(FORMAT_PATTERN, "=", "====", "===========");
        for(int i = 0; i < audioOutputs.size(); i ++ ) {
            AudioOutput output = audioOutputs.get(i);
            System.out.printf(FORMAT_PATTERN, i, output.getName(), output.getDescription());
        }
    }
}
