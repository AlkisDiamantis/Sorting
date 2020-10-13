package tshirtsort.sorting;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;

public class BucketSort {

    List<TShirt>[] buckets;

    // sortType = true - ASC, false = DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    public List<TShirt> sort(List<TShirt> tshirts, int maxValue, boolean sortType, int sortByProperty) {

        List<TShirt> sorted_tshirts = new ArrayList<>();
        List<TShirt>[] buckets = new ArrayList[maxValue + 1];
        for (int i = 0; i <= maxValue; i++) {
            buckets[i] = new ArrayList<TShirt>();
        }
        for (int i = 0; i <= maxValue; i++) {
            for (int j = 0; j < tshirts.size(); j++) {
                switch (sortByProperty) {
                    case 1: // SIZE
                        if (i == tshirts.get(j).getSize().ordinal()) {
                            buckets[i].add(tshirts.get(j));
                        }
                        break;
                    case 2: // COLOR
                        if (i == tshirts.get(j).getColor().ordinal()) {
                            buckets[i].add(tshirts.get(j));
                        }
                        break;
                    case 3: // FABRIC
                        if (i == tshirts.get(j).getFabric().ordinal()) {
                            buckets[i].add(tshirts.get(j));
                        }
                        break;
                }
            }
        }
        if (sortType == true) {
            for (int i = 0; i <= maxValue; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    sorted_tshirts.add(buckets[i].get(j));
                }

            }
        } else {
            for (int i = maxValue; i >= 0; i--) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    sorted_tshirts.add(buckets[i].get(j));
                }

            }
        }

        return sorted_tshirts;
    }

    public static void performBucketSort(BucketSort bus, List<TShirt> shirts) {
        System.out.println("_____________Size ASC_____________");
        bucketSort(bus, shirts, true, 1);
        System.out.println("____________Size DESC_____________");
        bucketSort(bus, shirts, false, 1);
        System.out.println("____________Color ASC_____________");
        bucketSort(bus, shirts, true, 2);
        System.out.println("____________Color DESC_____________");
        bucketSort(bus, shirts, false, 2);
        System.out.println("____________Fabric ASC_____________");
        bucketSort(bus, shirts, true, 3);
        System.out.println("____________Fabric DESC_____________");
        bucketSort(bus, shirts, false, 3);
    }

    public static void bucketSort(BucketSort bus, List<TShirt> shirts, boolean sortType, int sortByProperty) {
        long startTime = 0;
        long endTime = 0;
        List<TShirt> sorted_shirts = new ArrayList<>();
        switch (sortByProperty) {
            // Size - 1
            case 1:
                startTime = System.currentTimeMillis();
                sorted_shirts = bus.sort(shirts, 6, sortType, 1);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for BUS by Size ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for BUS by Size DESC: " + (endTime - startTime));
                }
                break;
            // Color - 2
            case 2:
                startTime = System.currentTimeMillis();
                sorted_shirts = bus.sort(shirts, 6, sortType, 2);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for BUS by Color ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for BUS by Color DESC: " + (endTime - startTime));
                }
                break;
            // Fabric - 3
            case 3:
                startTime = System.currentTimeMillis();
                sorted_shirts = bus.sort(shirts, 6, sortType, 3);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for BUS by Fabric ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for BUS by Fabric DESC: " + (endTime - startTime));
                }
                break;
        }

        for (TShirt shirt : sorted_shirts) {
            System.out.println(shirt);
        }
    }

    public static void performBucketSortPerPropertyASC(BucketSort bus, List<TShirt> shirts) {

        long startTime = 0;
        long endTime = 0;

        List<List<TShirt>> subLists = new ArrayList<List<TShirt>>(); // instantiate a List of Lists!
        // step 1 - Make a BUS per Size
        startTime = System.currentTimeMillis();
        List<TShirt> shirtsBySize = bus.sort(shirts, 6, true, 1);
        // step 2 - Find which TShirts have the same Size on the sorted (previous)list
        int[] sBySize = new int[7];
        for (int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (TShirt tShirt : shirtsBySize) {
            sBySize[tShirt.getSize().ordinal()]++;
        }
    
        // step 3 - Get the ones of the same Size in a sublist
        TStruct[] allSizes = new TStruct[7];
        int counter = 0;
        for (int i = 0; i < 7; i++) {
            allSizes[i] = new TStruct();
            if (sBySize[i] == 0) {
                allSizes[i].start = -1;
                allSizes[i].end = -1;
            } else {
                allSizes[i].start = counter;
                allSizes[i].end = counter + sBySize[i];
                subLists.add(shirtsBySize.subList(allSizes[i].start, allSizes[i].end));
            }
            counter += sBySize[i];
        }
        // step 4 - Make a BUS per Color on the previous sublist
        // step 5 - Find which TShirts have the same Color on the previous sorted list 
        List<List<TShirt>> subLists1 = new ArrayList<List<TShirt>>();
        for (int i = 0; i < subLists.size(); i++) {
            List<TShirt> sortedByColor = bus.sort(subLists.get(i), 6, true, 2);
            // step 2 - Find which TShirts have the same color on the sorted (previous)list
            int[] sByColor = new int[7];
            for (int j = 0; j < 7; j++) {
                sByColor[j] = 0;
            }
            for (TShirt tShirt : sortedByColor) {
                sByColor[tShirt.getColor().ordinal()]++;
            }
            // step 3 - Get the ones of the same color in a sublist
            TStruct[] allColors = new TStruct[7];
            int counter1 = 0;
            for (int k = 0; k < 7; k++) {
                allColors[k] = new TStruct();
                if (sByColor[k] == 0) {
                    allColors[k].start = -1;
                    allColors[k].end = -1;
                } else {
                    allColors[k].start = counter1;
                    allColors[k].end = counter1 + sByColor[k];
                    subLists1.add(sortedByColor.subList(allColors[k].start, allColors[k].end));
                }
                counter1 += sByColor[k];
            }

        }
        List<List<TShirt>> subLists2 = new ArrayList<List<TShirt>>();
        for (int i = 0; i < subLists1.size(); i++) {
            List<TShirt> sortedByFabric = bus.sort(subLists1.get(i), 6, true, 3);
            // step 2 - Find which TShirts have the same fabric on the sorted (previous)list
            int[] sByFabric = new int[7];
            for (int j = 0; j < 7; j++) {
                sByFabric[j] = 0;
            }
            for (TShirt tShirt : sortedByFabric) {
                sByFabric[tShirt.getFabric().ordinal()]++;
            }
            // step 3 - Get the ones of the same fabric in a sublist
            TStruct[] allFabrics = new TStruct[7];
            int counter1 = 0;
            for (int k = 0; k < 7; k++) {
                allFabrics[k] = new TStruct();
                if (sByFabric[k] == 0) {
                    allFabrics[k].start = -1;
                    allFabrics[k].end = -1;
                } else {
                    allFabrics[k].start = counter1;
                    allFabrics[k].end = counter1 + sByFabric[k];
                    subLists2.add(sortedByFabric.subList(allFabrics[k].start, allFabrics[k].end));
                }
                counter1 += sByFabric[k];
            }
            endTime = System.currentTimeMillis();

        }

        System.out.println("_____________________Bucket Sort Per Property ASC_________________________");
        System.out.println("Time Lapsed for BUS Per Property ASC: " + (endTime - startTime));
        for (List<TShirt> shirt : subLists2) {
            for (TShirt mytshirt : shirt) {
                System.out.println(mytshirt);
            }

        }

    }

    public static void performBucketSortPerPropertyDESC(BucketSort bus, List<TShirt> shirts) {

        long startTime = 0;
        long endTime = 0;

        List<List<TShirt>> subLists = new ArrayList<List<TShirt>>(); // instantiate a List of Lists!
        // step 1 - Make a BUS per Size
        startTime = System.currentTimeMillis();
        List<TShirt> shirtsBySize = bus.sort(shirts, 6, false, 1);
        // step 2 - Find which TShirts have the same Size on the sorted (previous)list
        int[] sBySize = new int[7];
        for (int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (TShirt tShirt : shirtsBySize) {
            sBySize[tShirt.getSize().ordinal()]++;
        }
        // step 3 - Get the ones of the same Size in a sublist
        TStruct[] allSizes = new TStruct[7];
        int counter = 0;
        for (int i = 6; i >= 0; i--) {
            allSizes[i] = new TStruct();
            if (sBySize[i] == 0) {
                allSizes[i].start = -1;
                allSizes[i].end = -1;
            } else {
                allSizes[i].start = counter;
                allSizes[i].end = counter + sBySize[i];
                subLists.add(shirtsBySize.subList(allSizes[i].start, allSizes[i].end));
            }
            counter += sBySize[i];
        }
        // step 4 - Make a BUS per Color on the previous sublist
        // step 5 - Find which TShirts have the same Color on the previous sorted list 
        List<List<TShirt>> subLists1 = new ArrayList<List<TShirt>>();
        for (int i = 0; i < subLists.size(); i++) {
            List<TShirt> sortedByColor = bus.sort(subLists.get(i), 6, false, 2);
            // step 2 - Find which TShirts have the same color on the sorted (previous)list
            int[] sByColor = new int[7];
            for (int j = 0; j < 7; j++) {
                sByColor[j] = 0;
            }
            for (TShirt tShirt : sortedByColor) {
                sByColor[tShirt.getColor().ordinal()]++;
            }
            // step 3 - Get the ones of the same color in a sublist
            TStruct[] allColors = new TStruct[7];
            int counter1 = 0;
            for (int k = 6; k >= 0; k--) {
                allColors[k] = new TStruct();
                if (sByColor[k] == 0) {
                    allColors[k].start = -1;
                    allColors[k].end = -1;
                } else {
                    allColors[k].start = counter1;
                    allColors[k].end = counter1 + sByColor[k];
                    subLists1.add(sortedByColor.subList(allColors[k].start, allColors[k].end));
                }
                counter1 += sByColor[k];
            }

        }

        List<List<TShirt>> subLists2 = new ArrayList<List<TShirt>>();
        for (int i = 0; i < subLists1.size(); i++) {
            List<TShirt> sortedByFabric = bus.sort(subLists1.get(i), 6, false, 3);
            // step 2 - Find which TShirts have the same fabric on the sorted (previous)list
            int[] sByFabric = new int[7];
            for (int j = 6; j >= 0; j--) {
                sByFabric[j] = 0;
            }
            for (TShirt tShirt : sortedByFabric) {
                sByFabric[tShirt.getFabric().ordinal()]++;
            }
            // step 3 - Get the ones of the same fabric in a sublist
            TStruct[] allFabrics = new TStruct[7];
            int counter1 = 0;
            for (int k = 6; k >= 0; k--) {
                allFabrics[k] = new TStruct();
                if (sByFabric[k] == 0) {
                    allFabrics[k].start = -1;
                    allFabrics[k].end = -1;
                } else {
                    allFabrics[k].start = counter1;
                    allFabrics[k].end = counter1 + sByFabric[k];
                    subLists2.add(sortedByFabric.subList(allFabrics[k].start, allFabrics[k].end));
                }
                counter1 += sByFabric[k];
            }
            endTime = System.currentTimeMillis();
        }
        System.out.println("_____________________Bucket Sort Per Property DESC__________________________");
        System.out.println("Time Lapsed for BUS Per Property DESC: " + (endTime - startTime));
        for (List<TShirt> shirt : subLists2) {
            for (TShirt mytshirt : shirt) {
                System.out.println(mytshirt);
            }
        }

    }

}
