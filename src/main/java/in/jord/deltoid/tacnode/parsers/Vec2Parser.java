package in.jord.deltoid.tacnode.parsers;

import in.jord.deltoid.vector.Vec2;
import in.jord.tacnode.exceptions.InvalidTypeException;
import in.jord.tacnode.parsers.ArgumentParser;
import in.jord.tacnode.util.CommonSuggestions;

import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class Vec2Parser implements ArgumentParser<Vec2> {
    private static final Supplier<Vec2> ORIGIN = () -> Vec2.ORIGIN;

    private Supplier<Vec2> relativeTo;

    public Vec2Parser() {
        this(ORIGIN);
    }

    public Vec2Parser(Supplier<Vec2> relativeTo) {
        this.relativeTo = relativeTo;
    }

    @Override
    public Vec2 parse(Iterator<String> arguments) throws InvalidTypeException {
        Vec2 relativeTo = this.relativeTo.get();
        try {
            double x = RelativeCoordinateParser.parseCoordinate(arguments.next(), relativeTo.x);
            double y = RelativeCoordinateParser.parseCoordinate(arguments.next(), relativeTo.y);
            return new Vec2(x, y);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidTypeException("Vec2", numberFormatException);
        }
    }

    @Override
    public int minimumArgsRequired() {
        return 2;
    }

    @Override
    public List<String> provideSuggestions() {
        return CommonSuggestions.TILDE;
    }
}
