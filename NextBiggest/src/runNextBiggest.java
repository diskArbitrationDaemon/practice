
public class runNextBiggest {
	
	
	
	public static void main(String args[]){
		testIntToArr();
		testSwap();
		testReverse();
		testArrToInt();
		
		NextBiggest nb = new NextBiggest();
		
		System.out.println(nb.nextBiggest(9999));
		System.out.println(nb.nextBiggest(12345));		
		System.out.println(nb.nextBiggest(15432));
		System.out.println(nb.nextBiggest(54321));


		
	}

	
	public static void testIntToArr(){
		
		NextBiggest nb = new NextBiggest();
		int testNumber = 98765;
		
		int[] result = nb.intToArray(testNumber);
		
		assert(result[0] == 9);
		assert(result[1] == 8);
		assert(result[2] == 7);
		assert(result[3] == 6);
		assert(result[4] == 5);
	}

	public static void testSwap(){
		NextBiggest nb = new NextBiggest();
		int[] number = new int[3];
		number[0] = 5;
		number[1] = 9;
		number[2] = 0;
		
		nb.swapGivenIndex(0, 2, number);
		
		assert(number[0] == 0);
		assert(number[1] == 9);
		assert(number[2] == 5);
	}
	
	public static void testReverse(){
		NextBiggest nb = new NextBiggest();
		int[] number = new int[9];
		number[0] = 5;
		number[1] = 9;
		number[2] = 0;
		number[3] = 8;
		number[4] = 7;
		number[5] = 3;
		number[6] = 8;
		number[7] = 2;
		number[8] = 4;
		
		nb.reverse(5, 8, number);
		
		assert(number[0] == 5);
		assert(number[1] == 9);
		assert(number[2] == 0);
		assert(number[3] == 8);
		assert(number[4] == 7);
		assert(number[5] == 4);
		assert(number[6] == 2);
		assert(number[7] == 8);
		assert(number[8] == 3);
		
	}
	
	public static void testArrToInt(){
		int[] number = {4,5,6,2};
		NextBiggest nb = new NextBiggest();
		assert (nb.arrayToInt(number) == 4562);
	}
}
