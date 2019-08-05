public class Solution {

    private StringBuilder sb = new StringBuilder();

    private int[] c = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        c[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++)
            if (c[sb.charAt(i)] == 1)
                return sb.charAt(i);
        return "#";
    }
}