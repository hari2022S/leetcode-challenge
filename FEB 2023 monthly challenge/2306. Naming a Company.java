//Input: ideas = ["coffee","donuts","time","toffee"]
//Output: 6
class Solution {
    public long distinctNames(String[] ideas) {

        // for storing first char of each word
        HashSet<String> arr[] = new HashSet[26];

        for(int i = 0; i < 26; i++){
            arr[i] = new HashSet<>(); // every location of i adding a new hashset
        }

        for(int i = 0; i < ideas.length; i++){
            int location = ideas[i].charAt(0)-'a'; // finding asc value of each word of first letter in ideas array
            String suffix = ideas[i].substring(1);
            arr[location].add(suffix);// adding remaing letter of word of first char location
        }

       /* hash set arr looks like
        location ---> suffix

        c        ---> offee
        d        ---> onuts
        t        ---> ime , offee    */

        long ans = 0;
        for(int i = 0; i < 26; i++){
            for(int j = i+1; j < 26; j++){
                int tempans = 0;
                for(String str : arr[i]){
                    if(arr[j].contains(str))// if 2nd set contains same word my ans become 0
                    tempans++;
                }
                // if two sets contains different word then my ans will become double of sizes multiplication
                ans = ans + 2*(arr[i].size()-tempans)*(arr[j].size()-tempans);
            }
        }

        return ans;
    }
}
