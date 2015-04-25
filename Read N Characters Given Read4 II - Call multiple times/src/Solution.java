public class Solution {
    char[] rest = null;

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] buf = new char[10];

        int l = s.read(buf, 1);
        int i = 0;

        while (i < l) {
            System.out.print(buf[i] + ".");
            i++;
        }

        l = s.read(buf, 1);
        i = 0;
        while (i < l) {
            System.out.print(buf[i] + "..");
            i++;
        }

        l = s.read(buf, 1);
        i = 0;
        while (i < l) {
            System.out.print(buf[i] + "...");
            i++;
        }

        l = s.read(buf, 1);
        i = 0;
        while (i < l) {
            System.out.print(buf[i] + "....");
            i++;
        }
    }

    /**
     * @param buf
     *            Destination buffer
     * @param n
     *            Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n <= 0 || buf == null || buf.length < n) {
            return 0;
        }

        int actualRead = 0;
        int totalRead = 0;
        char[] temp = new char[4];

        if (rest != null) {
            for (int i = 0; i < n && i < rest.length; i++) {
                buf[i] = rest[i];
                totalRead++;
            }
            if (n > totalRead) {
                rest = null;
            }
            else {
                if (n == totalRead && n == rest.length) {
                    rest = null;
                }
                else {
                    char[] newRest = new char[rest.length - totalRead];
                    for (int i = 0; i < newRest.length; i++) {
                        newRest[i] = rest[i + totalRead];
                    }
                    rest = newRest;
                }
                return totalRead;
            }
        }

        while (totalRead < n) {
            actualRead = read4(temp);
            if (actualRead == 0) {
                break;
            }
            for (int i = 0; i < actualRead; i++) {
                buf[i + totalRead] = temp[i];
            }
            totalRead += actualRead;
        }

        if (totalRead > n) {
            rest = new char[totalRead - n];
            for (int i = 0; i < rest.length; i++) {
                rest[i] = buf[i + n];
                buf[i + n] = 0;
            }
            totalRead = n;
        }

        return totalRead;
    }

    public int read4(char[] buf) {
        buf[0] = 'a';
        buf[1] = 'b';
        buf[2] = 'c';
        return 3;
    }
}
