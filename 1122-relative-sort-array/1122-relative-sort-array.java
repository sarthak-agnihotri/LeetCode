class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num: arr1){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        int[] result=new int[arr1.length];
        int index=0;
        for(int num:arr2){
            if(map.containsKey(num)){
                int count=map.get(num);
                while(count>0){
                    result[index++]=num;
                    count--;
                }
                map.remove(num);
            }
        }
        ArrayList<Integer>remaining=new ArrayList<>();
        for(int key:map.keySet()){
            int count=map.get(key);
            while(count>0){
                remaining.add(key);
                count--;
            }
        }
        Collections.sort(remaining);
        for(int num: remaining){
            result[index++]=num;
        }
        return result;
    }
}