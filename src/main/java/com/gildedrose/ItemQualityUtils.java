package com.gildedrose;

public class ItemQualityUtils {
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public static void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    public static void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}