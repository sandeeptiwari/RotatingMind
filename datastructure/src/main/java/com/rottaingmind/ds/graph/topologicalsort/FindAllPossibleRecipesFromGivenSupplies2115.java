package com.rottaingmind.ds.graph.topologicalsort;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies2115 {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for(String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
                inDegree.put(recipe, inDegree.getOrDefault(recipe, 0) + 1);
            }
        }

        // Initialize the queue with supplies
        Queue<String> queue = new LinkedList<>();

        // Result list
        List<String> result = new ArrayList<>();

        for (String supply : supplies) {
            queue.offer(supply);
        }


        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (inDegree.containsKey(current) && inDegree.get(current) == 0) {
                result.add(current);
            }

            if (!graph.containsKey(current)) continue;

            for (String dependentRecipe : graph.get(current)) {
                inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);

                if (inDegree.get(dependentRecipe) == 0) {
                    queue.remove(dependentRecipe);
                }
            }

        }

        return result;
    }


}
