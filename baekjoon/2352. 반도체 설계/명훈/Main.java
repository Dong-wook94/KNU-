import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 40000;

	static int N;
	static int Port[];
	static Vector<Integer> PortV;

	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		solution();
	}

	public static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Port = new int[N];
		for (int i = 0; i < N; i++)
			Port[i] = Integer.parseInt(st.nextToken());
		PortV = new Vector<Integer>();
	}

	public static void solution() {
		PortV.add(Port[0]);
		// i��° port�� ����ȴٰ� ������ ��
		for (int i = 1; i < N; i++) {
			// ���� ũ�Ⱑ ���� �����ϴ� ������ �κ� ���� �� ���� �� ���� ����
			if (Port[i] > PortV.lastElement()) {
				PortV.add(Port[i]);
			} else {
				int j = 0;
				for (j = 0; j < PortV.size(); j++) {
					if (Port[i] > PortV.get(j))
						continue;
					else
						break;
				}
				PortV.remove(j);
				PortV.add(j, Port[i]);
			}
		}

		System.out.println(PortV.size());
	}

}
