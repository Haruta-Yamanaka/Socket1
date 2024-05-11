public class Renshu {
 // xを2倍にして返す関数
     public int doubleValue(int x) {
    return x * 2;
    }

//ここに続きを実装していく。
    public int sumUpToN(int n){
        int o = 0;
        for(int i = 1;i<=n;i++){
            o+=i;
        }
        return o;
    }

    public int sumFromPtoQ(int p, int q){
        int o = 0;
        if(p>q){
            return -1;
        }

        else{
        for(int i = p;i<=q;i++){
            o+=i;
        }
        return o;
        }
    }

    public int sumFromArrayIndex(int[] a, int index){
        if(index <0 || index >= a.length){
            return -1;
        }
        else {
            int o = 0;
            for (int i = index;i<a.length;i++){
                o+=a[i];
            }
            return o;
        }
    }

    public int selectMaxValue(int[] a){
     
        int max = a[0];
            for (int i = 1;i<a.length;i++){
                if(max < a[i]){
                    max = a[i];
               
                }
            }
        return max;
    }

    public int selectMaxIndex(int[] a){
        int maxIndex = 0;
        int max = a[0];
            for (int i = 1;i<a.length;i++){
                if(max < a[i]){
                    max = a[i];
                    maxIndex = i;
                }
            }
        return maxIndex;
    }

    public int selectMinValue(int[] a){
        int min = a[0];
            for (int i = 1;i<a.length;i++){
                if(min > a[i]){
                    min = a[i];
                }
            }
        return min;
    }

    public int selectMinIndex(int[] a){
        int min = a[0];
        int minIndex = 0;
            for (int i = 1;i<a.length;i++){
                if(min > a[i]){
                    min = a[i];
                    minIndex = i;
                }
            }
        return minIndex;
    }

    public void swapArrayElements(int[] p, int i, int j){
        if(i<0||i>=p.length||j<0||j>=p.length){
            
        }
        else{
            int m = p[j];
            p[j] = p[i];
            p[i] = m;
        }
    }

    public boolean swapTwoArrays(int[] a, int[] b){
        int[] c =  new int[b.length];
       if(a.length != b.length){
        return false;
       }
       else{
        for (int i =0;i<a.length;i++){
            c[i] = b[i];
            b[i] = a[i];
            a[i] = c[i];
        }
        return true;
    }
        }
}

