package com.rapleaf.jack.queries;

public class AggregatedColumn<T> extends Column<T> {

  private enum Function {
    COUNT, AVG, SUM, MAX, MIN
  }

  private final Function function;

  private AggregatedColumn(Column column, Function function) {
    super(column);
    this.function = function;
  }

  public static <T> AggregatedColumn<Integer> COUNT(Column<T> column) {
    return new AggregatedColumn<>(column.as(Integer.class), Function.COUNT);
  }

  public static <T extends Number> AggregatedColumn<Number> AVG(Column<T> column) {
    return new AggregatedColumn<>(column, Function.AVG);
  }

  public static <T extends Number> AggregatedColumn<T> SUM(Column<T> column) {
    return new AggregatedColumn<>(column, Function.SUM);
  }

  public static <T extends Number> AggregatedColumn<T> MAX(Column<T> column) {
    return new AggregatedColumn<>(column, Function.MAX);
  }

  public static <T extends Number> AggregatedColumn<T> MIN(Column<T> column) {
    return new AggregatedColumn<>(column, Function.MIN);
  }

  @Override
  public String getSqlKeyword() {
    return function.toString() + "(" + super.getSqlKeyword() + ")";
  }
}
