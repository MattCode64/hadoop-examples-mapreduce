package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("districts", DistrictsJob.class,
                    "A map/reduce program that lists the districts containing trees.");
            programDriver.addClass("species", SpeciesJob.class,
                    "A map/reduce program that lists all existing species.");
            programDriver.addClass("treesbyspecies", TreesBySpeciesJob.class,
                    "A map/reduce program that counts the number of trees of each species.");
            programDriver.addClass("maxheight", MaxHeightJob.class,
                    "A map/reduce program that finds the maximum height of each species.");
            programDriver.addClass("sortheight", SortHeightJob.class,
                    "A map/reduce program that sorts the heights of trees from smallest to largest.");
            programDriver.addClass("oldesttree", OldestTreeJob.class,
                    "A map/reduce program that finds the district containing the oldest tree.");
            programDriver.addClass("maxtreedistrict", TreeCountJob.class,
                    "A map/reduce program that finds the district containing the most trees (Phase 1).");
            programDriver.addClass("maxtreedistrict2", MaxTreeDistrictJob.class,
                    "A map/reduce program that finds the district containing the most trees (Phase 2).");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
