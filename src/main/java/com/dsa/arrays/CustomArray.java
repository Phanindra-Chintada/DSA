package com.dsa.arrays;

import lombok.Data;

@Data
public class CustomArray {
    private int[] items;
    private int count;

    public CustomArray(int length){
        items = new int[length];
    }

    // O(n)
    public void insert(int item){
        if(items.length == count){
            int[] newItems = new int[count*2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }

        items[count++] = item;
    }

    // O(n)
    public void removeAt(int index){
        if(index < 0 || index>=count){
            throw new IllegalArgumentException("Invalid index passed");
        }
        for(int i=index;i<count-1;i++)
            items[i] = items[i+1];
        count--;
    }

    // O(n)
    public int indexOf(int item){
        for(int i =0;i<count;i++){
            if(items[i] == item)
                return i;
        }
        return -1;
    }

    // O(n)
    public int max(){
        int max = 0;
        for(int i:items){
            if(i>max) max = i;
        }
        return max;
    }

    public CustomArray intersect(CustomArray array2){
        CustomArray newArray = new CustomArray(items.length);
        for (int item : items) {
            for (int j : array2.items) {
                if (j == item) {
                    if(newArray.indexOf(j) == -1) newArray.insert(j);
                }
            }
        }
        return newArray;
    }

    public void reverse(){
        int[] newArray = new int[items.length];
        int i = items.length-1;
        int c = 0;
        while(i>=0){
            newArray[c++] = items[i];
            i--;
        }
        items = newArray;
    }

    public void insertAt(int item, int index){
        if(index>items.length){
            throw new IllegalArgumentException("Please enter index less than "+ items.length);
        }
        int[] newItems = new int[items.length+1];
        int i = 0;
        int c= 0;
        while(c<=items.length){
            newItems[c] = c==index? item : items[i++];
            c++;
        }
        items = newItems;
    }

    public void print(){
        for (int item : items) System.out.println(item);
    }

}
