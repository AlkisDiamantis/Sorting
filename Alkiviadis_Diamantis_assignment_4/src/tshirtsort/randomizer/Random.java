/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.randomizer;

import tshirtsort.models.Color;
import tshirtsort.models.Fabric;
import tshirtsort.models.Size;

/**
 *
 * @author mac
 */
public class Random {
    
    public String getRandomName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        java.util.Random random = new java.util.Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        return(generatedString);
    }
    
    public Color getRandomColor() {
        Color color1 = Color.values()[getRandomNumberInRange(0,6)];
        return color1;
    }
    
    public Size getRandomSize() {
        Size size1 = Size.values()[getRandomNumberInRange(0,6)];
        return size1;
    }
    
    public Fabric getRandomFabric() {
        Fabric fabric1 = Fabric.values()[getRandomNumberInRange(0,6)];
        return fabric1;
    }
    
    public int getRandomNumberInRange(int min, int max) {

	if (min >= max) {
		throw new IllegalArgumentException("max must be greater than min");
	}

	java.util.Random r = new java.util.Random();
	return r.nextInt((max - min) + 1) + min;
    }
    
}
