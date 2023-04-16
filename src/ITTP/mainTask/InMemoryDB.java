package ITTP.mainTask;

import ITTP.mainTask.entity.DataRecord;

import java.util.*;

import java.util.Map;


/**
 * Исходя из требований, для хранения данных в памяти и выполнения операций быстрого поиска и модификации записей наиболее подходящей структурой данных будет HashMap.
 * Она обеспечит доступ к записям за время O(1).
 *
 * Требуется возможность быстрого поиска по любому из полей с алгоритмической сложностью не медленнее log(n).
 * Для этого можно использовать две HashMap:
 * Первая(data) будет хранить id записи(В моём случае в качестве id - используется поле account) и саму запись
 * Вторая(index - пытался провести аналогию с SQL-индексам :) ) которая будет индексировать записи по соответствующем полям (name и value).
 * При поиске по полю, ключом в HashMap будет значение поля, а значением будет id записи.
 * Это позволит выполнять поиск по любому из полей за время O(1).
 *
 * Таким образом, выбор структуры данных и алгоритмов для данной задачи будет выглядеть следующим образом:
 *
 * Для хранения записей и быстрого доступа к ним будет использована HashMap.
 * Для быстрого поиска по полям name и value будет использована индексированная HashMap.
 *
 * P.S. Я пытался найти другие как и выходящие за пределы Java Core, например, инвертированные hashmap в виде сторонней библиотеки,
 * так и средствами java core пытался обыграть разными структурами данных и свои собственными решениями, в итоге всё равно по разным причинам
 * оставил данный способ.
 */
public class InMemoryDB {
    private final Map<Long, DataRecord> data = new HashMap<>(); // Основная HashMap
    private final Map<Object, Long> index = new HashMap<>(); // индексированная HashMap
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