package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void shouldDecreaseQualityIfItemIsNotAgedBrieOrBackstageOrSulfurasIfQualityGreaterThanZero() {
        Item[] items = new Item[]{new Item("Ziko", 0, 1)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void shouldNotDecreaseQualityIfItemIsAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 1)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        int expectedQuality = 3;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void shouldNotDecreaseQualityIfItemIsSulfras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 1)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        int expectedQuality = 1;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void shouldNotDecreaseQualityIfItemIsBackStage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        int expectedQuality = 0;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseTheQualityAndSellInValuesOfEachItemAtTheEndOfEveryDay() throws Exception {
        Item[] items = new Item[] { new Item("Any Item", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseQualityTwiceAsFastWhenSellInValueIsEqualOrLessThanZero() throws Exception {
        Item[] items = new Item[] { new Item("Any Item", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void shouldNeverDecreaseQualityBelowZero() throws Exception {
        Item[] items = new Item[] { new Item("Any Item", 10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseAgedBrieQualityAtTheEndOfTheDay() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void shouldNeverIncreaseAgedBrieQualityOver50() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void shouldNeverDecreaseSulfrasQualityAndSellInValues() throws Exception {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseBackStagePassesQualityAtTheEndOfTheDay() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void shouldNeverIncreaseBackStageQualityAbove50() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseBackStagePassesQualityTwiceFasterWhenSellInValueIs10OrLess() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseBackStagePassesQualityThriceFasterWhenSellInValueIs5OrLess() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseConjuredQualityTwiceAsFast() throws Exception {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void shouldNotDecreaseConjuredQualityBelowZero() throws Exception {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
