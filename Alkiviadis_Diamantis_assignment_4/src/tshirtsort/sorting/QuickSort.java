package tshirtsort.sorting;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;

public class QuickSort {

    // boolean sortType, sortType == true, ASC --  sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    public List<TShirt> sort(List<TShirt> arr, int low, int high, boolean sortType, int sortByProperty) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high, sortType, sortByProperty);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi - 1, sortType, sortByProperty);
            sort(arr, pi + 1, high, sortType, sortByProperty);
        }
        return arr;
    }

    // boolean sortType, sortType == true, ASC --  sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    int partition(List<TShirt> arr, int low, int high, boolean sortType, int sortByProperty) {
        TShirt pivot = arr.get(high);
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot 
            switch (sortByProperty) {
                // Size
                case 1:
                    if (sortType) {
                        if (arr.get(j).getSize().ordinal() < pivot.getSize().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getSize().ordinal() > pivot.getSize().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
                // Color
                case 2:
                    if (sortType) {
                        if (arr.get(j).getColor().ordinal() < pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getColor().ordinal() > pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
                // Fabric
                case 3:
                    if (sortType) {
                        if (arr.get(j).getFabric().ordinal() < pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getFabric().ordinal() > pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
            }

        }

        // swap arr[i+1] and arr[high] (or pivot) 
        TShirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    public static void performQuickSort(QuickSort qs, List<TShirt> shirts) {
        System.out.println("_____________Size ASC_____________");
        quickSort(qs, shirts, true, 1); // Size ASC
        System.out.println("____________Size DESC_____________");
        quickSort(qs, shirts, false, 1); // Size DESC
        System.out.println("____________Color ASC_____________");
        quickSort(qs, shirts, true, 2); // Color ASC
        System.out.println("____________Color DESC_____________");
        quickSort(qs, shirts, false, 2); // Color DESC
        System.out.println("____________Fabric ASC_____________");
        quickSort(qs, shirts, true, 3); // Fabric ASC
        System.out.println("____________Fabric DESC_____________");
        quickSort(qs, shirts, false, 3); // Fabric DESC

    }

    public static void quickSort(QuickSort qs, List<TShirt> shirts, boolean sortType, int sortByProperty) {

        long startTime = 0;
        long endTime = 0;
        switch (sortByProperty) {
            // Size - 1
            case 1:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, sortType, 1);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for QS by Size ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for QS by Size DESC: " + (endTime - startTime));
                }
                break;
            // Color - 2
            case 2:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, sortType, 2);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for QS by Color ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for QS by Color DESC: " + (endTime - startTime));
                }
                break;
            // Fabric - 3
            case 3:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, sortType, 3);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for QS by Fabric ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for QS by Fabric DESC: " + (endTime - startTime));
                }
                break;
        }

        for (TShirt shirt : shirts) {
            System.out.println(shirt);
        }
    }

    public static void performQuickSortPerPropertyASC(QuickSort qs, List<TShirt> shirts) {

        long startTime = 0;
        long endTime = 0;

        List<List<TShirt>> subLists = new ArrayList<List<TShirt>>();
        startTime = System.currentTimeMillis();
        List<TShirt> shirtsBySize = qs.sort(shirts, 0, shirts.size() - 1, true, 1);

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
                subLists.add(shirtsBySize.subList(allSizes[i].start, allSizes[i].end));
            }
            counter += sBySize[i];
        }

        List<List<TShirt>> subLists1 = new ArrayList<List<TShirt>>();
        for (int i = 0; i < subLists.size(); i++) {
            List<TShirt> sortedByColor = qs.sort(subLists.get(i), 0, subLists.get(i).size() - 1, true, 2);

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
            List<TShirt> sortedByFabric = qs.sort(subLists1.get(i), 0, subLists1.get(i).size() - 1, true, 3);

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
        System.out.println("_____________________Quick Sort Per Property ASC_________________________");
        System.out.println("Time Lapsed for QS Per Property ASC: " + (endTime - startTime));
        for (List<TShirt> shirt : subLists2) {
            for (TShirt mytshirt : shirt) {
                System.out.println(mytshirt);
            }

        }
    }

    public static void performQuickSortPerPropertyDESC(QuickSort qs, List<TShirt> shirts) {

        long startTime = 0;
        long endTime = 0;

        List<List<TShirt>> subLists = new ArrayList<List<TShirt>>();
        startTime = System.currentTimeMillis();

        List<TShirt> shirtsBySize = qs.sort(shirts, 0, shirts.size() - 1, false, 1);

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
            List<TShirt> sortedByColor = qs.sort(subLists.get(i), 0, subLists.get(i).size() - 1, false, 2);

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
            List<TShirt> sortedByFabric = qs.sort(subLists1.get(i), 0, subLists1.get(i).size() - 1, false, 3);

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
        System.out.println("_________________Quick Sort Per Property DESC__________________________");
        System.out.println("Time Lapsed for QS Per Property DESC: " + (endTime - startTime));
        for (List<TShirt> shirt : subLists2) {
            for (TShirt mytshirt : shirt) {
                System.out.println(mytshirt);
            }
        }
    }

}
