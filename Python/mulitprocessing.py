import multiprocessing

def printA(num):
    for i in range(0, num):
        print ('A method')

def printB(num):
    for i in range(0, num):
        print ('B method')

if __name__ == '__main__':
    pool = multiprocessing.Pool(processes=2)
    pool.map(printA, 5)
    pool.close()
    pool.join()
