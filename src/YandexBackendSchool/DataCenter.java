package YandexBackendSchool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataCenter {
    private int R; // ����� ������������ ���� ������

    private int numberServersDataCenter; // ����������� �������� � ���� ������
    private List<Integer> A; // ����� ��������� �������� � ����-������ �� ������� ������

    // ����� ��� �� ������������ Linked list � ������ � ������� �� ��������. ��� ������ ������� ������ �� ����� ���������� ������

    public void reset(List<Integer> a) { // +
        this.A = a;
        this.R = R + 1;
    }
    public void disable(int serverDataCenter) { // index �� ����������� // +-
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
