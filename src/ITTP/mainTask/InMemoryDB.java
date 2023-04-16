package ITTP.mainTask;

import ITTP.mainTask.entity.DataRecord;

import java.util.*;

import java.util.Map;


/**
 * ������ �� ����������, ��� �������� ������ � ������ � ���������� �������� �������� ������ � ����������� ������� �������� ���������� ���������� ������ ����� HashMap.
 * ��� ��������� ������ � ������� �� ����� O(1).
 *
 * ��������� ����������� �������� ������ �� ������ �� ����� � ��������������� ���������� �� ��������� log(n).
 * ��� ����� ����� ������������ ��� HashMap:
 * ������(data) ����� ������� id ������(� ��� ������ � �������� id - ������������ ���� account) � ���� ������
 * ������(index - ������� �������� �������� � SQL-�������� :) ) ������� ����� ������������� ������ �� ��������������� ����� (name � value).
 * ��� ������ �� ����, ������ � HashMap ����� �������� ����, � ��������� ����� id ������.
 * ��� �������� ��������� ����� �� ������ �� ����� �� ����� O(1).
 *
 * ����� �������, ����� ��������� ������ � ���������� ��� ������ ������ ����� ��������� ��������� �������:
 *
 * ��� �������� ������� � �������� ������� � ��� ����� ������������ HashMap.
 * ��� �������� ������ �� ����� name � value ����� ������������ ��������������� HashMap.
 *
 * P.S. � ������� ����� ������ ��� � ��������� �� ������� Java Core, ��������, ��������������� hashmap � ���� ��������� ����������,
 * ��� � ���������� java core ������� �������� ������� ����������� ������ � ���� ������������ ���������, � ����� �� ����� �� ������ ��������
 * ������� ������ ������.
 */
public class InMemoryDB {
    private final Map<Long, DataRecord> data = new HashMap<>(); // �������� HashMap
    private final Map<Object, Long> index = new HashMap<>(); // ��������������� HashMap
    public void addRecord(DataRecord record) {
        Long id = record.getAccount();
        data.put(id, record);
        index.put(record.getName(), id);
        index.put(record.getValue(), id);
    }

    public void deleteRecord(Long id) {
        DataRecord record = data.remove(id);
        if (record != null) {
            index.remove(record.getName());
            index.remove(record.getValue());
        }
    }

    public void updateRecord(DataRecord record) {
        Long id = record.getAccount();
        DataRecord oldRecord = data.get(id);
        if (oldRecord != null) {
            index.remove(oldRecord.getName());
            index.remove(oldRecord.getValue());
        }
        data.put(id, record);
        index.put(record.getName(), id);
        index.put(record.getValue(), id);
    }

    public DataRecord getRecordById(Long id) {
        return data.get(id);
    }

    public DataRecord getRecordByName(String name) {
        Long id = index.get(name);
        if (id != null) {
            return data.get(id);
        }
        return null;
    }

    public DataRecord getRecordByValue(double value) {
        Long id = index.get(value);
        if (id != null) {
            return data.get(id);
        }
        return null;
    }
}