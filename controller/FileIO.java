package controller;

import model.Tree;
import model.TreeSize;
import model.TreeType;
import model.World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

    public static World read(String filePath) {
        World world = new World();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(":");

                if (data.length != 4) continue;

                TreeType type = TreeType.valueOf(data[0].toUpperCase());
                TreeSize size = TreeSize.valueOf(data[1].toUpperCase());
                double relX = Double.parseDouble(data[2]);
                double relY = Double.parseDouble(data[3]);

                world.addTree(new Tree(size, type, relX, relY));
            }
        } catch (IOException e) {
            return null;
        }

        return world;
    }
}
