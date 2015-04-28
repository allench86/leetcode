public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.compareVersion("1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return 0;
        }

        int result = 0;
        do {
            int dot1 = version1.indexOf('.');
            int dot2 = version2.indexOf('.');
            String curr1 = version1;
            String curr2 = version2;

            if (dot1 != -1) {
                curr1 = version1.substring(0, dot1);
                if (dot1 + 1 < version1.length()) {
                    version1 = version1.substring(dot1 + 1);
                }
                else {
                    version1 = "";
                }
            }
            else {
                version1 = "";
            }
            if (dot2 != -1) {
                curr2 = version2.substring(0, dot2);
                if (dot2 + 1 < version2.length()) {
                    version2 = version2.substring(dot2 + 1);
                }
                else {
                    version2 = "";
                }
            }
            else {
                version2 = "";
            }

            Integer v1 = Integer.valueOf(curr1);
            Integer v2 = Integer.valueOf(curr2);
            if (v1 > v2) {
                return 1;
            }

            if (v1 < v2) {
                return -1;
            }

        } while (!version1.isEmpty() && !version2.isEmpty());

        if (!version1.isEmpty() && version2.isEmpty()) {
            do {
                int dot1 = version1.indexOf('.');
                String curr1 = version1;

                if (dot1 != -1) {
                    curr1 = version1.substring(0, dot1);
                    if (dot1 + 1 < version1.length()) {
                        version1 = version1.substring(dot1 + 1);
                    }
                    else {
                        version1 = "";
                    }
                }
                else {
                    version1 = "";
                }

                Integer v1 = Integer.valueOf(curr1);
                if (v1 > 0) {
                    result = 1;
                    break;
                }
            } while (!version1.isEmpty());
        }
        if (version1.isEmpty() && !version2.isEmpty()) {
            do {
                int dot2 = version2.indexOf('.');
                String curr2 = version2;

                if (dot2 != -1) {
                    curr2 = version2.substring(0, dot2);
                    if (dot2 + 1 < version2.length()) {
                        version2 = version2.substring(dot2 + 1);
                    }
                    else {
                        version2 = "";
                    }
                }
                else {
                    version2 = "";
                }

                Integer v2 = Integer.valueOf(curr2);
                if (v2 > 0) {
                    result = -1;
                    break;
                }
            } while (!version2.isEmpty());
        }
        return result;
    }
}
