class NumberPrinterSync {
    //This boolean is important.
    //Each method, (odd/even) override this boolean, causing each one kick back up.
    boolean isOdd = false;

    //Method: printEven
    //Params: The number to print.
    //Description: Used to print an even number to the console.
    synchronized void printEven(int number) {
        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println( Thread.currentThread().getName() + ": " + number);
        isOdd = false;
        notifyAll();
    }
    
    //Method: printOdd
    //Params: The number to print.
    //Description: Used to print an odd number to the console.
    synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
        isOdd = true;
        notifyAll();
    }
}
