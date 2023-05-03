package sbu.cs;

public class divisibleBy3Runnable implements Runnable{
    int No;
    FindMultiples findMultiples=new FindMultiples();
    public divisibleBy3Runnable(int No, FindMultiples findMultiples){
        this.No=No;
        this.findMultiples=findMultiples;
    }
    @Override
    public void run() {
        if(No>=3){
            for(int i=3; i<=No; i=i+3) {
                findMultiples.divisors.add(i);
            }
        }
    }
}
