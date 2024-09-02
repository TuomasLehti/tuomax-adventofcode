package fi.tuomax.adventofcode.year2022.day07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A directory from the Elves device from Advent of Code 2022, day 7.
 */
public class Directory 
{

    /**
     * The size of an individual file doesn't matter in this puzzle, so all we 
     * need to do is keep track of the total size of all files in this 
     * directory.
     */
    private Long totalSizeOfFiles = 0L;

    /**
     * The number of child directories a parent directory can hold is not 
     * defined. I'm almost certain that Advent of Code team doesn't throw at us
     * anything that wouldn't fit in a simple map.
     */
    private Map<String, Directory> directories = new HashMap<>();

    public Map<String, Directory> getDirectories() 
    {
        return directories;
    }

    public Directory search(String dirName)
    {
        if (dirName.equals("/"))
            return this;
        if (directories.size() == 0)
            return null;
        for (String name : directories.keySet())
            if (name.equals(dirName))
                return directories.get(name);
            else if (directories.get(name).search(dirName) != null)
                return directories.get(name).search(dirName);
        return null;
    }

    public Directory(Iterator<String> aocInput)
    {

        /* A directory listing consists of several parts.
         * 
         * First there's a list command, which is skipped by the parent
         * directory. The parsing of this directory starts from the first
         * line of the contents.
         * 
         * Next there's the contents of this directory. The names of the
         * directories can be skipped for now, because they will be read later
         * with their own instance of a Directory class.
         * 
         * There are three possibilities after the end of the contents of a
         * directory:
         * 
         * There is no more input, in which case the parsing is done and
         * we can return to the parent.
         * 
         * There is an other subdirectory to read in which case we create an 
         * other Directory object, and skip the ls-command.
         * 
         * There is a cd .. command, which prompts our return to the parent.
         */

        String line = aocInput.next();
        while (!line.startsWith("$")) {
            if (!line.startsWith("dir"))
                totalSizeOfFiles += Long.valueOf(line.split(" ")[0]);
            line = aocInput.hasNext() ? aocInput.next() : "$";
        }
        if (!aocInput.hasNext())
            return;
        while (!line.contains("..")) {
            String directoryName = line.split(" ")[2];
            line = aocInput.next();
//            line = aocInput.next(); // skip $ ls 
            Directory child = new Directory(aocInput);
            directories.put(directoryName, child);
            line = aocInput.hasNext() ? aocInput.next() : "..";
        }
        System.out.print("");
    }

    public Long size()
    {
        Long size = totalSizeOfFiles;
        for (String dirName : directories.keySet())
            size += directories.get(dirName).size();
        return size;
    }
    
}
