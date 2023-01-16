class ArrayEmptyException extends Exception{
    ArrayEmptyException(){
        super("Empty ArrayList");
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
    void delete(){
        try{
            if(size == 0)
                throw new ArrayEmptyException();
            if(size%5 == 1){
                int[] temp = array.clone();
                array = new int[size-1];
                for(int i=0; i<size-1; i++){
                    array[i] = temp[i];
                }
            }
            size--;
        } catch(ArrayEmptyException aee){
            System.out.println(aee);
        }
    }

    // display
    void display(){
        for(int i=0; i<size; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    // size
    int getSize(){
        return size;
    }
}
