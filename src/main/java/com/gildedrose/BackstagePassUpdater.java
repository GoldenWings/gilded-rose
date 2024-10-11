package com.gildedrose;

public class BackstagePassUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        ItemQualityUtils.increaseQuality(item);

        if (item.sellIn < 11) {
            ItemQualityUtils.increaseQuality(item);
        }

        if (item.sellIn < 6) {
            ItemQualityUtils.increaseQuality(item);
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}