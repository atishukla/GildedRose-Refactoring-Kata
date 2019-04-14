package com.gildedrose.item;

public class StandardItem implements CustomisedItem {

    private final Item item;

    public StandardItem(Item item) {
        this.item = item;
    }

    public void updateState(){
        decreaseSellByDayValueByOne();
        if (sellByDayValueIsOverZero()) {
            decreaseQualityBy(decreasingValueOverZeroDaysToSell());
        } else {
            decreaseQualityBy(decreasingValueForZeroOrLessDaysToSell());
        }
    }

    //At the end of each day our system lowers both values for every item
    public int decreasingValueOverZeroDaysToSell() {
        return 1;
    }

    private void decreaseSellByDayValueByOne() {
        item.sellIn -= 1;
    }

    private boolean sellByDayValueIsOverZero() {
        return item.sellIn > 0;
    }

    private void decreaseQualityBy(int qualityValue) {
        item.quality -= qualityValue;
    }

    //Once the sell by date has passed, Quality degrades twice as fast
    private int decreasingValueForZeroOrLessDaysToSell() {
        return decreasingValueOverZeroDaysToSell() * 2;
    }
}
