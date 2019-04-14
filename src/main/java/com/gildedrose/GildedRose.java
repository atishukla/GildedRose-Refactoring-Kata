package com.gildedrose;

import com.gildedrose.item.CustomisedItem;
import com.gildedrose.item.CustomisedItemFactory;
import com.gildedrose.item.Item;
import com.gildedrose.item.QualityValues;

class GildedRose {
    //Max and Min value for quality
    private static final int LOWEST_QUALITY_VALUE_POSSIBLE = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // looping through all the items so quality does not increase while ageing
        for (Item item : items) {
            customisedItem(item).updateState();
            if (hasReachedLowestQualityValue(item)) {
                item.quality = LOWEST_QUALITY_VALUE_POSSIBLE;
            } else if (hasReachedHighestQualityValue(item)) {
                item.quality = QualityValues.highestValuePossible(item);
            }
        }
    }

    private CustomisedItem customisedItem(Item item) {
        return new CustomisedItemFactory(item).customiseItem(item);
    }

    private boolean hasReachedLowestQualityValue(Item item) {
        return item.quality < LOWEST_QUALITY_VALUE_POSSIBLE;
    }

    private boolean hasReachedHighestQualityValue(Item item) {
        return item.quality > QualityValues.highestValuePossible(item);
    }
}