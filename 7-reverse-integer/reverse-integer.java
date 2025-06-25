class Solution {
    public int reverse(int x) {
        int rem,temp=0;
        while(x!=0){
            rem=x%10;
            if(temp>Integer.MAX_VALUE/10 || (temp==Integer.MAX_VALUE/10 && rem>7)) return 0;
            if(temp<Integer.MIN_VALUE/10 || (temp==Integer.MIN_VALUE/10 && rem<-8)) return 0;
            temp=temp*10+rem;
            x=x/10;
        }
        

        if(temp>=Integer.MAX_VALUE || temp<=Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)temp;
        }
    }
}