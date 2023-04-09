package YandexBackendSchool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataCenter {
    private int R; // ����� ������������ ���� ������

    private int ServersDataCenter; // ����������� �������� � ���� ������
    private List<Integer> A; // ����� ��������� �������� � ����-������ �� ������� ������

    // ����� ��� �� ������������ Linked list � ������ � ������� �� ��������. ��� ������ ������� ������ �� ����� ���������� ������


    public DataCenter(int serversDataCenter) {
        ServersDataCenter = serversDataCenter;
        A = new ArrayList<>();
    }

    public void reset(int numberServersDataCenter) { // +
        this.ServersDataCenter = numberServersDataCenter;
        A.clear();
        this.R = R + 1;
    }
    public void disable(int serverDataCenter) { // index �� ����������� // +-
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
