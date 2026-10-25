class Solution {

    private final String[] belowTwenty = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        int group = 0;

        while (num > 0) {
            int chunk = num % 1000;

            if (chunk != 0) {
                String words = convert(chunk);

                if (!thousands[group].isEmpty()) {
                    words += " " + thousands[group];
                }

                if (result.length() > 0) {
                    result.insert(0, words + " ");
                } else {
                    result.append(words);
                }
            }

            num /= 1000;
            group++;
        }

        return result.toString().trim();
    }

    private String convert(int num) {
        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return belowTwenty[num];
        }

        if (num < 100) {
            String result = tens[num / 10];

            if (num % 10 != 0) {
                result += " " + belowTwenty[num % 10];
            }

            return result;
        }

        return belowTwenty[num / 100] + " Hundred"
            + (num % 100 != 0 ? " " + convert(num % 100) : "");
    }
}