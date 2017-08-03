package tech.loyd.offer.ch6;

public class Question41_2 {

	public static void printSquenceSumEqualSum(int sum){
		int first = 1;
		int end = 2;
		
		int total;
		
		while(first < (sum+1) / 2){
			total = 0;
			for(int i=first;i<=end;i++){
				total += i;
			}
			
			if(total == sum){
				for(int i=first;i<=end;i++){
					System.out.print(i + " ");
				}
				System.out.println();
				first++;
				end++;
			}else{
				if(total < sum)
					end++;
				else
					first++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		printSquenceSumEqualSum(35);
	}

}
