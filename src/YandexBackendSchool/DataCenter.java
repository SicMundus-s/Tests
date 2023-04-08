package YandexBackendSchool;

import java.util.List;

public class DataCenter {
    private int R; // „исло перезапусков дата центра
    private List<Integer> A; // „исло рабочих серверов в дата-центре на текущий момент

    public void reset(List<Integer> a) {
        this.A = a;
        this.R = R + 1;
    }
    public void disable(int serverDataCenter) { // index не сохран€етс€
        if (!(A.get(serverDataCenter - 1) == null)) { // ToDo
            A.remove(serverDataCenter - 1);
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

}
