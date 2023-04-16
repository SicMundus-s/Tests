package YandexBackendSchool.Test1DataCenter;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private int R; // „исло перезапусков дата центра

    private int ServersDataCenter; //  оличество серверов в дата центре
    private List<Integer> A; // „исло нерабочих серверов в дата-центре на текущий момент


    public DataCenter(int serversDataCenter) {
        ServersDataCenter = serversDataCenter;
        A = new ArrayList<>();
    }

    public void reset(int numberServersDataCenter) {
        this.ServersDataCenter = numberServersDataCenter;
        A.clear();
        this.R = R + 1;
    }
    public void disable(int serverDataCenter) {
            if(A.size() == 0) {
                this.ServersDataCenter -= 1;
                A.add(serverDataCenter);
        } else if (!A.contains(serverDataCenter)) {
                this.ServersDataCenter -= 1;
                A.add(serverDataCenter);
            }
    }

    public int getR() {
        return R;
    }

    public int getServersDataCenter() {
        return ServersDataCenter;
    }

}
