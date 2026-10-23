class Solution {

private:

    vector<string> dfs(string& s, int start,

                       unordered_set<string>& words,

                       unordered_map<int, vector<string>>& memo) {

        if (memo.count(start)) {

            return memo[start];

        }

        vector<string> result;

        if (start == s.size()) {

            result.push_back("");

            return result;

        }

        for (int end = start + 1; end <= s.size(); end++) {

            string word = s.substr(start, end - start);

            if (words.count(word)) {

                vector<string> suffixes = dfs(s, end, words, memo);

                for (const string& suffix : suffixes) {

                    if (suffix.empty()) {

                        result.push_back(word);

                    } else {

                        result.push_back(word + " " + suffix);

                    }

                }

            }

        }

        memo[start] = result;

        return result;

    }

public:

    vector<string> wordBreak(string s, vector<string>& wordDict) {

        unordered_set<string> words(wordDict.begin(), wordDict.end());

        unordered_map<int, vector<string>> memo;

        return dfs(s, 0, words, memo);

    }

};