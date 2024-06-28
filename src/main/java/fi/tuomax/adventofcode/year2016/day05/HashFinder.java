package fi.tuomax.adventofcode.year2016.day05;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.commons.MD5;

/** Memoizes hashes calculated in part 1 in order to speed up part 2. */
public class HashFinder {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashFinder.class);

    private static List<String> hashes = new ArrayList<>();

    private static String seed = "";

    public static void setSeed(String seed)
    {
        if (!HashFinder.seed.equals(seed))
            HashFinder.hashes.clear();
        HashFinder.seed = seed;
        HashFinder.reset();
    }

    private static Integer idx = 0;

    public static String next()
    {
        if (idx >= hashes.size()) {
            String hash = MD5.getHash(seed, "00000", MD5.leftOff + 1);
            HashFinder.hashes.add(hash);
            LOGGER.debug("Found " + hash);
        }
        return hashes.get(idx++);
    }

    public static void reset()
    {
        idx = 0;
    }

}
