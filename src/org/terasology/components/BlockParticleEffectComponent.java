package org.terasology.components;

import com.google.common.collect.Lists;
import org.terasology.entitySystem.AbstractComponent;
import org.terasology.math.TeraMath;

import javax.vecmath.Vector2f;
import javax.vecmath.Vector3f;
import java.io.Serializable;
import java.util.List;

/**
 * @author Immortius <immortius@gmail.com>
 */
// TODO: Generalise for non-block particles
public class BlockParticleEffectComponent extends AbstractComponent {
    public byte blockType;
    public int spawnCount = 16;
    public boolean destroyEntityOnCompletion;

    // Initial conditions
    public Vector3f spawnRange = new Vector3f();
    public Vector3f initialVelocityRange = new Vector3f();
    public float minSize = 0.1f;
    public float maxSize = 1.0f;
    public float minLifespan = 0.0f;
    public float maxLifespan = 1.0f;
    
    // Lifetime conditions
    public Vector3f targetVelocity = new Vector3f();
    public Vector3f acceleration = new Vector3f();
    public boolean collideWithBlocks = false;

    public List<Particle> particles = Lists.newArrayList();

    public static class Particle implements Serializable, Cloneable {
        public Vector3f velocity = new Vector3f();
        public Vector3f position = new Vector3f();
        public float size = 1.0f;
        public float lifeRemaining = 1.0f;
        public Vector2f texOffset = new Vector2f(0,0);
        //public Vector2f texSize = new Vector2f(1,1);

        public Particle clone() {
            Particle particle = new Particle();
            particle.velocity.set(velocity);
            particle.position.set(position);
            particle.size = size;
            particle.lifeRemaining = lifeRemaining;
            particle.texOffset.set(texOffset);
            //particle.texSize.set(texSize);
            return particle;
        }
    }
}
