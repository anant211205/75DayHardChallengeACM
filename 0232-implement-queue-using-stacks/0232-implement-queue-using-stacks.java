class MyQueue {

    public void pushAtBottom(int data , Stack<Integer> st){
        if(st.isEmpty()){
            st.push(data) ;
            return ;
        }

        int top = st.pop() ;
        pushAtBottom(data , st) ;
        st.push(top) ;
    }

    Stack<Integer> st = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        pushAtBottom(x , st) ;
    }
    
    public int pop() {
        return st.pop() ;
    }
    
    public int peek() {
        return st.peek() ;
    }
    
    public boolean empty() {
        if(st.size() == 0) return true ;

        return false ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */