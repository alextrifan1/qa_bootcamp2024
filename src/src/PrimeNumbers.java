//Display all the prime numbers lower than 1 000 000. Name the class (and java file) PrimeNumbers


public class PrimeNumbers {
    public static void main(String[] args) {
        
        for (int numar = 2; numar <= 1000000; numar++) {
            boolean adev = true;
            for (int div = 2; div <= numar/2; div++) {
                if (numar%div == 0) {
                    adev = false;
                    break;
                }
            }
            if (adev) {
                System.out.println(numar);
            }
        }
    }
}
