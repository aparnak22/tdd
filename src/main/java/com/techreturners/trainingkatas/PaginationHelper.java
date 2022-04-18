package com.techreturners.trainingkatas;

import java.util.List;


public class PaginationHelper<I> {

    private final List<I> collection;
    private final int itemsPerPage;
    private int pageCount ;
    final int itemsOnLastPage;
    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.pageCount = collection.size() / itemsPerPage;
        itemsOnLastPage = collection.size() % itemsPerPage;
        if ( itemsOnLastPage !=0 ) pageCount++;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if ( pageIndex < 0 || pageIndex >= pageCount) return -1;
        if (pageIndex < pageCount -1  ) return itemsPerPage;
        if (  itemsOnLastPage == 0)
            return itemsPerPage;
        else return itemsOnLastPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if ( itemIndex >= 0 && itemIndex < collection.size() )
            return itemIndex / itemsPerPage ;
        else
            return -1 ;
    }
}