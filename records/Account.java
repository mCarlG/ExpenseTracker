package records;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// !! ENSURE YOU CHECK WHETHER RETURNED LISTS ARE EMPTY !!
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class Account {
    private Map<Integer, Map<Integer, Map<Integer, List<Transaction>>>> transactionsByDate = new HashMap<>();
    // This is a hashmap/hashtable that we used in 131 and 231. Need it for the O(1) lookup efficiency. We use the
    // interfaces for the classes here as the Collections class gets annoyed otherwise. Map/List are the interfaces,
    // HashMap/ArrayList are the concrete classes.

    public Account() {
    }

    // The idea here is to have a default constructor to allow a new account to be created, or load a pre-existing
    // account be passing a filename to the constructor.
    public Account(String jsonFileName) throws IOException {
        loadFromJsonFile(jsonFileName);
    }

    private void loadFromJsonFile(String jsonFileName) throws IOException {
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Map<Integer, Map<Integer, Map<Integer, List<Transaction>>>>>(){}.getType();
        transactionsByDate = gson.fromJson(new FileReader(jsonFileName), type);
    }

    public void saveToJsonFile(String jsonFileName) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(transactionsByDate);

        try (FileWriter writer = new FileWriter(jsonFileName)) {
            writer.write(json);
        }
    }

    public void addTransaction(Transaction transaction) {
        LocalDate date = transaction.getDate();
        int year = date.getYearValue();
        int month = date.getMonthValue();
        int day = date.getDayValue();

        // Nice little method to add hashmaps and arrays as necessary. Lambdas (second arg) are so much fun btw.
        // Lambdas are an anonymous function that may be passed as an argument. Can be used for callbacks or general
        // polymorphic function calls.
        transactionsByDate
                .computeIfAbsent(year, y -> new HashMap<>())
                .computeIfAbsent(month, m -> new HashMap<>())
                .computeIfAbsent(day, d -> new ArrayList<>())
                .add(transaction);
    }

    public List<Transaction> getTransactionsForDay(int year, int month, int day) {
        // When using the method, null lists must be accounted for.
        return transactionsByDate.getOrDefault(year, Collections.emptyMap())
                .getOrDefault(month, Collections.emptyMap())
                .getOrDefault(day, Collections.emptyList());
    }

    public List<Transaction> getTransactionsForMonth(int year, int month) {
        List<Transaction> monthlyTransactions = new ArrayList<>();
        Map<Integer, Map<Integer, List<Transaction>>> yearMap = transactionsByDate.get(year);

        if (yearMap != null) {
            Map<Integer, List<Transaction>> monthMap = yearMap.get(month);
            if (monthMap != null) {
                for (List<Transaction> dayTransactions : monthMap.values()) {
                    monthlyTransactions.addAll(dayTransactions);
                }
            }
        }

        // When using the method, null lists must be accounted for.
        return monthlyTransactions;
    }
}
