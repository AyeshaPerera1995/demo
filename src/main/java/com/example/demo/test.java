package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    class TrieNode {
        TrieNode[] children;
        List<String> suggestions;

        public TrieNode() {
            this.children = new TrieNode[26]; // Assuming only lowercase alphabetical characters
            this.suggestions = new ArrayList<>();
        }
    }

    public class test {

        public static List<List<String>> getProductSuggestions(List<String> products, String search) {
            TrieNode root = buildTrie(products);

            List<List<String>> result = new ArrayList<>();
            TrieNode current = root;

            for (char c : search.toCharArray()) {
                if (current != null) {
                    current = current.children[c - 'a'];
                }

                if (current == null) {
                    result.add(Collections.emptyList());
                } else {
                    result.add(current.suggestions.size() > 3
                            ? current.suggestions.subList(0, 3)
                            : current.suggestions);
                }
            }

            return result;
        }

        private static TrieNode buildTrie(List<String> products) {
            TrieNode root = new TrieNode();

            for (String product : products) {
                TrieNode current = root;
                for (char c : product.toCharArray()) {
                    int index = c - 'a';
                    if (current.children[index] == null) {
                        current.children[index] = new TrieNode();
                    }
                    current = current.children[index];
                    current.suggestions.add(product);
                    Collections.sort(current.suggestions);

                    if (current.suggestions.size() > 3) {
                        current.suggestions.remove(current.suggestions.size() - 1);
                    }
                }
            }

            return root;
        }

        public static void main(String[] args) {
            List<String> products = Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad");
            String search = "mouse";

            List<List<String>> suggestions = getProductSuggestions(products, search);

            for (List<String> suggestion : suggestions) {
                System.out.println(suggestion);
            }
        }
    }

