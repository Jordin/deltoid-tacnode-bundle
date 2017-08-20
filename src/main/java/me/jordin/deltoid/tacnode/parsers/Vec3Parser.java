package me.jordin.deltoid.tacnode.parsers;

import me.jordin.deltoid.vector.Vec3;
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
public class Vec3Parser implements ArgumentParser<Vec3> {
    private static final Supplier<Vec3> ORIGIN = () -> Vec3.ORIGIN;

    private Supplier<Vec3> relativeTo;

    public Vec3Parser() {
        this(ORIGIN);
    }

    public Vec3Parser(Supplier<Vec3> relativeTo) {
        this.relativeTo = relativeTo;
    }

    @Override
    public Vec3 parse(Iterator<String> arguments) throws InvalidTypeException {
        Vec3 relativeTo = this.relativeTo.get();
        try {
            double x = RelativeCoordinateParser.parseCoordinate(arguments.next(), relativeTo.x);
            double y = RelativeCoordinateParser.parseCoordinate(arguments.next(), relativeTo.y);
            double z = RelativeCoordinateParser.parseCoordinate(arguments.next(), relativeTo.z);

            return new Vec3(x, y, z);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidTypeException("Vec3", numberFormatException);
        }
    }

    @Override
    public int minimumArgsRequired() {
        return 3;
    }

    @Override
    public List<String> provideSuggestions() {
        return CommonSuggestions.TILDE;
    }
}
