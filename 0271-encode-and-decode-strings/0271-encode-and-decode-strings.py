class Codec:

    def encode(self, strs):

        result = ""

        for s in strs:

            result += str(len(s)) + "#" + s

        return result

    def decode(self, s):

        result = []

        i = 0

        while i < len(s):

            j = i

            # Find the delimiter after the length

            while s[j] != "#":

                j += 1

            # Read the length

            length = int(s[i:j])

            # Extract the string

            start = j + 1

            end = start + length

            result.append(s[start:end])

            # Move to the next encoded string

            i = end

        return result