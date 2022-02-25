package codes;

import java.util.Random;
import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

		// 컴퓨터가 세자리 숫자 출제
		// int 세칸짜리 배열로
		
		int[] cpuNumbers =  new int[3];
		
		for(int i=0; i<cpuNumbers.length; i++) {
			
			while(true) {
				Random myRandom =new Random();
				int randomNum = myRandom.nextInt(9)+1; // 1 ~10직전 (9)
				
				boolean isDuplOk =true;
				
				for(int num:cpuNumbers) {
					if(num== randomNum) {
						isDuplOk=false;
						break;
					}
				}
				if(isDuplOk) {
					cpuNumbers[i] = randomNum;
					break;
				}
			}
		}
		
		// 문제 확인용 for문
		System.out.print("문제: ");
		for(int num: cpuNumbers) {
			System.out.print(num);
		}
		System.out.println();
		
		// 사용자가 정답을 맞출때까지 입력받자
		Scanner myScanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("답안 입력: ");
			int inputNum = myScanner.nextInt();
			
			//321 => {3, 2, 1} 처럼 세칸 배열로 분리 / 맞춘 S,B 판정
			int[] myNumbers = new int[3];
			
			myNumbers[0]=inputNum / 100;
			myNumbers[1]=(inputNum / 10) % 10;
			myNumbers[2]=inputNum % 10;
			
			int strikeCount=0;
			int ballCount=0;
			
			for(int i=0; i<myNumbers.length; i++) {
				for(int j=0; j<cpuNumbers.length; j++) {
					
					if(myNumbers[i] == cpuNumbers[j]) {
						if(i==j) {
							strikeCount++;
						}
						else {
							ballCount++;
						}
					}
				}
			}
			
			System.out.println("strikeCount: "+strikeCount + ", ballCount: "+ballCount);
			
		}
		
		
		
		
		
		
	}
}