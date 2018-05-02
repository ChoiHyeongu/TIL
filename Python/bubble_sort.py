def swap(x, i, j):
	x[i],x[j] = x[j],x[i]

def bubbleSort(x):
	for size in reversed(range(len(x))):
		for i in range(size):
			if x[i]>x[i+1]:
				swap(x, i, i+1)
	return x;

x = [5,4,3,2,1]

print(bubbleSort(x));