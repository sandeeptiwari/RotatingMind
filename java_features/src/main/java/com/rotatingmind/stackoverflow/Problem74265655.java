package com.rotatingmind.stackoverflow;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.models.Car;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

// [ "Pantry->Butter->Cream", "Pantry->Snack", "Medicine" ]
public class Problem74265655 {

    public static ImmutableList<CategoryTreeDto> getCategories() throws IOException {
        InputStream inputStream = Resources.getResource("tree.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<CategoryTreeDto>>() {
        }.getType();
        List<CategoryTreeDto> categories = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(categories);
    }

    public static void main(String[] args) {
        try {
            ImmutableList<CategoryTreeDto> categories = getCategories();
            System.out.println(categories.toString());

            List<String> result = new ArrayList<>();
            for (CategoryTreeDto dto : categories) {
                traverse(dto, dto.getName(), result);
            }
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void traverse(CategoryTreeDto dto, String current, List<String> result) {
        List<CategoryTreeDto> children = dto.getChildrenItems();

        if (children.isEmpty()) {
            result.add(current);
            return;
        }

        for (CategoryTreeDto childDto: dto.getChildrenItems()) {
            String next = current + " -> " + childDto.getName();
            traverse(childDto, next, result);
        }
    }
}

class CategoryTreeDto {
    private String name;
    private List<CategoryTreeDto> childrenItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryTreeDto> getChildrenItems() {
        return childrenItems;
    }

    public void setChildrenItems(List<CategoryTreeDto> childrenItems) {
        this.childrenItems = childrenItems;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
