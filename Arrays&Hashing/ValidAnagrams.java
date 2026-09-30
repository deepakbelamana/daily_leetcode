class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] charF = new int[26];

        for(char c : s.toCharArray()) {
            int intVal = c-'a';
            charF[intVal]+=1;
        }

        for(char c : t.toCharArray()) {
            int intVal = c-'a';
            if(charF[intVal]>0){
                charF[intVal]-=1;
            } else {
                charF[intVal]+=1;
            }
        }
        for(int f : charF) {
            if(f!=0){
                return false;
            }
        }

        return true;
    }
}