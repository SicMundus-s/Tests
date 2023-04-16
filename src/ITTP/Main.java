package ITTP;



import ITTP.mainTask.InMemoryDB;
import ITTP.mainTask.entity.DataRecord;

public class Main {
    public static void main(String[] args) {

        InMemoryDB db = new InMemoryDB();
        DataRecord record1 = new DataRecord(1, "John", 1000.0);
        DataRecord record2 = new DataRecord(2, "Jane", 2000.0);

        db.addRecord(record1);
        db.addRecord(record2);

        // Test addRecord method
        assert db.getRecordById(1L) == record1;
        assert db.getRecordById(2L) == record2;
        assert db.getRecordByName("John") == record1;
        assert db.getRecordByValue(1000.0) == record1;
        assert db.getRecordByName("Jane") == record2;
        assert db.getRecordByValue(2000.0) == record2;

        // Test updateRecord method
        DataRecord updatedRecord1 = new DataRecord(1, "Jonathan", 1500.0);
        db.updateRecord(updatedRecord1);
        assert db.getRecordById(1L) == updatedRecord1;
        assert db.getRecordByName("John") == null;
        assert db.getRecordByValue(1000.0) == null;
        assert db.getRecordByName("Jonathan") == updatedRecord1;
        assert db.getRecordByValue(1500.0) == updatedRecord1;

        // Test deleteRecord method
        db.deleteRecord(1L);
        assert db.getRecordById(1L) == null;
        assert db.getRecordByName("Jonathan") == null;
        assert db.getRecordByValue(1500.0) == null;
    }
}
