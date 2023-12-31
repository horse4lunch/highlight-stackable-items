/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.HighlightStackables;

import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;

import net.runelite.client.plugins.grounditems.GroundItemsConfig;
import net.runelite.client.util.HotkeyListener;


class HighlightStackablesHotkeyListener extends HotkeyListener
{
    private final HighlightStackablesPlugin plugin;
    private final HighlightStackablesConfig config;

    private Instant lastPress;
    @Inject
    private GroundItemsConfig groundItemsConfig;
    @Inject
    private HighlightStackablesHotkeyListener(HighlightStackablesPlugin plugin, HighlightStackablesConfig config)
    {
        super(config::hotkey);

        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public void hotkeyPressed()
    {

        if(config.pauseMode())
        {
            groundItemsConfig.setHighlightedItem(config.getOrginalItems());
            plugin.setHotKeyPressed(true);
            lastPress = Instant.now();
        }
    }

    @Override
    public void hotkeyReleased()
    {
        if(config.pauseMode()) {
            config.setOriginalItem(groundItemsConfig.getHighlightItems());
            plugin.setHotKeyPressed(false);
        }
    }
}