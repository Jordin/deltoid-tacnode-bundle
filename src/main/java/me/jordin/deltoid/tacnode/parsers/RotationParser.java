package me.jordin.deltoid.tacnode.parsers;

import me.jordin.deltoid.vector.Rotation;
import me.jordin.tacnode.exceptions.InvalidTypeException;
import me.jordin.tacnode.parsers.ArgumentParser;
import me.jordin.tacnode.util.CommonSuggestions;

import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Jordin on 8/9/2017.
 * Jordin is still best hacker.
 */
public class RotationParser implements ArgumentParser<Rotation> {
    private static final Supplier<Rotation> ORIGIN = () -> Rotation.ORIGIN;
    private Supplier<Rotation> relativeTo;

    private boolean includeRoll;

    public RotationParser() {
        this(ORIGIN);
    }

    public RotationParser(Supplier<Rotation> relativeTo) {
        this(relativeTo, false);
    }

    
    public RotationParser(boolean includeRoll) {
        this(ORIGIN, includeRoll);
    }
    
    public RotationParser(Supplier<Rotation> relativeTo, boolean includeRoll) {
        this.relativeTo = relativeTo;
        this.includeRoll = includeRoll;
    }

    @Override
    public Rotation parse(Iterator<String> arguments) throws InvalidTypeException {
        Rotation relativeTo = this.relativeTo.get();
        try {
            double yaw = RelativeCoordinateParser.parseCoordinate(arguments.next(), relativeTo.rotationYaw);
            double pitch = RelativeCoordinateParser.parseCoordinate(arguments.next(), relativeTo.rotationPitch);
            double roll = this.includeRoll ? RelativeCoordinateParser.parseCoordinate(arguments.next(), relativeTo.rotationRoll) : 0;
            return new Rotation(yaw, pitch, roll);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidTypeException("Rotation", numberFormatException);
        }
    }

    @Override
    public int minimumArgsRequired() {
        return includeRoll ? 3 : 2;
    }

    @Override
    public List<String> provideSuggestions() {
        return CommonSuggestions.TILDE;
    }
}
