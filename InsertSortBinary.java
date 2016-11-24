package insertSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class InsertSortBinary {
	public static int[] InsertSort_binary(int[] A, int n) {
		for (int j = 0; j < n; j++) {	// binary search 부분
			int key = A[j];				// 처음 키값을 가장 앞의 값으로 설정하고
			int left = 0;				// left값은 0으로 설정
			int right = j;				// right값은 해당 부위부터

			while (left < right) {					// left부터 right까지
				int center = (left + right) / 2;	// center를 설정하고
				if (key >= A[center]) {			// 해당 key값이 center보다 크면 
					left = center + 1;				// left 위치를 center 오른쪽으로 설정
				} else {						// key값이 center보다 작으면
					right = center;					// right값을 center로 설정
				}
			}
			for (int i = j; i > left; i--) {	// 위에서 설정한 범위를 기준으로  
				int tmp = A[i - 1];				// 그전의 값과 교환해준다.
				A[i - 1] = A[i];
				A[i] = tmp;
			}
		}
		return A;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("data02.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = null;
		int[] data = null;

		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			data = new int[values.length];

			for (int i = 0; i < values.length; i++) {
				data[i] = Integer.parseInt(values[i]);
			}
		}

		long startTime = System.nanoTime();
		data = InsertSort_binary(data, data.length);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double seconds = (double)elapsedTime / 1000000000.0;
		System.out.println("total elapsed time = " + elapsedTime);
		System.out.println("seconds = " + seconds);

		br.close();
		
		FileOutputStream fos = new FileOutputStream("hw01_01_201002378_binary_insertion_100man.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		for (int i = 0; i<data.length; i++){
			String tmp = Integer.toString(data[i]);
			bw.write(tmp);
			if(i != data.length - 1){
				bw.write(",");
			}
		}
		bw.close();
	}
}
