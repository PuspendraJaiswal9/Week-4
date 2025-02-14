package insurancepolicymanagementsystem.usinghashmap;

import java.util.*;

class Policy {
    String policyNumber;
    String holderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String holderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy No: " + policyNumber + ", Holder: " + holderName + ", Expiry: " + expiryDate +
                ", Type: " + coverageType + ", Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    Map<Date, Policy> treeMap = new TreeMap<>();


    public static Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

    public void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap.put(policy.expiryDate, policy);
    }


    public void retrieveByNumber(String policyNumber) {
        if (hashMap.containsKey(policyNumber)) {
            System.out.println("Policy Found: " + hashMap.get(policyNumber));
        } else {
            System.out.println("Policy Not Found!");
        }
    }

    public void listExpiringSoon() {
        System.out.println("Policies Expiring Within 30 Days:");
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date limit = cal.getTime();

        for (Map.Entry<Date, Policy> entry : treeMap.entrySet()) {
            if (entry.getKey().before(limit)) {
                System.out.println(entry.getValue());
            }
        }
    }

    public void listByHolder(String holderName) {
        System.out.println("Policies for Holder: " + holderName);
        for (Policy policy : hashMap.values()) {
            if (policy.holderName.equalsIgnoreCase(holderName)) {
                System.out.println(policy);
            }
        }
    }

    public void removeExpiredPolicies() {
        System.out.println("Removing Expired Policies...");
        Date today = new Date();
        treeMap.entrySet().removeIf(entry -> entry.getKey().before(today));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        system.addPolicy(new Policy("P101", "Alice", createDate(2025, 6, 10), "Health", 5000));
        system.addPolicy(new Policy("P102", "Bob", createDate(2025, 4, 15), "Auto", 3000));
        system.addPolicy(new Policy("P103", "Charlie", createDate(2025, 3, 20), "Home", 7000));

        system.retrieveByNumber("P102");
        system.listExpiringSoon();
        system.listByHolder("Alice");
        system.removeExpiredPolicies();
    }
}


