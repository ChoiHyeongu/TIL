import threading

class Message(threading.Thread):
    def run(self):
        for _ in range(10):
            print(threading.currentThread().getName())


x = Message(name="메세지를 보냅니다.")
y = Message(name="메세지를 수신합니다.")

x.start()
y.start()