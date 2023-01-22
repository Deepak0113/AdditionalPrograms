package datastructures;

class ArrayEmptyException extends Exception{
    ArrayEmptyException(){
        super("Empty datastructures.ArrayList");
    }
}

public class ArrayList {
    // default size 5
    private int[] array = new int[5];
    private int size = 0;


    // add
    void add(int value){
        if (size >= array.length) {
            int[] temp = array.clone();
            array = new int[temp.length + 5];

            for (int i = 0; i < size; i++) {
                array[i] = temp[i];
            }
        }

        array[size] = value;
        size++;
    }

    // delete
    void delete(int value) throws ArrayEmptyException {
        if(size == 0)
            throw new ArrayEmptyException();
        if(size%5 == 1){
            int[] temp = array.clone();
            array = new int[size-1];
            for(int i=0; i<size-1; i++){
                array[i] = temp[i];
            }
        }
        for(int i=0; i<size; i++){
            if(array[i] == value){

            }
        }
        size--;
    }

    // display
    public String toString(){
        String string = "[";
        for(int i=0; i<size-1; i++){
            string += array[i]+", ";
        }
        string += array[size-1]+"]";
        return string;
    }

    // size
    int getSize(){
        return size;
    }
}
