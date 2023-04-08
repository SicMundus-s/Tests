package YandexBackendSchool;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ColyiAndDataCenter {
    private int n; // Число дата-центров
    private int m; // Число серверов в каждом из дата-центров
    private int q; // Число событий
    private final List<DataCenter> dataCenters = new ArrayList<>();

    public void getMetrics() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            List<Integer> a = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                a.add(j + 1);
            }
            DataCenter center = new DataCenter();
            center.setA(a);
            dataCenters.add(center);
        }

        // Обработка событий
        for (int i = 0; i < q; i++) {
            int idDataCenter = 0;
            int serverDataCenter = 0;
            String operation = scanner.next();
            if(scanner.hasNextInt()) {
                 idDataCenter = scanner.nextInt(); // id дата центра
            }
            if (scanner.hasNextInt()) {
                 serverDataCenter = scanner.nextInt();// id сервера в определённом дата центре
            }

            DataCenter dataCenter = dataCenters.get(idDataCenter);
            switch (operation) {
                case ("RESET") -> {
                   List<Integer> a = IntStream.range(1, m).boxed().toList();
                   dataCenter.reset(a);
                }

                case ("DISABLE") -> {
                    dataCenter.disable(serverDataCenter);
                }
                case ("GETMAX") -> {
                    int max = 0;
                    int id = 0;
                    for (int j = 0; j < dataCenters.size(); j++) {
                        DataCenter dataCenterMaxValue = dataCenters.get(i);
                        int temp = dataCenterMaxValue.getA().size() * dataCenterMaxValue.getR();
                        if (max < temp) {
                            max = temp;
                            id = i + 1;
                        }
                    }
                    System.out.println(id);
                }
                case ("GETMIN") -> {
                    int min = 0;
                    int id = 0;
                    for (int j = 0; j < dataCenters.size(); j++) {
                        DataCenter dataCenterMaxValue = dataCenters.get(i);
                        int temp = dataCenterMaxValue.getA().size() * dataCenterMaxValue.getR();
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

