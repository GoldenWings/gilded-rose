package com.gildedrose;

public class DefaultItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        ItemQualityUtils.decreaseQuality(item);

        item.sellIn--;

        if (item.sellIn < 0) {
            ItemQualityUtils.decreaseQuality(item);
        }
    }
}