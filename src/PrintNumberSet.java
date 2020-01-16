//Method: PrintNumberSet
//Implements: Runnable
//Description: This method defines a maximum number, and uses two threads
//to print from 1 to the specified upper bound.
class PrintNumberSet implements Runnable {

    private int max;
    private NumberPrinterSync numberPrinter;
    private boolean isEvenNumber;

    PrintNumberSet(NumberPrinterSync print, int max, boolean isEvenNumber) {
        this.numberPrinter = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        //If the number is even, number = 2. Else, number = 1.
        //Note: number is the starting number.
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                numberPrinter.printEven(number);
            } else {
                numberPrinter.printOdd(number);
            }
            number += 2;
        }
    }
}