public class TwoStacks {
    int[] stack = new int[6];

    int size1 = 0;
    int size2 = 0;
    int secondStart = stack.length / 2;

    public void push1(int value){
        if(isFull1()){
            var newSize = secondStart * 2 + stack.length - secondStart;
            int[] temp = new int[newSize];
            for(int i = 0; i < size1; i++)
                temp[i] = stack[i];
            secondStart = 2;
            for(int i = secondStart, j = 0; i < size2 + secondStart; i++, j++)
                temp[i] = stack[j];
            stack = temp;
        }
        stack[size1++] = value;
    }

    public void push2(int value){
        if(isFull2()){
            var newSize = secondStart *  2 + stack.length - secondStart;
            int[] temp = new int[newSize];
            for(int i = 0; i < size1; i++)
                temp[i] = stack[i];
            for(int i = secondStart; i < size2 + secondStart; i++)
                temp[i] = stack[i];
            stack = temp;
        }
        stack[secondStart + size2++] = value;
    }

    public int pop1(){
        if(isEmpty1()){
            throw new IllegalStateException();
        }
        return stack[size1--];
    }

    public int pop2(){
        if(isEmpty2()){
            throw new IllegalStateException();
        }
        return stack[size2--];
    }

    public boolean isEmpty1(){
        return size1 == 0;
    }

    public boolean isEmpty2(){
        return size2 == 0;
    }

    public boolean isFull1(){
        return size1 == secondStart;
    }

    public boolean isFull2(){
        return size2 + secondStart == stack.length;
    }

}

