/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.randomizer;

import tshirtsort.models.Color;
import tshirtsort.models.Fabric;
import tshirtsort.models.Size;
import tshirtsort.models.TShirt;
import tshirtsort.randomizer.Random;

/**
 *
 * @author mac
 */
public class RandomTShirt {

    public TShirt generate() {
        Random r = new Random();
        Color color = r.getRandomColor();
        Size size = r.getRandomSize();
        Fabric fabric = r.getRandomFabric();

        TShirt t1 = new TShirt(r.getRandomName(), color, size, fabric, r.getRandomNumberInRange(0, 20));
        return (t1);
    }

}
