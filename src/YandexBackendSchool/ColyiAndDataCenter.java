package YandexBackendSchool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ColyiAndDataCenter {
    private int n; // ����� ����-�������
    private int m; // ����� �������� � ������ �� ����-�������
    private int q; // ����� �������
    private final List<DataCenter> dataCenters = new ArrayList<>();

    public void getMetrics() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();


        for (int i = 0; i < n; i++) {
            DataCenter center = new DataCenter(m);
            dataCenters.add(center);
        }


        // ��������� �������
        for (int i = 0; i < q; i++) {
            int idDataCenter = 0;
            int serverDataCenter = 0;
            String operation = scanner.next();
            if(scanner.hasNextInt()) {
                 idDataCenter = scanner.nextInt(); // id ���� ������
            }
            if (scanner.hasNextInt()) {
                 serverDataCenter = scanner.nextInt();// id ������� � ����������� ���� ������
            }

            switch (operation) {
                case ("RESET") -> {
                   DataCenter dataCenter = dataCenters.get(idDataCenter - 1);
                   dataCenter.reset(m);
                }

                case ("DISABLE") -> {
                    DataCenter dataCenter = dataCenters.get(idDataCenter - 1);
                    dataCenter.disable(serverDataCenter);
                }
                case ("GETMAX") -> {
                    int max = 0;
                    int id = 1;
                    for (int j = 0; j < dataCenters.size(); j++) {
                        DataCenter dataCenterMaxValue = dataCenters.get(j);
                        int temp = dataCenterMaxValue.getServersDataCenter() * dataCenterMaxValue.getR();
                        if (max < temp) {
                            max = temp;
                            id = i + 1;
                        }
                    }
                    System.out.println(id);
                }
                case ("GETMIN") -> {
                    int min = 0;
                    int id = 1;
                    for (int j = 0; j < dataCenters.size(); j++) {
                        DataCenter dataCenterMaxValue = dataCenters.get(j);
                        int temp = dataCenterMaxValue.getServersDataCenter() * dataCenterMaxValue.getR();
                        if (min > temp) { 
                            min = temp;
                            id = i + 1;
                        }
                    }
                    System.out.println(id);
                }
            }
        }

    }
}

