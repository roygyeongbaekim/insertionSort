package insertSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class InsertSort {
	public static int[] Insertion_Sort(int[] A, int n) {
		for (int j = 1; j < n; j++) {	// �ι�° index���� key���� �����ϰ� ������ ������.
			int key = A[j];				// key���� �����ϰ�
			int i = j - 1;				// key�� �������� ���ĵ��� ���� �����̴�.
			while (i >= 0 && A[i] > key) { // �� ������ ù �迭���� sort�س�����.
				A[i + 1] = A[i];			// �ش簪�� �ٲ��ش�
				i = i - 1;					// i���� ���߰� ������ �����Ѵ�.
			}
			A[i + 1] = key;					// key������ ���� ���� �������� �������� key���� �����Ѵ�.
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
