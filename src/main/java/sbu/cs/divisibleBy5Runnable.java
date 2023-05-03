package sbu.cs;

public class divisibleBy5Runnable implements Runnable{
    int No;
    FindMultiples findMultiples=new FindMultiples();
    public divisibleBy5Runnable(int No, FindMultiples findMultiples){
        this.No=No;
        this.findMultiples=findMultiples;
    }
    @Override
    public void run() {
        if(No>=5){
            for(int i=5; i<=No; i=i+5) {
                findMultiples.divisors.add(i);
            }
        }
    }
}
