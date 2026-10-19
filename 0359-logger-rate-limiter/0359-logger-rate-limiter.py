class Logger(object):

    def __init__(self):

        self.message_time = {}

    def shouldPrintMessage(self, timestamp, message):

        if message not in self.message_time or timestamp - self.message_time[message] >= 10:

            self.message_time[message] = timestamp

            return True

        return False