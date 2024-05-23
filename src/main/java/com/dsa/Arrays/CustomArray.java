package com.dsa.Arrays;

import lombok.Data;

@Data
public class CustomArray {
    private int[] items;
    private int count;

    public CustomArray(int length){
        items = new int[length];
    }

    public void insert(int item){
        if(items.length == count){
            int[] newItems = new int[count*2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }

        items[count++] = item;
    }

    public void removeAt(int index){
        if(index < 0 || index>=count){
            throw new IllegalArgumentException("Invalid index passed");
        }
        for(int i=index;i<count-1;i++)
            items[i] = items[i+1];
        count--;
    }

    public int indexOf(int item){
        for(int i =0;i<count;i++){
            if(items[i] == item)
                return i;
        }
        return -1;
    }

    public void print(){
        for(int i=0;i<count;i++)
            System.out.println(items[i]);
    }

}
