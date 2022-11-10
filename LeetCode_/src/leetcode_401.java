class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> answer = new ArrayList<>();
        int []watch = {1,2,4,8,1,2,4,8,16,32};
        back(answer,watch,0,0,0,turnedOn);
        Collections.sort(answer);
        return answer;
    }
    public void back(List<String> list, int []watch, int curHour, int curMin, int idx, int limit){
        if(limit != 0 && idx == 10)
            return;
        else if(limit == 0){
            list.add(str(curHour,curMin));
            return;
        }
        if(idx<=3 && curHour + watch[idx] < 12){
            back(list,watch,curHour+watch[idx],curMin, idx+1, limit - 1);
        }
        else if(idx>3 && curMin + watch[idx] < 60){
            back(list,watch,curHour,curMin+watch[idx],idx+1, limit - 1);
        }
        back(list,watch,curHour,curMin,idx+1, limit);
        
    }
    public String str(int hour, int min){
        if(min<10)
            return String.valueOf(hour) + ":0" + String.valueOf(min);
        else
            return String.valueOf(hour) + ":" + String.valueOf(min);
    }
}