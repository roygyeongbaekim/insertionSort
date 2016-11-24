package insertSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class InsertSort {
	public static int[] Insertion_Sort(int[] A, int n) {
		for (int j = 1; j < n; j++) {	// 두번째 index부터 key값을 설정하고 증가해 나간다.
			int key = A[j];				// key값을 설정하고
			int i = j - 1;				// key값 이전값은 정렬되지 않은 상태이다.
			while (i >= 0 && A[i] > key) { // 맨 끝부터 첫 배열까지 sort해나간다.
				A[i + 1] = A[i];			// 해당값을 바꿔준다
				i = i - 1;					// i값을 낮추고 앞으로 전진한다.
			}
			A[i + 1] = key;					// key값보다 작은 값을 만났을때 다음값에 key값을 삽입한다.
		}
		return A;
	}

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("hw02_100man.txt");
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
		data = Insertion_Sort(data, data.length);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double seconds = (double)elapsedTime / 1000000000.0;
		System.out.println("total elapsed time = " + elapsedTime);
		System.out.println("seconds = " + seconds);
		
		br.close();
		
		FileOutputStream fos = new FileOutputStream("hw01_01_201002378_insertion_100man.txt");
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
