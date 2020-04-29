package com.crazykulou;

public class FinalPool {

    public static void main(String[] args) {
        //这里改成Integer integerA = new Integer(12)会对最终结果有影响，后面会说明
        Integer integerA = 12;
        Integer integerB = 12;
        System.out.println("integerA="+integerA+",integerB="+integerB);
        if(integerA == integerB){
            System.out.println("integerA == integerB");
        }else {
            System.out.println("integerA != integerB");
        }

        if(integerA.equals(integerB)){
            System.out.println("integerA equals integerB");
        }else {
            System.out.println("integerA not equals integerB");
        }
    }
}
