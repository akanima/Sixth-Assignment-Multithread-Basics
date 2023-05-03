package sbu.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    For this exercise, you must simulate a CPU with a single core.
    You will receive an arraylist of tasks as input. Each task has a processing
    time which is the time it needs to run in order to fully execute.

    The CPU must choose the task with the shortest processing time and create
    a new thread for it. The main thread should wait for the task to fully
    execute and then join with it, before starting the next task.

    Once a task is fully executed, add its ID to the executed tasks arraylist.
    Use the tests provided in the test folder to ensure your code works correctly.
 */

public class CPU_Simulator
{
    public static class Task implements Runnable {
        long processingTime;
        String ID;
        public Task(String ID, long processingTime) {
            this.processingTime=processingTime;
            this.ID=ID;
        // TODO
        }
        public long getProcessingTime(){
            return this.processingTime;
        }
        public String getID(){
            return this.ID;
        }
    /*
        Simulate running a task by utilizing the sleep method for the duration of
        the task's processingTime. The processing time is given in milliseconds.
    */
        @Override
        public void run() {
        // TODO
        }
    }

    /*
        The startProcessing function should be called at the start of your program.
        Here the CPU selects the next shortest task to run (also known as the
        shortest task first scheduling algorithm) and creates a thread for it to run.
    */
    public ArrayList<String> startSimulation(ArrayList<Task> tasks) {
        ArrayList<String> executedTasks = new ArrayList<>();
        for(int i=0; i<tasks.size();i++) {
            for (int j=tasks.size()-1;j>i;j--){
                Task task=new Task(tasks.get(i).getID(),tasks.get(i).getProcessingTime());
                Thread t=new Thread(task);
                t.start();
                try{
                    t.join();
                }
                catch (InterruptedException exception){
                    throw new RuntimeException(exception);
                }
                finally {
                    if(tasks.get(i).getProcessingTime()>tasks.get(j).getProcessingTime()){
                        Task tmp=tasks.get(i);
                        tasks.set(i,tasks.get(j));
                        tasks.set(j,tmp);
                    }
                }
            }
        }
        for(int i=0 ; i<tasks.size();i++){
            executedTasks.add(tasks.get(i).getID());
        }
        // TODO

        return executedTasks;
    }

    public static void main(String[] args) {
    }
}
