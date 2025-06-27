package fi.tuomax.adventofcode.year2017.day20;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class ParticleSwarm_Parser
extends Parser
{

    List<Particle> particles = new ArrayList<>();

    public List<Particle> getParticles() 
    {
        return particles;
    }

    public ParticleSwarm_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input)
            particles.add(Particle.fromAocInput(line));
    }

}
