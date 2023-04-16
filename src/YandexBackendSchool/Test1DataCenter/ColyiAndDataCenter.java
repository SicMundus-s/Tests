package YandexBackendSchool.Test1DataCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColyiAndDataCenter {
    private int n; // Число дата-центров
    private int m; // Число серверов в каждом из дата-центров
    private int q; // Число событий
    private final List<DataCenter> dataCenters = new ArrayList<>();

    public void getMetrics() {
        Scanner scannerValue = new Scanner(System.in);
        n = scannerValue.nextInt();
        m = scannerValue.nextInt();
        q = scannerValue.nextInt();


        for (int i = 0; i < n; i++) {
            DataCenter center = new DataCenter(m);
            dataCenters.add(center);
        }


        // Обработка событий
        for (int i = 0; i < q; i++) {
            Scanner scannerOperator = new Scanner(System.in);
            int idDataCenter = 0;
            int serverDataCenter = 0;
            String operation = scannerOperator.next();
            switch (operation) {
                case ("RESET") -> {
                   idDataCenter = scannerOperator.nextInt();
                   DataCenter dataCenter = dataCenters.get(idDataCenter - 1);
                   dataCenter.reset(m);
                }

                case ("DISABLE") -> {
                    idDataCenter = scannerOperator.nextInt();
                    serverDataCenter = scannerOperator.nextInt();
                    DataCenter dataCenter = dataCenters.get(idDataCenter - 1);
                    dataCenter.disable(serverDataCenter);
                }
                case ("GETMAX") -> {
                    int max = Integer.MIN_VALUE;
                    int id = 1;
                    for (int j = 0; j < dataCenters.size(); j++) {
                        DataCenter dataCenterMaxValue = dataCenters.get(j);
                        int temp = dataCenterMaxValue.getServersDataCenter() * dataCenterMaxValue.getR();
                        if (max < temp) {
                            max = temp;
                            id =  j + 1;
                        }
                    }
                    System.out.println(id);
                }
                case ("GETMIN") -> {
                    int min = Integer.MAX_VALUE;
                    int id = 1;
                    for (int j = 0; j < dataCenters.size(); j++) {
                        DataCenter dataCenterMaxValue = dataCenters.get(j);
                        int temp = dataCenterMaxValue.getServersDataCenter() * dataCenterMaxValue.getR();
                        if (min > temp) {
                            min = temp;
                            id = j + 1;
                        }
                    }
                    System.out.println(id);
                }
            }
        }

    }
}

