/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
import net.runelite.client.config.*;
import net.runelite.client.config.Keybind;


@ConfigGroup("highlightStackables")
public interface HighlightStackablesConfig extends Config
{
    @ConfigSection(
            name = "Item Lists",
            description = "The highlighted item list",
            position = 0
    )
    String itemLists = "itemLists";

    @ConfigItem(
            keyName = "highlightedItems",
            name = "Highlighted Items",
            description = "<html>Configures specifically highlighted ground items. Format: (item), (item)<br>Use this for manually highlighting items rather than the highlighted items list built into ground items.<html>",
            position = 0,
            section = itemLists
    )
    default String getOrginalItems()
    {
        return "";
    }

    @ConfigItem(
            keyName = "highlightedItems",
            name = "",
            description = ""
    )
    void setOriginalItem(String key);

    @ConfigItem(
            keyName = "InventoryMode",
            name = "Highlight stackables in inventory",
            description = "<html>Highlight stackable ground items already in inventory.<br>If this is disabled, all stackable items will be highlighted.<br>Unless they are on the hidden item list.</html>",

            position = 32
    )
    default boolean inventoryMode()
    {
        return true;
    }

    //I've tested this quite a bit with no issues but im still gonna leave the experimental label on it for now.
    @ConfigSection(
            name = "Experimental",
            description = "Experimental options",
            position = 40
    )
    String experimental = "Experimental";
    @ConfigItem(
            keyName = "pauseMode",
            name = "Use hotkey to highlight",
            description = "<html>This lets you pause the plugin so you can use the ground items hotkey to highlight.</html>",
            section = experimental,
            position = 41
    )
    default boolean pauseMode()
    {
        return false;
    }
    @ConfigItem(
            keyName = "hotkey",
            name = "Hotkey",
            description = "Set this to match your hotkey from GroundItemsPlugin",
            section = experimental,
            position = 42
    )
    default Keybind hotkey()
    {
        return Keybind.ALT;
    }
}