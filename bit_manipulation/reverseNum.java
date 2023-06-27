package bit_manipulation;
    class reverseNum {
        public static void main(String[] args) {
            int nt = 5;
            System.out.println(bitwiseComplement(nt));
        }
        public static int bitwiseComplement(int n) {

            int counter = 0;
            if (n==0) return 1;
            while (n>0)
            {
                n = n>>1;
                counter++;
            }
            int z = 0;
            for (int i = 0; i<counter; i++)
            {
                z = z<<1;
                z = z | 1;
            }
            return n^z;
        }
    }
