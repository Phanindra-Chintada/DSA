package com.dsa.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CustomStack<T> {

    private static final List<Character> openingBrackets = List.of('(','<','[','{');
    private static final List<Character> closingBrackets = List.of(')', '>', ']', '}');

    private List<T> list = new ArrayList<>();

    public List<T> push(T item){
        list.addLast(item);
        return list;
    }

    public T pop(){
        if(list.isEmpty()) throw new IllegalStateException("No Elements present in the stack");
        return list.remove(list.size()-1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public T peek(){
        return list.get(list.size()-1);
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public static String reverseString(String item){
        Stack<String> stringStack = new Stack<>();
        for(char c: item.toCharArray()){
            stringStack.push(String.valueOf(c));
        }
        StringBuilder revString = new StringBuilder();
        int size = stringStack.size();
        while (!stringStack.empty()){
            revString.append(stringStack.pop());
        }
        return revString.toString();
    }

    public static boolean isBalancedString(String item){

        Stack<Character> characterStack = new Stack<>();
        for (Character c: item.toCharArray()){
            if(isOpeningBracket(c))
                characterStack.push(c);
            else if (isClosingBracket(c)){
                if(characterStack.empty()) return false;
                var top = characterStack.pop();
                if(!bracketsMatch(c, top))
                    return false;
            }
        }
        return characterStack.empty();
    }

    private static boolean bracketsMatch(Character c, Character top) {
        return openingBrackets.indexOf(top) == closingBrackets.indexOf(c);
    }

    private static boolean isClosingBracket(Character c) {
        return closingBrackets.contains(c);
    }

    private static boolean isOpeningBracket(Character c) {
        return openingBrackets.contains(c);
    }
}
