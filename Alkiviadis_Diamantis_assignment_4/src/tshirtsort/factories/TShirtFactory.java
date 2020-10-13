
package tshirtsort.factories;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;
import tshirtsort.randomizer.RandomTShirt;

public class TShirtFactory {
    
    public List<TShirt> tShirtGenerateX(int x) {
        RandomTShirt rt = new RandomTShirt();
        List<TShirt> listOfTShirts = new ArrayList<>();
                
        for (int i = 0; i < x; i++) {
            listOfTShirts.add(rt.generate());
        }
        return(listOfTShirts);
    }
    
}
