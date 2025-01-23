package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static List<Employee> findDuplicates(List<Employee> employees){
        Set<Employee> uniqueSet = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee employee : employees) {
            if (!uniqueSet.add(employee)) {
                duplicates.add(employee);
            }
        }

        return duplicates;
    }
    //Listede tekrar eden Employee nesnelerini bulurt
    //enuiqueSet : Tekrar edenleri bulmak için kullanılır. HashSet aynı elemanları birden fazla saklamaz.

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Set<Integer> duplicateIds = new HashSet<>();

        for (Employee employee : employees) {
            if (employee == null) continue; // Eğer employee null ise bu iterasyonu atla
            if (uniqueMap.containsKey(employee.getId())) {
                duplicateIds.add(employee.getId());
                uniqueMap.remove(employee.getId());
            } else if (!duplicateIds.contains(employee.getId())) {
                uniqueMap.put(employee.getId(), employee);
            }
        }


        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee == null) continue; // Null olan elemanları atla

            frequencyMap.put(employee.getId(), frequencyMap.getOrDefault(employee.getId(), 0) + 1);
        }

        for (Employee employee : employees) {
            if (employee == null) continue; // Null olan elemanları atla

            if (frequencyMap.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Employee> employeeList = new LinkedList<>();
        //LinkedKist Çalışanların saklandığı bir liste
        //AYnı id Ye sahip çalışanlar tekrar eder.
        employeeList.add(new Employee(1, "John", "Doe"));
        employeeList.add(new Employee(2, "Jane", "Smith"));
        employeeList.add(new Employee(3, "Alice", "Johnson"));
        employeeList.add(new Employee(1, "John", "Doe"));
        employeeList.add(new Employee(4, "Bob", "Brown"));

        System.out.println("Original List:");
        employeeList.forEach(System.out::println);

        List<Employee> duplicates = findDuplicates(employeeList);
        System.out.println("\nDuplicate Employees:");
        duplicates.forEach(System.out::println);

        Map<Integer, Employee> uniques = findUniques(employeeList);
        System.out.println("\nUnique Employees:");
        uniques.values().forEach(System.out::println);

        List<Employee> noDuplicates = removeDuplicates(employeeList);
        System.out.println("\nList After Removing All Duplicates:");
        noDuplicates.forEach(System.out::println);

        // Main sınıfında
        WordCounter wordCounter = new WordCounter(); // Nesne oluşturduk
        Map<String, Integer> wordCount = WordCounter.calculatedWord(); // Doğru kullanım

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}