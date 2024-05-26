package com.dsa.linkedList;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item){
        var node = new Node(item);
        if(Objects.isNull(first))
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item){
        var node = new Node(item);
        if(Objects.isNull(first))
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item){
        int index = 0;
        var current = first;
        while(Objects.nonNull(current)){
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst(){

        if(Objects.isNull(first)){
            throw new NoSuchElementException();
        }

        if(first == last){
            first = last = null;
            size = 0;
        }

        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast(){
        //[10->20->30]
        if(Objects.isNull(first)){
            throw new NoSuchElementException();
        }

        if(first == last){
            first = last = null;
            size = 0;
        }

        var current = first;
        while (Objects.nonNull(current)){
            if(current.next == last) break;
            current = current.next;
        }

        last = current;
        last.next = null;
        size--;
    }

    public int size(){
//        int size = 1;
//        var current = first;
//        while (Objects.nonNull(current)){
//            if(current == last) break;
//            current = current.next;
//            size++;
//        }
//        return size;
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while (Objects.nonNull(current)){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        //[10->20->30]
//          p   c   n
        //      p   c   n
        //          p   c   n
        if(first != null && first!=last){
            var previous = first;
            var current = first.next;
            while (current!=null){
                var next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            last = first;
            last.next = null;
            first = previous;
        }
    }

    public int kthNodeFromEnd(int k){
        if(k==0 || k>size || first == null){
            throw new IllegalArgumentException("Please enter a value greater than 1 and less than max size of the linked list");
        }
        int distance = size-k;
        int element = 0;
        var current = first;
        for(int i =0; i<=distance;i++){
            element = current.value;
            current = current.next;
        }
        return element;

    }

    public int[] middleNodes(){
        if(first == null){
            throw new IllegalStateException("No elements found the linkedlist");
        }
        int[] middle;

        //if size is known

//        var current = first;
//        for (int i=0;i<(size-1)/2; i++){
//            current = current.next;
//        }
//        if(size%2 == 0){
//            middle = new int[] {current.value, current.next.value};
//        }else{
//            middle = new int[] {current.value};
//        }

        //if size is not known
        var a = first;
        var b = first;
        while(b!=last && b.next!=last){
            b = b.next.next;
            a = a.next;
        }
        if(b == last){
            middle = new int[] {a.value};
        }else{
            middle = new int[] {a.value, a.next.value};
        }
        return middle;
    }

}


/*
Runtime Complexities
LookUp
    By Index O(1)
    By Value O(n)

Insert
    Beginning/End O(1)
    Middle O(n)

Delete
    Beginning O(1)
    Middle O(n)
    End O(n) / O(1) (if cyclic)
 */