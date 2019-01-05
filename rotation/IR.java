public class IR {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        // isRotation(array1, array2a) should return false.
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        // isRotation(array1, array2b) should return true.
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        // isRotation(array1, array2c) should return false.
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        // isRotation(array1, array2d) should return false.
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        // isRotation(array1, array2e) should return false.
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        // isRotation(array1, array2f) should return true.
        
        System.out.println(" isRotation(array1, array2a) " + isRotation(array1, array2a));
        System.out.println(" isRotation(array1, array2b) " + isRotation(array1, array2b));
        System.out.println(" isRotation(array1, array2c) " + isRotation(array1, array2c));
        System.out.println(" isRotation(array1, array2d) " + isRotation(array1, array2d));
        System.out.println(" isRotation(array1, array2e) " + isRotation(array1, array2e));
        System.out.println(" isRotation(array1, array2f) " + isRotation(array1, array2f));
    }

    // Implement your solution below.
    public static Boolean isRotation(int[] a1, int[] a2) {
        if(a1.length != a2.length) {
            return false;
        }
        
        int idx1 = -1;
        for(int i = 0; i <a2.length; i++) {
            if(a1[0] == a2[i]) {
                idx1 = i;
                break;
            }
        }
        
        if(idx1 != -1) {
            int i1 = 0;
            int i2 = idx1;
            while(i1 < a1.length) {
                if(a1[i1] == a2[i2]) {
                    i1++;
                    i2++;
                    
                    if(i2 == a2.length) {
                        i2 = 0;
                    }
                }
                else {
                    return false;
                }
            }
            
            return true;
        }
        
        return false;
    }
}
