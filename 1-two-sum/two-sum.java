class Solution {
    public int[] twoSum(int[] nums, int target) {
        

       /* for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        */
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        int more=target-nums[i];
        if(map.containsKey(more)){
         return new int[]{map.get(more),i};
        }else{
            map.put(nums[i],i);
        }


       }
       return new int[]{};
    
        

       
    }
}