package insertSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class InsertSortBinary {
	public static int[] InsertSort_binary(int[] A, int n) {
		for (int j = 0; j < n; j++) {	// binary search �κ�
			int key = A[j];				// ó�� Ű���� ���� ���� ������ �����ϰ�
			int left = 0;				// left���� 0���� ����
			int right = j;				// right���� �ش� ��������

			while (left < right) {					// left���� right����
				int center = (left + right) / 2;	// center�� �����ϰ�
				if (key >= A[center]) {			// �ش� key���� center���� ũ�� 
					left = center + 1;				// left ��ġ�� center ���������� ����
				} else {						// key���� center���� ������
					right = center;					// right���� center�� ����
				}
			}
			for (int i = j; i > left; i--) {	// ������ ������ ������ ��������  
				int tmp = A[i - 1];				// ������ ���� ��ȯ���ش�.
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
