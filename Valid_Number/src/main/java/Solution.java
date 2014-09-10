public class Solution {
    public static void main(String[] args) {
        String input = "1.0203e1";
        Solution s = new Solution();

        System.out.println(s.isNumber(input));
    }

    public boolean isNumber(String s) {
        boolean result = false;
        String trimedInput = s.trim();
        // String desimalNum = "^[1-9]{1}(\\.[0-9]*[1-9]+)?[eE](-)?[1-9]{1}[0-9]?$";
        // result = s.matches(desimalNum);

        if (trimedInput.length() > 0) {
            if (trimedInput.charAt(0) == '-') {
                result = isZeroLeadingNumber(trimedInput.substring(1))
                        || isNonZeroLeadingNumber(trimedInput.substring(1))
                        || scienceNum(trimedInput.substring(1));
            }
            else {
                result = isZeroLeadingNumber(trimedInput)
                        || isNonZeroLeadingNumber(trimedInput)
                        || scienceNum(trimedInput);
            }
        }

        return result;
    }

    private boolean scienceNum(String input) {
        String scienceNumPattern = "^[1-9]{1}(\\.[0-9]*[1-9]+)?[eE](-)?[1-9]{1}[0-9]?$";
        return input.matches(scienceNumPattern);
    }

    private boolean isZeroLeadingNumber(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }

        if (input.charAt(0) != '0') {
            return false;
        }

        if (input.length() > 1 && input.charAt(1) != '.') {
            return false;
        }

        if (input.length() > 2) {
            String noDot = input.substring(2);

            if (noDot.isEmpty()) {
                return false;
            }

            for (int i = 0; i < noDot.length() - 1; i++) {
                if (noDot.charAt(i) < '0' || noDot.charAt(i) > '9') {
                    return false;
                }
            }

            // not sure 0.0?
            if (noDot.length() > 0 && noDot.charAt(noDot.length() - 1) == '0') {
                return false;
            }
        }

        return true;
    }

    private boolean isNonZeroLeadingNumber(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }

        String desimalNum = "^[1-9]{1}[0-9]*(\\.[0-9]*[1-9]+)?$";
        return input.matches(desimalNum);
    }

}
