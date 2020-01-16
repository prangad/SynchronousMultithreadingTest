public class OddEvenThreads {
    //This integer is the max number the threads will write to.
    private static int _UPPERBOUND = 100;
    
    public static void main(String... args) {
        //Instantiate a new synchronous number printer class.
        NumberPrinterSync numberPrinter = new NumberPrinterSync();
        //Instantiate two new threads, t1, t2, set their task to the PrintNumberSet task.
        //Params: Printer to handle printing, int maximum number, boolean even number
        Thread t1 = new Thread(new PrintNumberSet(numberPrinter, _UPPERBOUND, false));
        Thread t2 = new Thread(new PrintNumberSet(numberPrinter, _UPPERBOUND, true));
        //Set referential names for each thread, used in printing.
        t1.setName("THREAD_1");
        t2.setName("THREAD_2");
        //Start two threads, t1, t2.
        t1.start();
        t2.start();
    }
}