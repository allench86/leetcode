public class Solution extends Reader4 {
    /**
     * @param buf
     *            Destination buffer
     * @param n
     *            Maximum number of characters to read
     * @return The number of characters read
     */
    // int read4(char[] buf);
    public int read(char[] buf, int n) {
        if (n <= 0 || buf == null || buf.length < n) {
            return 0;
        }

        int actualRead = 0;
        int totalRead = 0;
        char[] temp = new char[4];

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

        while (totalRead > n) {
            buf[--totalRead] = 0;
        }

        return totalRead;
    }
}