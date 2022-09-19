class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>>hm = new HashMap<>();
        int n = paths.length;
        List<List<String>> ans = new ArrayList<>();
        if(n == 0)return ans;
        for(String s : paths){
            String temp[] = s.split("\\s+");
            String first = temp[0];
            for(int i=1; i<temp.length;i++){
                int s_index =0;
                int e_index =0;
                for(int j=0;j<temp[i].length();j++){
                    char c = temp[i].charAt(j);
                    if(c == '('){
                        s_index = j;
                    }if(c == ')'){
                        e_index = j;
                    }
                }
                String key = temp[i].substring(s_index+1, e_index);
                String value = temp[i].substring(0, s_index);
                if(!hm.containsKey(key)){
                    hm.put(key, new ArrayList<>());
                }hm.get(key).add(first+"/"+value);
              
                                
            }
        }
        for(String i : hm.keySet()){
            
           // System.out.println(i);
            if(hm.get(i).size()>=2){
                ans.add(new ArrayList<>(hm.get(i)));
            }
            
        }
        return ans;
        
    }
}
//["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]