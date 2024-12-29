package com.rotatingmind.array.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThorReadMessage {

    public static void printUnreadMsg(int n, int q, String[] tc) {

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < q; i++) {
            int e = Integer.parseInt(tc[i].split(" ")[0]);
            int a = Integer.parseInt(tc[i].split(" ")[1]);
            count++;


            if (map.containsKey(a)) {
                if (count % 4 == 0) {

                    map.put(a, map.get(a) - e);
                } else {

                    map.put(a, map.get(a) + e);
                }
            } else {
                map.put(a, e);
            }

            int sum = map.entrySet().stream().map(Map.Entry::getValue).reduce(0, Integer::sum);
            System.out.println(sum);
        }
    }


    /**
     * 1
     * 2
     * 3
     * 0
     * 1
     * 2
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        // HashMaps for storing data
        HashMap<Integer, Integer> appNotification = new HashMap<>();  // App ID -> Unread notifications
        HashMap<Integer, Integer> notificationCount = new HashMap<>(); // Notification number -> App ID
        HashMap<Integer, ArrayList<Integer>> notificationSequence = new HashMap<>(); // App ID -> List of notification numbers

        int answer = 0;  // Total unread notifications (updated directly)
        int count = 1;     // Counter for type 3 queries (starts from 1)

        while (q-- > 0) {
            String[] line = br.readLine().split(" ");
            int type = Integer.parseInt(line[0]);
            int key = Integer.parseInt(line[1]);

            switch (type) {
                case 1:
                    int notificationCountForApp = appNotification.getOrDefault(key, 0);  // Get or default to 0
                    answer += ++notificationCountForApp;  // Update answer and increment count directly
                    appNotification.put(key, notificationCountForApp);
                    ArrayList<Integer> list = notificationSequence.getOrDefault(key, new ArrayList<>());
                    list.add(count);
                    notificationSequence.put(key, list);
                    count++;  // Increment notification count for future lookups
                    break;
                case 2:
                    notificationCountForApp = appNotification.getOrDefault(key, 0);
                    if (notificationCountForApp > 0) {  // Check if there are unread notifications
                        answer -= notificationCountForApp;
                        appNotification.put(key, 0);
                        ArrayList<Integer> notificationList = notificationSequence.get(key);
                        notificationList.clear();  // Clear notification list instead of iterating
                    }
                    break;
                case 3:
                    while (count <= key) {
                        int appForNotification = notificationCount.getOrDefault(count, 0);
                        if (appForNotification != 0) {
                            answer--;
                            // No need to decrement appNotification here (handled in type 1 or 2)
                            notificationCount.put(count, 0);
                        }
                        count++;
                    }
                    break;
            }

            System.out.println(answer);
        }

        br.close();
    }
}
