package design_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author run-dong-zhu
 * @description You will be supplied with two data files in CSV format .
 * The first file contains statistics about various dinosaurs. The second file contains additional data.
 * Given the following formula, speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g)
 * Where g = 9.8 m/s^2 (gravitational constant)
 * 
 * Write a program to read in the data files from disk, it must then print the names of only the bipedal 
 * dinosaurs from fastest to slowest. Do not print any other information.
 *
 * $ cat dataset1.csv
 * NAME,LEG_LENGTH,DIET
 * Hadrosaurus,1.4,herbivore
 * Struthiomimus,0.72,omnivore
 * Velociraptor,1.8,carnivore
 * Triceratops,0.47,herbivore
 * Euoplocephalus,2.6,herbivore
 * Stegosaurus,1.50,herbivore
 * Tyrannosaurus Rex,6.5,carnivore
 *
 * $ cat dataset2.csv 
 * NAME,STRIDE_LENGTH,STANCE
 * Euoplocephalus,1.97,quadrupedal
 * Stegosaurus,1.70,quadrupedal
 * Tyrannosaurus Rex,4.76,bipedal
 * Hadrosaurus,1.3,bipedal
 * Deinonychus,1.11,bipedal
 * Struthiomimus,1.24,bipedal
 * Velociraptorr,2.62,bipedal
 * 
 * I parsed both csv rows to dicts, looped over each dict, calculated speed, and inserted using insort_left into a sorted array
 */
public class Dinosaurs {

    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>(Arrays.asList(
                "Euoplocephalus,1.97,quadrupedal", 
                "Stegosaurus,1.70,quadrupedal",
                "Tyrannosaurus Rex,4.76,bipedal",
                "Hadrosaurus,1.3,bipedal",
                "Deinonychus,1.11,bipedal",
                "Struthiomimus,1.24,bipedal",
                "Velociraptorr,2.62,bipedal"));
        
        List<String> s2 = new ArrayList<>(Arrays.asList(
                "Hadrosaurus,1.4,herbivore",
                "Struthiomimus,0.72,omnivore",
                "Velociraptor,1.8,carnivore",
                "Triceratops,0.47,herbivore",
                "Euop,locephalus,2.6,herbivore",
                "Stegosaurus,1.50,herbivore",
                "Tyrannosaurus Rex,6.5,carnivore"));

        Map<String, Double> map = new HashMap<>();
        
        for(String s : s1) {
            String[] temp = s.split(",");
            if(temp[2].equals("bipedal")) {
                map.put(temp[0], Double.valueOf(temp[1]));
            }
        }
        
        for(String s : s2) {
            String[] temp = s.split(",");
            if(map.containsKey(temp[0])) {
                // speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g)
                double speed = (Double.valueOf(temp[1]) / map.get(temp[0]) - 1) * Math.sqrt(map.get(temp[0]) * 9.8);
                map.put(temp[0], speed);
            }
        }
        
//        for(Map.Entry<String, Double> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (map.get(a) > map.get(b)) ? -1 : 1);
        
        for(String s : map.keySet()) {
            pq.offer(s);
        }
        
        while(!pq.isEmpty()) {
            System.out.println(pq.peek() + " : " + map.get(pq.poll()));
//            System.out.println(pq.poll());
        }
    }

}
