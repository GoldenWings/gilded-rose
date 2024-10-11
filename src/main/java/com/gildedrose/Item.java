package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void updateItem() {
        boolean isAgedBrie = name.equals("Aged Brie");
        boolean isBackstagePass = name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isSulfras = name.equals("Sulfuras, Hand of Ragnaros");

        if(isAgedBrie) {
            updateAgedBrieQualityAndSellIn();
        }
        else if (isBackstagePass) {
            updateBackstageQualityAndSellIn();
        } else if (!isSulfras) {
            updateOtherItemsQualityAndSellIn();
        }
    }

    private void updateOtherItemsQualityAndSellIn() {
        if (quality > 0) {
            quality = quality - 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
    }

    private void updateBackstageQualityAndSellIn() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }

    private void updateAgedBrieQualityAndSellIn() {
        if (quality < 50) {
            quality = quality + 1;

        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
