package designavotingsystem;

import java.util.*;

public class VotingSystem {
    Map<String, Integer> voteMap = new HashMap<>();
    Map<String, Integer> linkedVoteMap = new LinkedHashMap<>();
    Map<String, Integer> sortedVoteMap = new TreeMap<>();


    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        linkedVoteMap.put(candidate, linkedVoteMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }


    public void displayVotes() {
        System.out.println("Votes Count (Unordered): " + voteMap);
    }


    public void displayVotesInOrder() {
        System.out.println("Votes in Order: " + linkedVoteMap);
    }


    public void displaySortedResults() {
        System.out.println("Sorted Results: " + sortedVoteMap);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");

        system.displayVotes();           // Unordered
        system.displayVotesInOrder();    // Insertion Order
        system.displaySortedResults();   // Sorted Order
    }
}

