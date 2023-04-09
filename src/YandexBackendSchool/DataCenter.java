package YandexBackendSchool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataCenter {
    private int R; // „исло перезапусков дата центра

    private int ServersDataCenter; //  олличество серверов в дата центре
    private List<Integer> A; // „исло нерабочих серверов в дата-центре на текущий момент

    // ћожно так же использовать Linked list и искать и удал€ть по значению. ѕри ресете придЄтс€ кидать по новой заполненый массив


    public DataCenter(int serversDataCenter) {
        ServersDataCenter = serversDataCenter;
        A = new ArrayList<>();
    }

    public void reset(int numberServersDataCenter) { // +
        this.ServersDataCenter = numberServersDataCenter;
        A.clear();
        this.R = R + 1;
    }
    public void disable(int serverDataCenter) { // index не сохран€етс€ // +-
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

    public void setR(int r) {
        R = r;
    }

    public List<Integer> getA() {
        return A;
    }

    public void setA(List<Integer> a) {
        A = a;
    }

    public int getServersDataCenter() {
        return ServersDataCenter;
    }

    public void setServersDataCenter(int serversDataCenter) {
        ServersDataCenter = serversDataCenter;
    }
}
