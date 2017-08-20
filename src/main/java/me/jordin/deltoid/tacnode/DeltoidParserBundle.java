package me.jordin.deltoid.tacnode;

import com.google.common.collect.ImmutableMap;
import me.jordin.deltoid.tacnode.parsers.RotationParser;
import me.jordin.deltoid.tacnode.parsers.Vec2Parser;
import me.jordin.deltoid.tacnode.parsers.Vec3Parser;
import me.jordin.deltoid.vector.Rotation;
import me.jordin.deltoid.vector.Vec2;
import me.jordin.deltoid.vector.Vec3;
import me.jordin.tacnode.parsers.ArgumentParser;
import me.jordin.tacnode.parsers.ArgumentParserBundle;

import java.util.Map;

/**
 * Created by Jordin on 8/20/2017.
 * Jordin is still best hacker.
 */
public class DeltoidParserBundle implements ArgumentParserBundle {
    @Override
    public Map<Class<?>, ArgumentParser<?>> getParsers() {
        return ImmutableMap.<Class<?>, ArgumentParser<?>>builder()
                .put(Rotation.class, new RotationParser())
                .put(Vec2.class, new Vec2Parser())
                .put(Vec3.class, new Vec3Parser())
                .build();
    }
}
