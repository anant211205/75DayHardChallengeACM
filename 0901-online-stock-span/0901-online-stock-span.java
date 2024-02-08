class StockSpanner {
    Stack<Integer> stSpan ;
    Stack<Integer> prices ;
    public StockSpanner() {
        
    stSpan = new Stack<>() ;
    prices = new Stack<>() ;

    }
    
    public int next(int price) {
        int span = 1 ;

        while(!prices.isEmpty() && price >= prices.peek()){

            span += stSpan.pop() ;
            prices.pop() ;
        }

        prices.push(price) ;
        stSpan.push(span) ;

        return span ;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */