class Solution {
    public int solution(int price) {
        
        double discount = 1.0;
        
        if(price >= 500000) discount = 0.8;
        else if(price >= 300000) discount = 0.9;
        else if(price >= 100000) discount = 0.95;
        
        return (int) (price * discount);
    }
}