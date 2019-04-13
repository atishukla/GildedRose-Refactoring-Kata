package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // looping through all the items so quality does not increase while ageing
        for (Item item: items) {
            // item not Aged Brie
            if (!item.name.equals("Aged Brie")
                    // item not Backstage passes so quality does not increase while ageing
                    // quality 0 after the concert
                    // Brie increase quality by 1 every day
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    // if item is not sulfuras ( so it can be sold )
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        // quality decreases day by day
                        item.quality = item.quality - 1;
                    }
                }
                // item is brie and backstage passes ( quality increases every day in both cases )
            } else {
                // quality cannot be more than 50
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    // item is Backstage passes (quality increases every day)
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // inc
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                // it should be +2
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                // it should be +3
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}