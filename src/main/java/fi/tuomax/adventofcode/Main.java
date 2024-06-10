package fi.tuomax.adventofcode;

import org.fusesource.jansi.AnsiConsole;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Main 
{

    public static void main(String[] args) 
    {
        AnsiConsole.systemInstall();
        Settings settings = manufactureSettings(args);
        new AdventOfCode().run(settings);
        AnsiConsole.systemUninstall();
    }

    private static Settings manufactureSettings(String[] args) 
    {
        RunMode runMode = null;
        Metadata metadata = null;
        if (args[0].equals("--latest")) {
            runMode = RunMode.LATEST;
        } else if (args[0].startsWith("--year")) {
            runMode = RunMode.YEAR;
            metadata = new Metadata(
                Integer.valueOf(args[0].substring(args[0].indexOf("=")+1)), 
                null, null, null, null);
        }
        return new Settings(metadata, runMode);
    }
    
}
