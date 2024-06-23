package fi.tuomax.adventofcode.year2015.day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;
import fi.tuomax.adventofcode.year2015.day22.spells.Spell;

public class GameState 
{

    public static Map<String, Spell> spells = new HashMap<>();

    public static Hero player;

    public static Boss opponent;

    public static List<String> visited = new ArrayList<>();

    public static String saveState()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(GameState.player.saveState());
        sb.append(";");
        sb.append(GameState.opponent.saveState());
        sb.append(";");

        for (String playerSpells : GameState.spells.keySet()) {
            sb.append(playerSpells);
            sb.append(":");
            sb.append(GameState.spells.get(playerSpells).saveState());
            sb.append(";");
        }

        return sb.toString();
    }

    public static void restoreState(String state)
    {
        String[] parts = state.split(";");
        GameState.player.restoreState(parts[0]);
        GameState.opponent.restoreState(parts[1]);

        for (int idx = 2; idx < parts.length; idx++) {
            String[] partss = parts[idx].split(":");
            GameState.spells.get(partss[0]).restoreState(partss[1]);
        }
        
    }

    public static void reset()
    {
        spells.clear();
        visited.clear();
        player = null;
        opponent = null;
    }
    
}
