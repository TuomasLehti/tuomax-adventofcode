package fi.tuomax.adventofcode.year2017.day20;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>Solves Advent of Code 2017, day 20, part 2:
 * Particle Swarm.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/20">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ParticleSwarm_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 20, 2,
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

        Map<Float, List<Collision>> collisions = new HashMap<>();
        for (int i = 0; i < particles.size() - 1; i++) {
            for (int j = i + 1; j < particles.size(); j++) {
                float collisionTime = particles.get(i).collidesWithAt(particles.get(j));
                if (collisionTime >= 0) {
                    if (!collisions.keySet().contains(collisionTime)) {
                        collisions.put(collisionTime, new ArrayList<Collision>());
                    }
                    collisions.get(collisionTime).add(new Collision(collisionTime, i, j));
                }
            }
        }

        Set<Integer> aliveIdxs = new HashSet<>();
        for (int i = 0; i < particles.size(); i++)
            aliveIdxs.add(i);

        List<Float> collisionTimes = new ArrayList<>(collisions.keySet());
        Collections.sort(collisionTimes);
        for (Float collisionTime : collisionTimes) {
            Set<Integer> collidedIdxs = new HashSet<>();
            for (Collision collision : collisions.get(collisionTime)) {
                if (
                    aliveIdxs.contains(collision.particleIdx()) &&
                    aliveIdxs.contains(collision.otherParticleIdx())
                ) {
                    collidedIdxs.add(collision.particleIdx());
                    collidedIdxs.add(collision.otherParticleIdx());
                }
            }
            aliveIdxs.removeAll(collidedIdxs);
        }
        setAnswer(aliveIdxs.size());
    }

    
}
