package SwordOffer;


// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class S2_ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        char[] strArray = string.toCharArray();
        int spaceSize = 0;
        for (int i = 0; i < strArray.length; i ++){
            if (strArray[i] == ' '){
                spaceSize ++;
            }
        }

        int n = strArray.length;
        int newCapacity = n + spaceSize * 2;
        char[] newStrArray = new char[newCapacity];
        int i = 0;
        int j = 0;
        while (i < n){
            if (strArray[i] == ' '){
                newStrArray[j++] = '%';
                newStrArray[j++] = '2';
                newStrArray[j++] = '0';
                i++;
            }else{
                newStrArray[j++] = strArray[i++];
            }
        }

        return new String(newStrArray);
    }

    public static void main(String[] args) {
        String str = "Hello word";
        StringBuffer sb = new StringBuffer(str);
        S2_ReplaceSpace s2 = new S2_ReplaceSpace();
        String newStr = s2.replaceSpace(sb);
        System.out.println(newStr);
    }
}
