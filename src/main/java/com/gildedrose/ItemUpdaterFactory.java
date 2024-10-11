package com.gildedrose;
import java.util.HashMap;
import java.util.Map;

public class ItemUpdaterFactory {
    private static final Map<String, ItemUpdater> UPDATERS = new HashMap<>();
    static {
        UPDATERS.put(ItemNames.AGED_BRIE, new AgedBrieUpdater());
        UPDATERS.put(ItemNames.BACKSTAGE_PASS, new BackstagePassUpdater());
        UPDATERS.put(ItemNames.SULFURAS, new SulfurasUpdater());
        UPDATERS.put(ItemNames.CONJURED, new ConjuredItemUpdater());
    }

    public static ItemUpdater getItemUpdater(Item item) {
        return UPDATERS.getOrDefault(item.name, new DefaultItemUpdater());
    }
}