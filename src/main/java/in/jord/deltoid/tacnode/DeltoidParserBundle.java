package in.jord.deltoid.tacnode;

import com.google.common.collect.ImmutableMap;
import in.jord.deltoid.tacnode.parsers.RotationParser;
import in.jord.deltoid.tacnode.parsers.Vec2Parser;
import in.jord.deltoid.tacnode.parsers.Vec3Parser;
import in.jord.deltoid.vector.Rotation;
import in.jord.deltoid.vector.Vec2;
import in.jord.deltoid.vector.Vec3;
import in.jord.tacnode.parsers.ArgumentParser;
import in.jord.tacnode.parsers.ArgumentParserBundle;

import java.util.Map;

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
