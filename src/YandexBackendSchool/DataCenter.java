package YandexBackendSchool;

import java.util.List;

public class DataCenter {
    private int R; // ����� ������������ ���� ������
    private List<Integer> A; // ����� ������� �������� � ����-������ �� ������� ������

    public void reset(List<Integer> a) {
        this.A = a;
        this.R = R + 1;
    }
    public void disable(int serverDataCenter) {
        if (!(A.get(serverDataCenter) == null)) { // ToDo
            A.remove(serverDataCenter);
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
