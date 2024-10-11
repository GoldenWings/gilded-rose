package com.gildedrose;


public class ConjuredItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        degradeTwiceAsFast(item);

        item.sellIn--;

        if (item.sellIn < 0) {
            degradeTwiceAsFast(item);
        }
    }

    private static void degradeTwiceAsFast(Item item) {
        ItemQualityUtils.decreaseQuality(item);
        ItemQualityUtils.decreaseQuality(item);
    }
}