package cpsc2150.listDec;

/**
 * Jeffrey Black (jtblack)
 * CPSC 2151-004
 * Lab 10 - Decorator Pattern
 *
 * decorator for List
 * allows a list to be shuffled.
 */

import java.util.List;
import java.util.Random;

public interface IShuffleList<T> extends List<T> {

    /**
     * @param swaps number of swaps to perform
     * @pre swaps > 0
     * @post random pair of positions in the list are swapped swaps times
     */
    default void shuffle(int swaps){
        Random rand = new Random();

        for(int i = 0; i < swaps; i++){
            //choose positions to swap
            int pos1 = -1, pos2 = -1;
            do {
                pos1 = rand.nextInt(this.size());
                pos2 = rand.nextInt(this.size());
            }
            while(pos1 == pos2);

            //swap positions
            this.swap(pos1, pos2);
        }

    }

    /**
     * @param i first position in list to swap
     * @param j second position in list to swap
     * @pre 0 <= i < List.size()
     * @pre 0 <= j < List.size()
     * @pre i != j
     * @post values at position i and j are swapped
     */
    default void swap(int i, int j){
        T temp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, temp);
    }
}
