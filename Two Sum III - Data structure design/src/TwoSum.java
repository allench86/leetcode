public class TwoSum {
    int currentLength;
    int[] buffer;
    int defaultLength = 20;

    public TwoSum() {
        currentLength = 0;
        buffer = new int[defaultLength];
    }

    public void add(int number) {
        if (currentLength == 0) {
            buffer[0] = number;
            currentLength++;
            return;
        }

        int[] newBuffer = buffer;
        if (currentLength == buffer.length) {
            newBuffer = new int[buffer.length * 2];
        }

        int i = currentLength - 1;
        for (; i >= 0 && buffer[i] > number; i--) {
            newBuffer[i + 1] = buffer[i];
        }

        newBuffer[i + 1] = number;
        if (newBuffer != buffer) {
            for (; i >= 0; i--) {
                newBuffer[i] = buffer[i];
            }
        }
        buffer = newBuffer;
        currentLength++;
    }

    public boolean find(int value) {
        int l = 0;
        int r = currentLength - 1;

        while (l < r) {
            if (buffer[l] + buffer[r] < value) {
                l++;
            }
            else if (buffer[l] + buffer[r] > value) {
                r--;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
