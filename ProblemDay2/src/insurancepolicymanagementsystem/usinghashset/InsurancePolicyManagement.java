package insurancepolicymanagementsystem.usinghashset;

import java.util.*;

class Policy implements Comparable<Policy> {
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
    public int compareTo(Policy p) {
        return this.expiryDate.compareTo(p.expiryDate);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }


    @Override
    public String toString() {
        return "Policy No: " + policyNumber + ", Holder: " + holderName + ", Expiry: " + expiryDate +
                ", Type: " + coverageType + ", Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();


    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }


    public void displayAllPolicies() {
        System.out.println("All Policies:");
        for (Policy p : hashSet) {
            System.out.println(p);
        }
    }


    public void displayExpiringSoon() {
        System.out.println("Policies Expiring Soon:");
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date limit = cal.getTime();

        for (Policy p : treeSet) {
            if (p.expiryDate.before(limit)) {
                System.out.println(p);
            }
        }
    }


    public void displayByCoverageType(String type) {
        System.out.println("Policies with Coverage Type: " + type);
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }


    public void findDuplicatePolicies() {
        System.out.println("Duplicate Policies:");
        Set<String> seen = new HashSet<>();
        for (Policy p : hashSet) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        // Test policies
        system.addPolicy(new Policy("P101", "Alice", new Date(2025, 5, 10), "Health", 5000));
        system.addPolicy(new Policy("P102", "Bob", new Date(2025, 3, 15), "Auto", 3000));
        system.addPolicy(new Policy("P103", "Charlie", new Date(2025, 2, 20), "Home", 7000));
        system.addPolicy(new Policy("P101", "Alice", new Date(2025, 5, 10), "Health", 5000));

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");
        system.findDuplicatePolicies();
    }
}
