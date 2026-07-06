class MinStack {
    int[] stack = new int[30000];
    int top = -1;
    public MinStack() {
        for(int i = 0; i < 30000; i++) stack[i] = 0;
    }
    
    public void push(int value) {
        if(top >= stack.length) return;
        stack[++top] = value;
    }
    
    public void pop() {
        if(top == -1) return;
        top--;
    }
    
    public int top() {
        int val = stack[top];
        return val;
    }
    
    public int getMin() {
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i <= top; i++) {
            mini = Math.min(mini, stack[i]);
        }
        return mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */