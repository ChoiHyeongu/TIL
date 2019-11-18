public class test {
    public static void main(String[] args) {
        int[] data = new int[]{8,6,1,5,3,7};
        int i = 0;
        int j = 0;
        int t;
        while(i<=5){
            j = j+i;
            while(j<=5){
                if(data[i]>data[j]){
                    t = data[j];
                    data[j] = data[i];
                    data[i] = t;
                }
                j++;
                for(int val :data){
                    System.out.print(val+" ");
                }
                System.out.println();
            }
            i++;
        }
    }
}
