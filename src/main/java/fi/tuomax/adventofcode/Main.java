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

        for (String arg : args) {
            if (arg.equals("--latest")) {
                runMode = RunMode.LATEST;
            } else if (arg.startsWith("--year")) {
                runMode = RunMode.YEAR;
                metadata = new Metadata(
                    Integer.valueOf(arg.substring(arg.indexOf("=")+1)), 
                    null, null, null, null);
            } else if (arg.startsWith("--day")) {
                runMode = RunMode.DAY;
                metadata = new Metadata(
                    metadata.year(),
                    Integer.valueOf(arg.substring(arg.indexOf("=")+1)),
                    null, null, null);
            }
    
        }

        return new Settings(metadata, runMode);
    }
    
}
