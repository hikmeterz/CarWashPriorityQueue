public class Heap {

    public static class InvalidSpaceException extends Exception{
        public InvalidSpaceException(String e){
                super(e);
            }
    }
    private int[] heap;
    private int size;

    public Heap(int capacity){
        this.size = 0;
        this.heap = new int[capacity];
    }

    public boolean isFull(){
        return heap.length == size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getParent(int index){
        return (index-1)/2;
    }

    public void insert(int value) throws InvalidSpaceException {
        if(isFull())
            throw new InvalidSpaceException("The heap is full!");
        else{
            heap[size] = value;
            heapify(size);
            size++;
        }
    }
    private void heapify(int index){
        int temp = heap[index];

        while(index > 0 && temp < heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = temp;
    }

    public String printHeap(){
        String tmp = "";
        for(int a = 0; a<size;a++){
            tmp = tmp + " " + heap[a];
        }
        return tmp;
    }

    public int getMin() throws InvalidSpaceException {
        if(isEmpty())
            throw new InvalidSpaceException("The heap is empty!");
        else
            return heap[0];
    }

    public int remove(int x) throws InvalidSpaceException {
        if(isEmpty())
            throw new InvalidSpaceException("The heap is empty!");
        int temp = heap[x];
        heap[x] = heap[size-1];
        size--;
        downHeapify(x);
        return temp;
    }

    private void downHeapify(int index){
        int child;
        int tmp = heap[index];
        while(2*index+1< size){
            child = minChild(index);
            if(tmp > heap[child]){
                heap[index] = heap[child];
            }
            else
                break;
            index = child;
        }
        heap[index] = tmp;
    }

    private int minChild(int index){
        int left = 2*index+1;
        int right = 2*index+2;
        if(heap[left]<heap[right])
            return left;
        else
            return right;
    }

    public int getSize() {
    	
    	return size;
    	
    }
}