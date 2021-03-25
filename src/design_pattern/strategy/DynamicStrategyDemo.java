package design_pattern.strategy;

import java.util.List;
import java.util.function.Supplier;

interface ListStrategy {
    default void start(StringBuilder sb) {}

    void addListItem(StringBuilder sb, String item);

    default void end(StringBuilder sb) {}
}

class MarkDownListStrategy implements ListStrategy {

    @Override
    public void addListItem(StringBuilder sb, String item) {
            sb.append(" * ").append(item).append(System.lineSeparator());
    }
}

class HtmlListStrategy implements ListStrategy {


    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul> ")
                .append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append("  <li> ")
                .append(item)
           .append(" </li>")
           .append(System.lineSeparator());
    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul> ")
                .append(System.lineSeparator());
    }
}

class TextProcessor<LS extends ListStrategy> {

    private StringBuilder sb = new StringBuilder();
    private LS listStrategy;

    public TextProcessor(Supplier<? extends LS> processor) {
        listStrategy = processor.get();
    }

    public void appendList(List<String> items) {
        listStrategy.start(sb);
        items.forEach(item -> {
            listStrategy.addListItem(sb, item);
        });
        listStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

public class DynamicStrategyDemo {

    public static void main(String[] args) {
        TextProcessor<MarkDownListStrategy> markDownProcessor = new TextProcessor<>(MarkDownListStrategy::new);
        TextProcessor<HtmlListStrategy> htmlProcessor = new TextProcessor<>(HtmlListStrategy::new);

        markDownProcessor.appendList(List.of("Sandeep", "Vibha", "Navya", "Kavya", "Naman"));
        System.out.println(markDownProcessor);

        htmlProcessor.appendList(List.of("Sandeep", "Vibha", "Navya", "Kavya", "Naman"));
        System.out.println(htmlProcessor);

    }
}
