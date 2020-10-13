package tshirtsort.sorting;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;

public class BubbleSort {

    // boolean sortType, sortType == true, ASC --  sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    public List<TShirt> sort(List<TShirt> arr, boolean sortType, int sortByProperty) {

        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                switch (sortByProperty) {
                    // Size - 1
                    case 1:
                        // ASC
                        if (sortType) {
                            if (arr.get(j).getSize().ordinal() > arr.get(j + 1).getSize().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        } else { // DESC
                            if (arr.get(j).getSize().ordinal() < arr.get(j + 1).getSize().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        }

                        break;
                    // Color - 2    
                    case 2:
                        // ASC
                        if (sortType) {
                            if (arr.get(j).getColor().ordinal() > arr.get(j + 1).getColor().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        } else { // DESC
                            if (arr.get(j).getColor().ordinal() < arr.get(j + 1).getColor().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        }
                        break;
                    // Fabric - 3
                    case 3:
                        // ASC
                        if (sortType) {
                            if (arr.get(j).getFabric().ordinal() > arr.get(j + 1).getFabric().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        } else { // DESC
                            if (arr.get(j).getFabric().ordinal() < arr.get(j + 1).getFabric().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        }
                        break;
                }
            }
        }
        return arr;

    }

    private static void bubbleSort(BubbleSort bs, List<TShirt> shirts, boolean sortType, int sortByProperty) {

        long startTime = 0;
        long endTime = 0;
        switch (sortByProperty) {
            // Size - 1
            case 1:
                startTime = System.currentTimeMillis();
                bs.sort(shirts, sortType, 1);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for BS by Size ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for BS by Size DESC: " + (endTime - startTime));
                }
                break;
            // Color - 2
            case 2:
                startTime = System.currentTimeMillis();
                bs.sort(shirts, sortType, 2);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for BS by Color ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for BS by Color DESC: " + (endTime - startTime));
                }
                break;
            // Fabric - 3
            case 3:
                startTime = System.currentTimeMillis();
                bs.sort(shirts, sortType, 3);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for BS by Fabric ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for BS by Fabric DESC: " + (endTime - startTime));
                }
                break;
        }

        for (TShirt shirt : shirts) {
            System.out.println(shirt);
        }
    }

    public static void performBubbleSort(BubbleSort bs, List<TShirt> shirts) {
        System.out.println("_____________Size ASC_____________");
        bubbleSort(bs, shirts, true, 1);
        System.out.println("____________Size DESC_____________");
        bubbleSort(bs, shirts, false, 1);
        System.out.println("____________Color ASC_____________");
        bubbleSort(bs, shirts, true, 2);
        System.out.println("____________Color DESC_____________");
        bubbleSort(bs, shirts, false, 2);
        System.out.println("____________Fabric ASC_____________");
        bubbleSort(bs, shirts, true, 3);
        System.out.println("____________Fabric DESC_____________");
        bubbleSort(bs, shirts, false, 3);
    }

    public static void performBubbleSortPerPropertyASC(BubbleSort bs, List<TShirt> shirts) {

        long startTime = 0;
        long endTime = 0;

        List<List<TShirt>> subLists = new ArrayList<List<TShirt>>(); // instantiate a List of Lists!
        startTime = System.currentTimeMillis();
        List<TShirt> shirtsBySize = bs.sort(shirts, true, 1);

        int[] sBySize = new int[7];
        for (int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (TShirt tShirt : shirtsBySize) {
            sBySize[tShirt.getSize().ordinal()]++;
        }

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
                subLists.add(shirtsBySize.subList(allSizes[i].start, allSizes[i].end)); // this line isn't correct we need to correct it
            }
            counter += sBySize[i];
        }

        List<List<TShirt>> subLists1 = new ArrayList<List<TShirt>>();
        for (int i = 0; i < subLists.size(); i++) {
            List<TShirt> sortedByColor = bs.sort(subLists.get(i), true, 2);

            int[] sByColor = new int[7];
            for (int j = 0; j < 7; j++) {
                sByColor[j] = 0;
            }
            for (TShirt tShirt : sortedByColor) {
                sByColor[tShirt.getColor().ordinal()]++;
            }

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
            List<TShirt> sortedByFabric = bs.sort(subLists1.get(i), true, 3);

            int[] sByFabric = new int[7];
            for (int j = 0; j < 7; j++) {
                sByFabric[j] = 0;
            }
            for (TShirt tShirt : sortedByFabric) {
                sByFabric[tShirt.getFabric().ordinal()]++;
            }

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
        System.out.println("_________________Bubble Sort Per Property ASC__________________________");
        System.out.println("Time Lapsed for BS Per Property ASC: " + (endTime - startTime));
        for (List<TShirt> shirt : subLists2) {
            for (TShirt mytshirt : shirt) {
                System.out.println(mytshirt);
            }
        }

    }

    public static void performBubbleSortPerPropertyDESC(BubbleSort bs, List<TShirt> shirts) {

        long startTime = 0;
        long endTime = 0;

        List<List<TShirt>> subLists = new ArrayList<List<TShirt>>();
        startTime = System.currentTimeMillis();

        List<TShirt> shirtsBySize = bs.sort(shirts, false, 1);

        int[] sBySize = new int[7];
        for (int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (TShirt tShirt : shirtsBySize) {
            sBySize[tShirt.getSize().ordinal()]++;
        }

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

        List<List<TShirt>> subLists1 = new ArrayList<List<TShirt>>();
        for (int i = 0; i < subLists.size(); i++) {
            List<TShirt> sortedByColor = bs.sort(subLists.get(i), false, 2);

            int[] sByColor = new int[7];
            for (int j = 0; j < 7; j++) {
                sByColor[j] = 0;
            }
            for (TShirt tShirt : sortedByColor) {
                sByColor[tShirt.getColor().ordinal()]++;
            }

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
            List<TShirt> sortedByFabric = bs.sort(subLists1.get(i), false, 3);

            int[] sByFabric = new int[7];
            for (int j = 6; j >= 0; j--) {
                sByFabric[j] = 0;
            }
            for (TShirt tShirt : sortedByFabric) {
                sByFabric[tShirt.getFabric().ordinal()]++;
            }

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
        System.out.println("_________________Bubble Sort Per Property DESC__________________________");
        System.out.println("Time Lapsed for BS Per Property DESC: " + (endTime - startTime));
        for (List<TShirt> shirt : subLists2) {
            for (TShirt mytshirt : shirt) {
                System.out.println(mytshirt);
            }
        }
    }

}
