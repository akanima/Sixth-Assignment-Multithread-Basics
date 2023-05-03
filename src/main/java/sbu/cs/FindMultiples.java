package sbu.cs;

/*
    In this exercise, you must write a multithreaded program that finds all
    integers in the range [1, n] that are divisible by 3, 5, or 7. Return the
    sum of all unique integers as your answer.
    Note that an integer such as 15 (which is a multiple of 3 and 5) is only
    counted once.

    The Positive integer n > 0 is given to you as input. Create as many threads as
    you need to solve the problem. You can use a Thread Pool for bonus points.

    Example:
    Input: n = 10
    Output: sum = 40
    Explanation: Numbers in the range [1, 10] that are divisible by 3, 5, or 7 are:
    3, 5, 6, 7, 9, 10. The sum of these numbers is 40.

    Use the tests provided in the test folder to ensure your code works correctly.
 */

import java.util.ArrayList;
public class FindMultiples
{

    // TODO create the required multithreading class/classes using your preferred method.


    /*
    The getSum function should be called at the start of your program.
    New Threads and tasks should be created here.
    */
    static ArrayList<Integer> divisors=new ArrayList<>();
    public static ArrayList removingDuplicates(ArrayList<Integer> divisors){
        ArrayList<Integer> x=new ArrayList<>();
        for(int i=0 ; i<divisors.size();i++){
            if(!x.contains(divisors.get(i))){
                x.add(divisors.get(i));
            }
        }
        return x;
    }
    public static int calculatingSum(ArrayList<Integer> divisorsWithoutDuplicateElements){
        int sum=0;
        for(int i=0 ; i<divisorsWithoutDuplicateElements.size();i++){
            sum=sum+divisorsWithoutDuplicateElements.get(i);
        }
        return sum;
    }
    public int getSum(int n) {
        FindMultiples findMultiples=new FindMultiples();
        int sum = 0;
        divisibleBy3Runnable d3=new divisibleBy3Runnable(n,findMultiples);
        divisibleBy5Runnable d5=new divisibleBy5Runnable(n,findMultiples);
        divisibleBy7Runnable d7=new divisibleBy7Runnable(n,findMultiples);
        Thread a=new Thread(d3);
        Thread b=new Thread(d5);
        Thread c=new Thread(d7);
        try{
            a.start();
            a.join();
            b.start();
            b.join();
            c.start();
            c.join();
        }
        catch (InterruptedException e){}
        ArrayList<Integer> withoutDuplicates=removingDuplicates(divisors);
        sum=calculatingSum(withoutDuplicates);
        // TODO
        return sum;
    }
    public class divisibleBy3Runnable implements Runnable{
        int No;
        FindMultiples findMultiples=new FindMultiples();
        public divisibleBy3Runnable(int No, FindMultiples findMultiples){
            this.No=No;
            this.findMultiples=findMultiples;
        }
        @Override
        public void run() {
            try{
                if(No>=3){
                    for(int i=3; i<=No; i=i+3) {
                        divisors.add(i);
                        Thread.sleep(1);
                    }
                }
            }
            catch (InterruptedException e){

            }
        }
    }
    public static void main(String[] args) {
    }
}
