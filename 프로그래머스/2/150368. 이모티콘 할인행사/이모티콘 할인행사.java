class Solution {
    
    static int MAX_PRICE = 0;
    static int MAX_USER = 0;
    static int[] discountRate;
    
    public int[] solution(int[][] users, int[] emoticons) {
       
        discountRate = new int[emoticons.length];
        
        setDiscountRate(0, users, emoticons);
        
        return new int[] {MAX_USER, MAX_PRICE};
    }
    
    private void setDiscountRate(int depth, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            calcPrice(users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            discountRate[depth] = i;
            setDiscountRate(depth + 1, users, emoticons);
        }
    }
    
    private void calcPrice(int[][] users, int[] emoticons) {
        
        int emoticonPlus = 0;
        int emoticonPrice = 0;
        
        for (int[] user : users) {
            int price = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (discountRate[i] >= user[0]) {
                    price += emoticons[i] * (100 - discountRate[i]) / 100;
                }
            }
            
            if (price >= user[1]) emoticonPlus++;
            else emoticonPrice += price;
        }
        
        if (emoticonPlus > MAX_USER) {
            MAX_USER = emoticonPlus;
            MAX_PRICE = emoticonPrice;
        } else if (emoticonPlus == MAX_USER && emoticonPrice >= MAX_PRICE) {
            MAX_PRICE = emoticonPrice;
        }
    }
}