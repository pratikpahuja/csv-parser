package exercise.addressbookparser.parser;

import java.util.function.Function;

public interface CSVItemParser<R> extends Function<String, R> {
}
