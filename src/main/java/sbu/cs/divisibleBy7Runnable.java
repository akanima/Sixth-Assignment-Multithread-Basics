package sbu.cs;

public class divisibleBy7Runnable implements Runnable{
    int No;
    FindMultiples findMultiples=new FindMultiples();
    public divisibleBy7Runnable(int No, FindMultiples findMultiples){
        this.No=No;
        this.findMultiples=findMultiples;
    }
    @Override
    public void run() {
        if(No>=7){
            for(int i=7; i<=No; i=i+7) {
                findMultiples.divisors.add(i);
            }
        }
    }
}
