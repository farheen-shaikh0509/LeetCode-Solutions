class Solution:
    def read(self, buf: list[str], n: int) -> int:
        total_read = 0
        buf4 = [''] * 4
        end_of_file = False
        
        while not end_of_file and total_read < n:
            count = read4(buf4)
            if count < 4:
                end_of_file = True
            
            current_read = min(count, n - total_read)
            for i in range(current_read):
                buf[total_read + i] = buf4[i]
            total_read += current_read
            
        return total_read