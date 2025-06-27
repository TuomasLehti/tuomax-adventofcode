package fi.tuomax.adventofcode.year2017.day20;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 20, part 1:
 * Particle Swarm.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/20">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ParticleSwarm_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 20, 1,
            "Particle Swarm", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new ParticleSwarm_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Particle> particles = ((ParticleSwarm_Parser) parser).getParticles();
        Long slowestAcceleration = Long.MAX_VALUE;
        Integer closestIdx = 0;
        for (int idx = 0; idx < particles.size(); idx++) {
            Long dist = particles.get(idx).getAcceleration().taxiCabDistance();
            if (dist < slowestAcceleration) {
                slowestAcceleration = dist;
                closestIdx = idx;
            }
        }
        setAnswer(closestIdx);
    }

}
