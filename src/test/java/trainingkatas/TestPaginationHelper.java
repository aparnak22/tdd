package trainingkatas;

import com.techreturners.trainingkatas.PaginationHelper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;


public class TestPaginationHelper {
    @Test
    void testPageCountForOneItem() {
        PaginationHelper<Character> helper = new PaginationHelper<>(Arrays.asList('a'), 1);
        assertEquals(1,helper.pageCount());
        assertEquals(1,helper.itemCount());
        //sertEquals(1,helper.pageItemCount(0));


    }

    @Test
    void testPageCountForTwoItems() {
        PaginationHelper<Character> helper = new PaginationHelper<>(Arrays.asList('a','b'), 2);
        assertEquals(1,helper.pageCount());
        assertEquals(2,helper.itemCount());
        //sertEquals(1,helper.pageItemCount(0));


    }

    @Test
    void testPageCountForManyItems() {
        PaginationHelper<Character> helper = new PaginationHelper<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j'), 2);
        assertEquals(5,helper.pageCount());
        assertEquals(10,helper.itemCount());
        //sertEquals(1,helper.pageItemCount(0));


    }

  /*PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
helper.pageCount(); //should == 2
helper.itemCount(); //should == 6
helper.pageItemCount(0); //should == 4
helper.pageItemCount(1); // last page - should == 2
helper.pageItemCount(2); // should == -1 since the page is invalid

// pageIndex takes an item index and returns the page that it belongs on
helper.pageIndex(5); //should == 1 (zero based index)
helper.pageIndex(2); //should == 0
helper.pageIndex(20); //should == -1
helper.pageIndex(-10); //should == -1
*/
}
