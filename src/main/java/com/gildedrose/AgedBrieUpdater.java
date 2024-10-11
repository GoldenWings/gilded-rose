package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        ItemQualityUtils.increaseQuality(item);

        item.sellIn--;

        if (item.sellIn < 0) {
            ItemQualityUtils.increaseQuality(item);
        }
    }
}