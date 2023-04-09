package YandexBackendSchool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataCenter {
    private int R; // „исло перезапусков дата центра

    private int numberServersDataCenter; //  олличество серверов в дата центре
    private List<Integer> A; // „исло нерабочих серверов в дата-центре на текущий момент

    // ћожно так же использовать Linked list и искать и удал€ть по значению. ѕри ресете придЄтс€ кидать по новой заполненый массив

    public void reset(List<Integer> a) { // +
        this.A = a;
        this.R = R + 1;
    }
    public void disable(int serverDataCenter) { // index не сохран€етс€ // +-
        if (!(A.get(serverDataCenter - 1) == null)) { // ToDo

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
